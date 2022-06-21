package core.service;

import core.exceptions.MagicException;
import core.model.Spell;
import core.model.validators.SpellValidator;
import core.repository.ICastedSpellRepository;
import core.repository.ISpellRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SpellServiceImpl implements ISpellService {
    public static final Logger logger = LoggerFactory.getLogger(SpellServiceImpl.class);

    @Autowired
    private ISpellRepository spellRepository;

    @Autowired
    private SpellValidator validator;

    @Autowired
    private ICastedSpellRepository castedSpellRepository;

    @Override
    public List<Spell> getAllSpells() {
        logger.trace("getAllSpells - method entered");
        List<Spell> spells = spellRepository.findAll();
        logger.trace("getAllSpells: " + spells);
        return spells;
    }

    @Override
    public Spell addSpell(String name, String description) {
        logger.trace("addSpell - method entered - name: " + name + " - description: " + description);
        Spell spell = new Spell(name, description);
        validator.validate(spell);
        var result = spellRepository.save(spell);
        logger.trace("addSpell - method finished");
        return result;
    }

    @Override
    public void deleteSpell(Long id) {
        logger.trace("deleteSpell - method entered - id: " + id);
        castedSpellRepository.findAll().stream()
                .filter(castedSpell -> castedSpell.getSpellId().equals(id))
                .findAny()
                .ifPresent(ticket -> {
                    throw new MagicException("The casted spell has a spell!");
                });
        spellRepository.findById(id).ifPresentOrElse((flight) ->spellRepository.deleteById(id),() -> {
            throw new MagicException("Spell does not exist");
        });

        logger.trace("deleteSpell - method finished");
    }

    @Override
    @Transactional
    public Spell updateSpell(Long id, String name, String description) {
        logger.trace("updateSpell - method entered - id: " + id + " - name: " + name + " - description: " + description);
        Spell spell = new Spell(name, description);
        spell.setId(id);
        validator.validate(spell);
        spellRepository.findById(id).ifPresentOrElse((spell1) -> {
            spell1.setName(name);
            spell1.setDescription(description);
        }, () -> {
            throw new MagicException("Spell does not exist!");
        });
        logger.trace("updateSpell - method finished");
        return spell;
    }
    @Override
    public List<Spell> findSpellsByName(String name) {
        logger.trace("findSpellsByName - method entered - name = {}", name);
        var result = spellRepository.findAllByName(name);
        logger.trace("findSpellsByName - method finished - result = {}", result);
        return result;
    }

}
