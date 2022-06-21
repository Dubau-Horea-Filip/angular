package core.repository;

import core.model.CastedSpell;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ICastedSpellRepository extends IRepository<CastedSpell, Long> {

}