package core.service;

import core.exceptions.MagicException;
import core.model.Wizard;
import core.model.validators.WizardValidator;
import core.repository.ICastedSpellRepository;
import core.repository.IWizardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class WizardServiceImpl implements IWizardService {
    public static final Logger logger = LoggerFactory.getLogger(WizardServiceImpl.class);

    @Autowired
    private WizardValidator validator;
    @Autowired
    private IWizardRepository wizardRepository;
    @Autowired
    private ICastedSpellRepository CastedSpellRepository;


    @Override
    public List<Wizard> getAllWizards() {
        logger.trace("getAllWizards - method entered");
        List<Wizard> wizards = wizardRepository.findAll();
        logger.trace("getAllWizards: " + wizards);
        return wizards;
    }

    @Override
    public Wizard addWizard(String name, Integer age, String pet) {
        logger.trace("addWizard - method entered - name: " + name + " - age: " + age + " - pet: " + pet);
        Wizard newWizard = new Wizard(name, age, pet);
        validator.validate(newWizard);
        var wizard = wizardRepository.save(newWizard);
        logger.trace("AddWizard - method finished");
        return wizard;
    }

    @Override
    public void deleteWizard(Long id) {
        logger.trace("deleteWizard - method entered - id: " + id);
        CastedSpellRepository.findAll().stream()
                .filter(castedSpell -> castedSpell.getWizardId().equals(id))
                .findAny()
                .ifPresent(castedSpell -> {
                    throw new MagicException("The wizard has a casted spell!");
                });


        wizardRepository.findById(id).ifPresentOrElse((wizard) -> wizardRepository.deleteById(id), () ->{
            throw new MagicException("Wizard does not exist!");
        });
        logger.trace("deleteWizard - method finished");
    }

    @Override
    @Transactional
    public Wizard updateWizard(Long id, String name, Integer age, String pet) {
        logger.trace("updateWizard - method entered - id: " + id + " - name: " + name + " - age: " + age + " - pet: " + pet);
        Wizard wizard = new Wizard(name, age, pet);
        wizard.setId(id);
        validator.validate(wizard);
        wizardRepository.findById(id).ifPresentOrElse((wizard1) -> {
            wizard1.setName(name);
            wizard1.setAge(age);
            wizard1.setPet(pet);
        }, () -> {
            throw new MagicException("Wizard does not exist!");
        });
        logger.trace("updateWizard - method finished");
        return wizard;
    }

    @Override
    public List<Wizard> findWizardsByName(String name) {
        logger.trace("findWizardsByName - method entered - name = {}", name);
        var result = wizardRepository.findAllByName(name);
        logger.trace("findWizardsByName - method finished - result = {}", result);
        return result;
    }

    @Override
    public List<Wizard> findAllByAgeBefore(int age) {
        var result = wizardRepository.findAllByAgeBeforeOrderByAgeDesc(age);
        return result;
    }

    @Override
    public List<Wizard> findAllByAgeAfter(int age) {
        var result = wizardRepository.findAllByAgeAfterOrAgeEqualsOrderByAgeDesc(age,age);
        return result;
    }



}
