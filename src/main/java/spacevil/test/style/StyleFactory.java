package spacevil.test.style;

import com.spvessel.spacevil.Decorations.Style;

public class StyleFactory {

    public static Style getTextAreaStyle() {
        Style style = Style.getTextAreaStyle();
        style.setBackground(0, 0, 0, 255);

        Style textEdit = style.getInnerStyle("textedit");
        textEdit.setForeground(133, 126, 125);

        Style cursor = textEdit.getInnerStyle("cursor");
        cursor.setBackground(0, 162, 232);

        return style;
    }
}
