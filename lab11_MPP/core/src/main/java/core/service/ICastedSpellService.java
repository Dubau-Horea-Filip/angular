package core.service;

import core.model.CastedSpell;


import java.util.List;

public interface ICastedSpellService {
    List<CastedSpell> getAllCastedSpells();
    CastedSpell addCastedSpell(Long wizardId, Long spellId, String details);
    void deleteCastedSpell(Long id);
    CastedSpell updateCastedSpell(Long id, Long wizardId, Long spellId, String details);

}
