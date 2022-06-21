package core.model;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Wand")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Wand extends BaseEntity<Long> {
    private Long wizardId;
    private String name;
    private Integer strength;
}
