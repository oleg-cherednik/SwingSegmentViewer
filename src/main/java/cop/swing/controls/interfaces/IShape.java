package cop.swing.controls.interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author Oleg Cherednik
 * @since 30.10.2015
 */
public interface IShape {
    int[] getShape();

    int[] getShape(Rectangle rect);

    void draw(Graphics g, Color color);
}
