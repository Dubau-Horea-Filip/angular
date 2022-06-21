package core.service;

import core.model.Wizard;


import java.util.List;

public interface IWizardService {
    List<Wizard> getAllWizards();
    Wizard addWizard(String name, Integer age, String pet);
    void deleteWizard(Long id);
    Wizard updateWizard(Long id, String name, Integer age, String pet);
    List<Wizard> findWizardsByName(String name);

    List<Wizard> findAllByAgeBefore(int age);

    List<Wizard> findAllByAgeAfter(int age);
}
