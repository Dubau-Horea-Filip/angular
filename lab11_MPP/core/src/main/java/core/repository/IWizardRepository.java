package core.repository;
import core.model.Wizard;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IWizardRepository extends IRepository<Wizard, Long>{
    List<Wizard> findAllByName(String name);


    List<Wizard> findAllByAgeAfter(Integer age);
    List<Wizard> findAllByAgeBefore(Integer age);


    List<Wizard> findAllByAgeBeforeOrderByAgeDesc(Integer age);
    List<Wizard> findAllByAgeAfterOrderByAgeDesc(Integer age);


    List<Wizard> findAllByAgeAfterOrAgeEqualsOrderByAgeDesc(Integer age, Integer age2);

    //EqualsoOrderByAgeAgeDesc(Integer age);
    // AfterAndAgeContainingOrderByAgeAgeDesc(Integer age);
    //OrderByAgeAgeDesc(Integer age);


}
