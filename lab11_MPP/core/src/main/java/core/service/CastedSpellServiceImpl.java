package core.service;



import core.exceptions.MagicException;
import core.model.CastedSpell;
import core.repository.ICastedSpellRepository;
import core.repository.ISpellRepository;
import core.repository.IWizardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import core.model.validators.CastedSpellValidator;


import java.util.List;

import static java.lang.Math.max;

@Service
public class CastedSpellServiceImpl implements ICastedSpellService {
    public static final Logger logger = LoggerFactory.getLogger(CastedSpellServiceImpl.class);

    @Autowired
    private CastedSpellValidator validator;
    @Autowired
    private ICastedSpellRepository castedSpellRepository;
    @Autowired
    private IWizardRepository wizardRepository;
    @Autowired
    private ISpellRepository spellRepository;


    @Override
    public List<CastedSpell> getAllCastedSpells() {
        logger.trace("getAllCastedSpells - method entered");
        List<CastedSpell> castedSpells = castedSpellRepository.findAll();
        logger.trace("getAllCastedSpells: " + castedSpells);
        return castedSpells;
    }

    @Override
    public CastedSpell addCastedSpell(Long wizardId, Long spellId, String details) {
        logger.trace("addCastedSpell - method entered - wizardId: "+ wizardId + " - spellId: " + spellId + " - details: " + details);
        wizardRepository.findById(wizardId)
                .ifPresentOrElse((wizard) -> {
                    spellRepository.findById(spellId)
                            .ifPresentOrElse((spell) -> {

                            }, () -> {
                                throw new MagicException("Spell does not exist!");
                            });
                }, () -> {
                    throw new MagicException("Wizard does not exist!");
                });

        CastedSpell castedSpell = new CastedSpell(wizardId, spellId, details);
        validator.validate(castedSpell);
        var result = castedSpellRepository.save(castedSpell);
        logger.trace("addCastedSpell - method finished");
        return result;

    }

    @Override
    public void deleteCastedSpell(Long id) {
        logger.trace("deleteCastedSpell - method entered - id: " + id);
        castedSpellRepository.findById(id).ifPresentOrElse((ticket) ->castedSpellRepository.deleteById(id),() -> {
            throw new MagicException("CastedSpell does not exist");
        });

        logger.trace("deleteCastedSpell - method finished");
    }

    @Override
    @Transactional
    public CastedSpell updateCastedSpell(Long id, Long wizardId, Long spellId, String details) {
        logger.trace("updateCastedSpell - method entered - id: " + id + " - wizardId: " + wizardId + " - spellId: " + spellId);
        CastedSpell castedSpell = new CastedSpell(wizardId, spellId, details);
        castedSpell.setId(id);
        validator.validate(castedSpell);
        castedSpellRepository.findById(id).ifPresentOrElse((castedSpell1) -> {
            wizardRepository.findById(wizardId).orElseThrow(() -> new MagicException("Wizard doesn't exist!"));
            spellRepository.findById(spellId).orElseThrow(() -> new MagicException("Spell doesn't exist!"));
            castedSpell1.setWizardId(wizardId);
            castedSpell1.setSpellId(spellId);
            castedSpell1.setDetails(details);
        }, () -> {
            throw new MagicException("CastedSpell does not exist!");
        });
        logger.trace("updateCastedSpell - method finished");
        return castedSpell;
    }

}
