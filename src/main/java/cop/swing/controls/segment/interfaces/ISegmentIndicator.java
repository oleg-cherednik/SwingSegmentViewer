package cop.swing.controls.segment.interfaces;

import cop.swing.controls.interfaces.Clearable;

import java.awt.Color;

/**
 * @author Oleg Cherednik
 * @since 30.10.2015
 */
public interface ISegmentIndicator<T> extends Clearable, Scaleable {
    void setValue(T value);

    T getValue();

    int getScale();

    void setScale(int scale);

    void setTransparent(boolean enabled);

    boolean isTransparent();

    void setOffColor(Color color);

    Color getOffColor();
}
