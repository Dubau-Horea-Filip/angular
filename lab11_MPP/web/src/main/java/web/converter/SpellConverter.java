package web.converter;

import org.springframework.stereotype.Component;
import core.model.Spell;
import web.dto.SpellDTO;

@Component
public class SpellConverter extends BaseConverter<Long, Spell, SpellDTO> {
    @Override
    public Spell convertDtoToModel(SpellDTO dto) {
        var model = new Spell();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        return model;
    }

    @Override
    public SpellDTO convertModelToDto(Spell spell) {
        var flightDTO = new SpellDTO(spell.getName(), spell.getDescription());
        flightDTO.setId(spell.getId());
        return flightDTO;
    }
}
