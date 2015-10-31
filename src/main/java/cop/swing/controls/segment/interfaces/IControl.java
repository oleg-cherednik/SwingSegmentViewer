package cop.swing.controls.segment.interfaces;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author Oleg Cherednik
 * @since 30.10.2015
 */
public interface IControl {
    Rectangle getBounds();

    Point getSize();

    boolean isVisible();

    void setVisible(boolean visible);

    void dispose();

    void setForeground(Color color);

    Color getForeground();
}
