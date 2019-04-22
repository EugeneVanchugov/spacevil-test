package spacevil.test.model;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import spacevil.test.model.armors.Armor;
import spacevil.test.model.armors.NoArmor;
import spacevil.test.model.weapons.Fists;
import spacevil.test.model.weapons.Weapon;

import java.util.HashMap;
import java.util.Map;

@Data
public class Character {

    private String name;
    private Race race;
    private CharacterClass charClass;
    private BaseCharacteristics baseCharacteristics;
    private AdditionalCharacteristics additionalCharacteristics;
    private Map<BodyPart, Armor> armorByBodyPart;
    private Weapon weapon;
    private Integer level;

    @Builder
    public Character(String name, Race race, CharacterClass charClass,
                     int agility, int strength, int intelligence) {
        this(name, race, charClass, agility, strength, intelligence, 1);
    }

    public Character(String name, Race race, CharacterClass charClass,
                     int agility, int strength, int intelligence, Integer level) {

        this.name = name;
        this.race = race;
        this.charClass = charClass;
        this.level = level;
        this.weapon = new Fists();

        this.armorByBodyPart = new HashMap<>();
        this.armorByBodyPart.put(BodyPart.HEAD, new NoArmor());
        this.armorByBodyPart.put(BodyPart.LEFT_HAND, new NoArmor());
        this.armorByBodyPart.put(BodyPart.LEFT_LEG, new NoArmor());
        this.armorByBodyPart.put(BodyPart.RIGHT_HAND, new NoArmor());
        this.armorByBodyPart.put(BodyPart.RIGHT_LEG, new NoArmor());
        this.armorByBodyPart.put(BodyPart.TORSO, new NoArmor());

        this.baseCharacteristics = BaseCharacteristics.builder()
                .agility(agility)
                .intelligence(intelligence)
                .strength(strength)
                .build();

        this.additionalCharacteristics = AdditionalCharacteristics.builder()
                .health(calculateHealth())
                .mana(calculateMana())
                .build();
    }

    private int calculateMana() {
        return 500 + (100 * baseCharacteristics.getIntelligence()) + (50 * level);
    }

    private int calculateHealth() {
        return 40 + (level - 1) * 4;
    }

    public int getHealth() {
        return additionalCharacteristics.getHealth();
    }

    public int getMana() {
        return additionalCharacteristics.getMana();
    }

    public int getCritChance() {
        return additionalCharacteristics.getCritChance();
    }

    @Getter
    @Setter
    @Builder
    public static class BaseCharacteristics extends CharProperty {
        private Integer agility;
        private Integer strength;
        private Integer intelligence;
    }

    @Getter
    @Setter
    @Builder
    public static class AdditionalCharacteristics extends CharProperty {
        private Integer health;
        private Integer mana;
        private Integer critChance;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
