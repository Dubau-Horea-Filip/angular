package web.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WizardWandDTO extends BaseDTO<Long>{
    private String wizardName;
    private Integer noWands;
}
