package web.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import core.model.Spell;
import core.model.Wizard;
import core.service.ISpellService;
import web.converter.SpellConverter;
import web.dto.SpellDTO;
import web.dto.SpellsDTO;
import web.dto.WizardsDTO;

import java.util.List;

@RestController
public class SpellController {
    public static final Logger logger = LoggerFactory.getLogger(SpellController.class);

    @Autowired
    private ISpellService spellService;

    @Autowired
    SpellConverter spellConverter;

    @RequestMapping(value = "/spells")
    SpellsDTO getSpellsFromRepository() {
        logger.trace("getAllSpells - method entered");
        List<Spell> spells = spellService.getAllSpells();
        SpellsDTO spellsDTO = new SpellsDTO(spellConverter.convertModelsToDTOs(spells));
        logger.trace("getAllSpells: " + spells);
        return spellsDTO;
    }

    @RequestMapping(value = "/spells", method = RequestMethod.POST)
    SpellDTO addSpell(@RequestBody SpellDTO spellDTO) {
        logger.trace("addSpell - method entered - SpellDTO: " + spellDTO);
        var spell = spellConverter.convertDtoToModel(spellDTO);
        var result = spellService.addSpell(spell.getName(), spell.getDescription());
        var resultModel = spellConverter.convertModelToDto(result);
        logger.trace("addSpell - Spell added");
        return resultModel;
    }

    @RequestMapping(value = "/spells/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteSpell(@PathVariable Long id) {
        spellService.deleteSpell(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/spells/{id}", method = RequestMethod.PUT)
    SpellDTO updateSpell(@PathVariable Long id, @RequestBody SpellDTO spellDTO) {
        logger.trace("updateSpell - method entered - SpellDTO: " + spellDTO);
        var spell = spellConverter.convertDtoToModel(spellDTO);
        var result = spellService.updateSpell(id, spell.getName(), spell.getDescription());
        var resultModel = spellConverter.convertModelToDto(result);
        logger.trace("updateSpell - Spell updated");
        return resultModel;
    }
    @RequestMapping(value = "/spells/filter/{name}")
    SpellsDTO findSpellByName(@PathVariable String name) {
        logger.trace("findSpellByName - method entered - name = {}", name);
        List<Spell> spells = spellService.findSpellsByName(name);
        SpellsDTO spellsDTO = new SpellsDTO(spellConverter.convertModelsToDTOs(spells));
        logger.trace("getAllSpells: " + spells);
        return spellsDTO;
    }

}
