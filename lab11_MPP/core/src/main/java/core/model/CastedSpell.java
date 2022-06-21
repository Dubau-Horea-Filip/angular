package core.model;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "casted_spells")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CastedSpell extends BaseEntity<Long>{
    private Long wizardId;
    private Long spellId;
    private String details;
}
