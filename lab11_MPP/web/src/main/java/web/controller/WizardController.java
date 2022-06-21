package web.controller;

import core.model.Wand;
import core.service.IWandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import core.model.Wizard;
import core.service.IWizardService;
import web.converter.WizardConverter;
import web.dto.WizardDTO;
import web.dto.WizardWandDTO;
import web.dto.WizardsDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WizardController {
    public static final Logger logger = LoggerFactory.getLogger(WizardController.class);

    @Autowired
    private IWizardService wizardService;
    @Autowired
    WizardConverter wizardConverter;

    @Autowired
    private IWandService wandService;

    @RequestMapping(value = "/wizards")
    WizardsDTO getWizardsFromRepository() {
        logger.trace("getAllWizards - method entered");
        List<Wizard> wizards = wizardService.getAllWizards();
        WizardsDTO wizardsDTO = new WizardsDTO(wizardConverter.convertModelsToDTOs(wizards));
        logger.trace("getAllWizards: " + wizards);
        return wizardsDTO;
    }

    @RequestMapping(value = "/wizards", method = RequestMethod.POST)
    WizardDTO addWizard(@RequestBody WizardDTO wizardDTO) {
        logger.trace("addWizard - method entered - WizardDTO: " + wizardDTO);
        var wizard = wizardConverter.convertDtoToModel(wizardDTO);
        var result = wizardService.addWizard(wizard.getName(), wizard.getAge(), wizard.getPet());
        var resultModel = wizardConverter.convertModelToDto(result);
        logger.trace("addWizard - wizard added");
        return resultModel;
    }

    @RequestMapping(value = "/wizards/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteWizard(@PathVariable Long id) {
        wizardService.deleteWizard(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/wizards/{id}", method = RequestMethod.PUT)
    WizardDTO updateWizard(@PathVariable Long id, @RequestBody WizardDTO wizardDTO) {
        logger.trace("updateWizard - method entered - WizardDTO: " + wizardDTO);
        var wizard = wizardConverter.convertDtoToModel(wizardDTO);
        var result = wizardService.updateWizard(id, wizard.getName(), wizard.getAge(), wizard.getPet());
        var resultModel = wizardConverter.convertModelToDto(result);
        logger.trace("updateWizard - wizard updated");
        return resultModel;
    }

    @RequestMapping(value = "/wizards/filter/{name}")
    WizardsDTO findWizardByName(@PathVariable String name) {
        logger.trace("findWizardByName - method entered - name = {}", name);
        List<Wizard> wizards = wizardService.findWizardsByName(name);
        WizardsDTO wizardsDTO = new WizardsDTO(wizardConverter.convertModelsToDTOs(wizards));
        logger.trace("getAllWizards: " + wizards);
        return wizardsDTO;
    }

    @RequestMapping(value = "wizards/wands", method = RequestMethod.GET)
    List<WizardWandDTO> getWandsForWizards() {
        List<WizardWandDTO> result = new ArrayList<>();
        for(Wizard wizard: wizardService.getAllWizards()) {
            var nrWands = 0;
            for(Wand wand: wandService.getAllWands()) {
                if (wand.getWizardId().equals(wizard.getId())) {
                    nrWands += 1;
                }
            }
            result.add(new WizardWandDTO(wizard.getName(), nrWands));
        }
        return result;
    }

    @RequestMapping(value = "wizards/filter/before/{age}", method = RequestMethod.GET)
    WizardsDTO getWizardsBeforeAge(@PathVariable String age) {
        List<Wizard> wizards = wizardService.findAllByAgeBefore(Integer.parseInt(age));
        WizardsDTO wizardsDTO = new WizardsDTO(wizardConverter.convertModelsToDTOs(wizards));
        return wizardsDTO;
    }

    @RequestMapping(value = "wizards/filter/after/{age}", method = RequestMethod.GET)
    WizardsDTO getWizardsAfterAge(@PathVariable String age) {
        List<Wizard> wizards = wizardService.findAllByAgeAfter(Integer.parseInt(age));
        WizardsDTO wizardsDTO = new WizardsDTO(wizardConverter.convertModelsToDTOs(wizards));
        return wizardsDTO;
    }



}
