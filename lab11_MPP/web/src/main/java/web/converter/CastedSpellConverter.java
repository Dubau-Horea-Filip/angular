package web.converter;

import core.model.CastedSpell;
import org.springframework.stereotype.Component;
import web.dto.CastedSpellDTO;


@Component
public class CastedSpellConverter extends BaseConverter<Long, CastedSpell, CastedSpellDTO> {

    @Override
    public CastedSpell convertDtoToModel(CastedSpellDTO dto) {
        var model = new CastedSpell();
        model.setId(dto.getId());
        model.setWizardId(dto.getWizardId());
        model.setSpellId(dto.getSpellId());
        model.setDetails(dto.getDetails());
        return model;
    }

    @Override
    public CastedSpellDTO convertModelToDto(CastedSpell castedSpell) {
        var ticketDTO = new CastedSpellDTO(castedSpell.getWizardId(), castedSpell.getSpellId(), castedSpell.getDetails());
        ticketDTO.setId(castedSpell.getId());
        return ticketDTO;
    }
}
