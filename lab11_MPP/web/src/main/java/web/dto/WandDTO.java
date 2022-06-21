package web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
public class WandDTO extends BaseDTO<Long>{
    private Long wizardId;
    private String name;
    private Integer strength;
    @Override
    public String toString() {
        return "WandDTO{" +
                "wizardId=" + wizardId +
                ", name='" + name + '\'' +
                ", strength=" + strength +
                ", id=" + id +
                '}';
    }
}



