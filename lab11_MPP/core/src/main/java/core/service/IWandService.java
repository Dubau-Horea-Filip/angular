package core.service;

import core.model.Wand;

import java.util.List;

//Long wizardId;
//    private String name;
//    private Integer strength;
public interface IWandService {

    List<Wand> getAllWands();
    
    Wand addWand(Long wizardId, String name, Integer strength);
    
    void deleteWand(Long id);
    Wand updateWand(Long id, Long wizardId, String name, Integer strength);
    List<Wand> findAllOrderBystrength();

}
