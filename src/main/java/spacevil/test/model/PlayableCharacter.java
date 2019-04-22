package spacevil.test.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PlayableCharacter extends Character {

    private Integer experience;
    private Integer level;
    private Integer money;

    @Builder(builderMethodName = "playable")
    public PlayableCharacter(String name, Race race, CharacterClass charClass,
                             int agility, int strength, int intelligence) {

        super(name, race, charClass, agility, strength, intelligence);
        super.setLevel(1);

        this.experience = 0;
        this.money = 0;
    }
}
