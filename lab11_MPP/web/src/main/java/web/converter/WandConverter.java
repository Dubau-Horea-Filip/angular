package web.converter;
import core.model.Wand;
import org.springframework.stereotype.Component;
import web.dto.WandDTO;
@Component
public class WandConverter extends BaseConverter<Long, Wand, WandDTO>{
    

    @Override
    public Wand convertDtoToModel(WandDTO dto) {
        var model = new Wand();
        model.setId(dto.getId());
        model.setWizardId(dto.getWizardId());
        model.setName(dto.getName());
        model.setStrength(dto.getStrength());
        return model;
    }

    @Override
    public WandDTO convertModelToDto(Wand wand) {
        var WandDTO = new WandDTO(wand.getWizardId(), wand.getName(), wand.getStrength());
        WandDTO.setId(wand.getId());
        return WandDTO;
    }
}
