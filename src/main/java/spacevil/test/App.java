package spacevil.test;

import com.spvessel.spacevil.Core.InterfaceBaseItem;
import com.spvessel.spacevil.Flags.KeyCode;
import com.spvessel.spacevil.ListBox;
import spacevil.test.elements.CharacterCard;
import spacevil.test.model.Character;
import spacevil.test.model.CharacterClass;
import spacevil.test.model.Race;
import spacevil.test.windows.MainWindow;

import static com.spvessel.spacevil.Common.CommonService.initSpaceVILComponents;

public class App {

    private static MainWindow mainWindow;

    public static void main(String[] args) {
        initSpaceVILComponents();

        mainWindow = new MainWindow();


        addCharacter(mainWindow);

        ListBox itemList = mainWindow.getItemList();

        for (InterfaceBaseItem item : itemList.getListContent()) {
            System.out.println(item);
        }

        itemList.getArea().setFocus();

        mainWindow.show();
    }

    private static void addCharacter(MainWindow mainWindow) {
        Character shrek = Character.builder()
                .name("Shrek")
                .race(Race.ORC)
                .intelligence(1)
                .agility(3)
                .strength(8)
                .charClass(CharacterClass.KNIGHT)
                .build();

        CharacterCard card = new CharacterCard(shrek);

        card.eventMouseClick.add((interfaceItem, mouseArgs) -> mainWindow.getItemText().setText(card.toString()));

        card.eventKeyPress.add((interfaceItem, keyArgs) -> {
            if (keyArgs.key == KeyCode.ENTER)
                card.eventMouseClick.execute(interfaceItem, null);
        });

        mainWindow.getItemList().addItem(card);
    }
}
