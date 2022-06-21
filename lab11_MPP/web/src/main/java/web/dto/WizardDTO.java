package web.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WizardDTO extends BaseDTO<Long>{
    private String name;
    private Integer age;
    private String pet;
}
