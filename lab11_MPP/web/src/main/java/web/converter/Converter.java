package web.converter;

import core.model.BaseEntity;
import web.dto.BaseDTO;

import java.io.Serializable;

public interface Converter<ID extends Serializable, Model extends BaseEntity<ID>, DTO extends BaseDTO<ID>> {
    Model convertDtoToModel(DTO dto);
    DTO convertModelToDto(Model model);
}