package spacevil.test.model.weapons;

import lombok.Data;

@Data
public abstract class Weapon {
    private String name;
    private Integer damage;
}
