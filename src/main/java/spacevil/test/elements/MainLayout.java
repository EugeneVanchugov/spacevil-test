package spacevil.test.elements;

import com.spvessel.spacevil.VerticalStack;

import java.awt.*;

public class MainLayout extends VerticalStack {

    public MainLayout(int left, int top, int right, int bottom) {
        this.setMargin(left, top, right, bottom);
        this.setBackground(new Color(60, 60, 60));
    }
}
