package core.repository;

import core.model.Wand;
import java.util.List;

public interface IWandRepository extends IRepository<Wand, Long> {
    
    List<Wand> findAllByOrderByStrengthDesc();


}