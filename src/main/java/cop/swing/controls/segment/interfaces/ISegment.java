package cop.swing.controls.segment.interfaces;

import cop.swing.controls.interfaces.IShape;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author Oleg Cherednik
 * @since 30.10.2015
 */
public interface ISegment extends IShape {
    int DEF_SCALE = 1;
    int BASE_LENGTH = 4;

    void setPosition(int x, int y);

    void setBounds(int x, int y, int scale);

    Rectangle getBounds();

    Point getSize();
}
