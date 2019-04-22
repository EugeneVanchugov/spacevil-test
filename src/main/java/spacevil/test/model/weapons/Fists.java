package spacevil.test.model.weapons;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Fists extends Weapon {

    public Fists() {
        this.setDamage(10);
        this.setName("Fists");
    }
}
