package core.service;

import core.model.Spell;
import core.model.Wizard;


import java.sql.Timestamp;
import java.util.List;

public interface ISpellService {
    List<Spell> getAllSpells();
    Spell addSpell(String name, String description);
    void deleteSpell(Long id);
    Spell updateSpell(Long id, String name, String description);
    List<Spell> findSpellsByName(String name);

}
