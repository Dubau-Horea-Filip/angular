package web.dto;
import lombok.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpellDTO extends BaseDTO<Long>{
    private String name,description;
}
