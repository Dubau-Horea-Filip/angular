package core.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wizards")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Wizard extends BaseEntity<Long>{
    private String name;
    private Integer age;
    private String pet;
}
