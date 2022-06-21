package web.dto;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CastedSpellDTO extends BaseDTO<Long>{
    private Long wizardId, spellId;
    private String details;

}
