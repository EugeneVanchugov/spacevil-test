package spacevil.test.elements;

import com.spvessel.spacevil.*;
import com.spvessel.spacevil.Common.DefaultsService;
import com.spvessel.spacevil.Decorations.CustomFigure;
import com.spvessel.spacevil.Decorations.ItemState;
import com.spvessel.spacevil.Flags.*;
import com.spvessel.spacevil.Label;
import org.lwjgl.system.windows.POINT;
import spacevil.test.model.Character;

import java.awt.*;

public class CharacterCard extends Prototype {

    private static int count = 0;

    private Label name;
    private Character character;

    public CharacterCard(Character character) {
        setItemName("CharItem_" + count);

        setSizePolicy(SizePolicy.EXPAND, SizePolicy.FIXED);
        setHeight(30);
        setBackground(new Color(60, 60, 60));
        setPadding(10, 0, 5, 0);
        setMargin(2, 1, 2, 1);
        addItemState(ItemStateType.HOVERED, new ItemState(new Color(255, 255, 255, 30)));

        this.character = character;
        this.name = new Label(character.getName() + ", the " + character.getRace());
    }

    @Override
    public void initElements() {
        ImageItem race = new ImageItem(
                DefaultsService.getDefaultImage(EmbeddedImage.USER, EmbeddedImageSize.SIZE_32X32), false);

        race.keepAspectRatio(true);
        race.setWidthPolicy(SizePolicy.FIXED);
        race.setWidth(20);
        race.setAlignment(ItemAlignment.LEFT, ItemAlignment.VCENTER);

        switch (character.getRace()) {
            case ELF:
                race.setColorOverlay(new Color(121, 161, 201));
                break;
            case ORC:
                race.setColorOverlay(new Color(12, 158, 0));
                break;
            case DWARF:
                race.setColorOverlay(new Color(165, 87, 7));
                break;
            case HUMAN:
                race.setColorOverlay(new Color(200, 167, 126));
                break;
        }

        name.setMargin(30, 0, 30, 0);

        ButtonCore infoButton = new ButtonCore("?");

        infoButton.setBackground(new Color(40, 40, 40, 255));
        infoButton.setWidth(20);
        infoButton.setSizePolicy(SizePolicy.FIXED, SizePolicy.EXPAND);
        infoButton.setFontStyle(Font.BOLD);
        infoButton.setForeground(new Color(210, 210, 210));
        infoButton.setAlignment(ItemAlignment.VCENTER, ItemAlignment.RIGHT);
        infoButton.setMargin(0, 0, 20, 0);
        infoButton.addItemState(ItemStateType.HOVERED, new ItemState(new Color(0, 140, 210)));

        infoButton.eventMouseHover.add((sender, args) -> setMouseHover(true));

        infoButton.eventMouseClick.add((sender, args) -> {
            ImageItem raceImage = new ImageItem(DefaultsService.getDefaultImage(EmbeddedImage.USER, EmbeddedImageSize.SIZE_32X32), false);
            raceImage.setSizePolicy(SizePolicy.FIXED, SizePolicy.FIXED);
            raceImage.setSize(32, 32);
            raceImage.setAlignment(ItemAlignment.LEFT, ItemAlignment.TOP);
            raceImage.setColorOverlay(race.getColorOverlay());

            PopUpMessage popUpMessage = new PopUpMessage(
                    character.getName() + "\n" +
                            "Race: " + character.getRace() + "\n" +
                            "Class: " + character.getCharClass() + "\n" +
                            "Weapon: " + character.getWeapon().getName() + "\n" +
                            "Armor: " + character.getArmorByBodyPart());

            popUpMessage.setTimeOut(3000);
            popUpMessage.setHeight(200);
            popUpMessage.show(getHandler());
            popUpMessage.addItem(raceImage);
        });

        ButtonCore removeButton = new ButtonCore();

        removeButton.setBackground(new Color(40, 40, 40, 255));
        removeButton.setSizePolicy(SizePolicy.FIXED, SizePolicy.FIXED);
        removeButton.setSize(10, 10);
        removeButton.setAlignment(ItemAlignment.VCENTER, ItemAlignment.RIGHT);
        removeButton.setCustomFigure(new CustomFigure(false, GraphicsMathService.getCross(10, 10, 2, 45)));
        removeButton.addItemState(ItemStateType.HOVERED, new ItemState(new Color(200, 95, 97)));

        removeButton.eventMouseClick.add((sender, args) -> getParent().removeItem(this));

        addItems(race, name, infoButton, removeButton);
    }

    @Override
    public String toString() {
        return character.toString();
    }
}
