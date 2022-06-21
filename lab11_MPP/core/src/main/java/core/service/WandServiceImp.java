package core.service;

import core.exceptions.MagicException;
import core.model.Wand;
import core.model.validators.WandValidator;
import core.repository.IWandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WandServiceImp implements IWandService{
    public static final Logger logger = LoggerFactory.getLogger(WandServiceImp.class);

    @Autowired
    private WandValidator validator;
    @Autowired
    private IWandRepository wandRepository;
    

    @Override
    public List<Wand> getAllWands() {
        logger.trace("getAllWands - method entered");
        List<Wand> wands = wandRepository.findAll();
        logger.trace("getAlWands: " + wands);
        return wands;
    }

    @Override
    public Wand addWand(Long wizardId, String name, Integer strength) {
        logger.trace("addWand - method entered - wizardId: " + wizardId + " - name: " + name + " - strength: " + strength );
        Wand wand = new Wand(wizardId, name, strength);
        validator.validate(wand);
        var result = wandRepository.save(wand);
        logger.trace("addWand - method finished");
        return result;
    }

    @Override
    public void deleteWand(Long id) {
        logger.trace("deleteWand - method entered - id: " + id);
        wandRepository.findById(id)
                .ifPresentOrElse((Wand) -> wandRepository.deleteById(id),
                        () -> {
                            throw new MagicException("Wand does not exist!");
                        });
        logger.trace("deleteWand - method finished");

    }

    @Override
    @Transactional
    public Wand updateWand(Long id, Long wizardId, String name, Integer strength) {
        logger.trace("updateWand - method entered - id: " + id + " - wizardId: " + wizardId + " - name: " + name + " - strength: " + strength );
        Wand wand = new Wand(wizardId, name, strength);
        wand.setId(id);
        validator.validate(wand);
        wandRepository.findById(id)
                .ifPresentOrElse((wand1) -> {
                    wand1.setWizardId(wizardId);
                    wand1.setName(name);
                    wand1.setStrength(strength);
                }, () -> {
                    throw new MagicException("Wand does not exist!");
                });
        logger.trace("updateWand - method finished");
        return wand;
    }

    @Override
    public List<Wand> findAllOrderBystrength() {
        logger.trace("findAllOrderBystrength - method entered");
        var wands = wandRepository.findAllByOrderByStrengthDesc();

        logger.trace("findAllOrderBystrength - result = {}", wands);
        return wands;
    }
}
