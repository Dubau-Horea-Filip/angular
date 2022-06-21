package web.controller;


import core.model.Wand;
import core.service.IWandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.converter.WandConverter;
import web.dto.WandDTO;
import web.dto.WandsDTO;


import java.util.List;

@RestController
public class WandController {
    public static final Logger logger = LoggerFactory.getLogger(WandController.class);

    @Autowired
    private IWandService wandService;

    @Autowired
    private WandConverter wandConverter;

    @RequestMapping(value = "/wands")
    WandsDTO getWandsFromRepository() {
        logger.trace("getWandsFromRepository - method entered");
        List<Wand> wands = wandService.getAllWands();
        WandsDTO wandsDTO = new WandsDTO(wandConverter.convertModelsToDTOs(wands));
        logger.trace("getWandsFromRepository: " + wandsDTO);
        return wandsDTO;
    }

    @RequestMapping(value = "/wands", method = RequestMethod.POST)
    WandDTO addWand(@RequestBody WandDTO wandDTO) {
        logger.trace("addWand - method entered - WandDTO: " + wandDTO);
        var wand = wandConverter.convertDtoToModel(wandDTO);
        var result = wandService.addWand(wand.getWizardId(), wand.getName(), wand.getStrength());
        var resultModel = wandConverter.convertModelToDto(result);
        logger.trace("addWand - Wand added");
        return resultModel;
    }

    @RequestMapping(value = "/wands/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteWand(@PathVariable Long id) {
        wandService.deleteWand(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/wands/{id}", method = RequestMethod.PUT)
    WandDTO updateWand(@PathVariable Long id, @RequestBody WandDTO wandDTO) {
        logger.trace("updateWand - method entered -WandDTO: " + wandDTO);
        var wand = wandConverter.convertDtoToModel(wandDTO);
        var result = wandService.updateWand(id, wand.getWizardId(), wand.getName(), wand.getStrength());
        var resultModel = wandConverter.convertModelToDto(result);
        logger.trace("updateWand - wand updated");
        return resultModel;
    }

    @RequestMapping(value = "/wands/sort/strength")

    WandsDTO getWandsSortedByStrength() {
        logger.trace("getWandsSortedByStrength - method entered");
        List<Wand> wands = wandService.findAllOrderBystrength();
        WandsDTO wizardsDTO = new WandsDTO(wandConverter.convertModelsToDTOs(wands));
        logger.trace("getWandsSortedByStrength: " + wands);
        return wizardsDTO;
    }
}
