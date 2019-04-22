package spacevil.test.model.armors;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NoArmor extends Armor {

    public NoArmor() {
        this.setDefense(0);
        this.setName("NO ARMOR");
    }
}
