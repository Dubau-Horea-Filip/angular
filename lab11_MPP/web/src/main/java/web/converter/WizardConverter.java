package web.converter;

import org.springframework.stereotype.Component;
import core.model.Wizard;
import web.dto.WizardDTO;

@Component
public class WizardConverter extends BaseConverter<Long, Wizard, WizardDTO> {
    @Override
    public Wizard convertDtoToModel(WizardDTO dto) {
        var model = new Wizard();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setAge(dto.getAge());
        model.setPet(dto.getPet());
        return model;
    }

    @Override
    public WizardDTO convertModelToDto(Wizard wizard) {
        var customerDTO = new WizardDTO(wizard.getName(), wizard.getAge(), wizard.getPet());
        customerDTO.setId(wizard.getId());
        return customerDTO;
    }
}
