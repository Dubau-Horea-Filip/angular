package core.repository;
import core.model.Spell;
import core.model.Wizard;


import java.util.List;


public interface ISpellRepository extends IRepository<Spell, Long>{
    List<Spell> findAllByName(String name);

}
