package spacevil.test.elements;

import com.spvessel.spacevil.ButtonCore;
import com.spvessel.spacevil.Common.DefaultsService;
import com.spvessel.spacevil.Decorations.Border;
import com.spvessel.spacevil.Decorations.CornerRadius;
import com.spvessel.spacevil.Decorations.ItemState;
import com.spvessel.spacevil.Flags.ItemAlignment;
import com.spvessel.spacevil.Flags.ItemStateType;
import com.spvessel.spacevil.Flags.SizePolicy;
import com.spvessel.spacevil.ImageItem;
import com.spvessel.spacevil.Rectangle;
import com.spvessel.spacevil.SpinItem;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ElementsFactory {

    public static ButtonCore getToolbarButton() {

        ButtonCore button = new ButtonCore();

        button.setBackground(new Color(55, 55, 55));
        button.setHeightPolicy(SizePolicy.EXPAND);
        button.setWidth(30);
        button.setPadding(5, 5, 5, 5);
        button.addItemState(ItemStateType.HOVERED, new ItemState(new Color(255, 255, 255, 30)));

        return button;
    }

    public static SpinItem getSpinItem() {

        SpinItem item = new SpinItem();

        item.setParameters(15, 3, 1000, 1);
        item.setSizePolicy(SizePolicy.FIXED, SizePolicy.FIXED);
        item.setSize(80, 26);
        item.setAlignment(ItemAlignment.VCENTER, ItemAlignment.LEFT);
        item.setMargin(5, 0, 0, 0);
        item.setBackground(new Color(80, 80, 80));
        item.setForeground(Color.WHITE);
        item.setBorder(new Border(Color.GRAY, new CornerRadius(), 1));
        item.setPadding(1, 1, 1, 1);

        return item;
    }

    public static Rectangle getVerticalDivider() {

        Rectangle item = new Rectangle();

        item.setBackground(new Color(120, 120, 120));
        item.setSizePolicy(SizePolicy.FIXED, SizePolicy.EXPAND);
        item.setWidth(1);
        item.setMargin(5, 6, 5, 6);

        return item;
    }

    public static ImageItem getToolbarIcon(BufferedImage image) {

        ImageItem imageItem = new ImageItem(image, false);

        imageItem.keepAspectRatio(true);

        return imageItem;
    }
}
