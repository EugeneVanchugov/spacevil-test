package spacevil.test.elements;

import com.spvessel.spacevil.Flags.SizePolicy;
import com.spvessel.spacevil.HorizontalStack;

import java.awt.*;

public class Toolbar extends HorizontalStack {

    public Toolbar() {
        this.setHeightPolicy(SizePolicy.FIXED);
        this.setHeight(40);
        this.setBackground(new Color(55, 55, 55));
        this.setPadding(10, 0, 0, 0);
        this.setSpacing(5, 0);
    }
}
