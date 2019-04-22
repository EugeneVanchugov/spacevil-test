package spacevil.test.windows;

import com.spvessel.spacevil.*;
import com.spvessel.spacevil.Common.DefaultsService;
import com.spvessel.spacevil.Flags.EmbeddedImage;
import com.spvessel.spacevil.Flags.EmbeddedImageSize;
import com.spvessel.spacevil.TextArea;
import spacevil.test.elements.ElementsFactory;
import spacevil.test.elements.MainLayout;
import spacevil.test.elements.Toolbar;
import spacevil.test.style.StyleFactory;

import java.awt.*;

public class MainWindow extends ActiveWindow {

    private ListBox itemList;
    private TextArea itemText;


    @Override
    public void initWindow() {
        setParameters(this.getClass().getSimpleName(), "SpaceVIL Test", 800, 400, false);
        setMinSize(360, 500);
        setBackground(new Color(45, 45, 45));

        TitleBar title = createTitleBar();

        MainLayout layout = new MainLayout(0, title.getHeight(), 0, 0);

        VerticalSplitArea splitArea = new VerticalSplitArea();
        splitArea.setSplitPosition(300);
        splitArea.setBorderThickness(4);

        Toolbar toolbar = new Toolbar();
        itemList = new ListBox();
        itemText = new TextArea();

        ButtonCore saveButton = ElementsFactory.getToolbarButton();
        ButtonCore generateButton = ElementsFactory.getToolbarButton();
        SpinItem numberCount = ElementsFactory.getSpinItem();
        itemText.setStyle(StyleFactory.getTextAreaStyle());

        this.addItems(title, layout);
        layout.addItems(toolbar, splitArea);

        splitArea.assignLeftItem(itemList);
        splitArea.assignRightItem(itemText);

        toolbar.addItems(generateButton, saveButton, ElementsFactory.getVerticalDivider(), numberCount);

        generateButton.addItem(ElementsFactory.getToolbarIcon(
                DefaultsService.getDefaultImage(EmbeddedImage.REFRESH, EmbeddedImageSize.SIZE_32X32)
        ));

        saveButton.addItem(ElementsFactory.getToolbarIcon(
                DefaultsService.getDefaultImage(EmbeddedImage.DISKETTE, EmbeddedImageSize.SIZE_32X32)
        ));
    }

    private TitleBar createTitleBar() {
        TitleBar title = new TitleBar("Main Window");
        title.setIcon(DefaultsService.getDefaultImage(EmbeddedImage.USER, EmbeddedImageSize.SIZE_32X32), 20, 20);
        return title;
    }

    public ListBox getItemList() {
        return itemList;
    }

    public TextArea getItemText() {
        return itemText;
    }
}
