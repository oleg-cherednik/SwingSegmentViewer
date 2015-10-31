package cop.swing.controls.segment;

import cop.swing.controls.segment.interfaces.ISegmentIndicator;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * @author Oleg Cherednik
 * @since 29.10.2015
 */
public class SegmentViewer<T extends Number> extends JPanel implements ISegmentIndicator<T> {
    private SegmentContainer<T> container;

    public SegmentViewer() {
        setPreferredSize(new Dimension(100, 100));
    }

    public void setContainer(SegmentContainer<T> container) {
        this.container = container;
    }

    // ========== Component ==========

    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        g.fillRect(0, 0, 100, 100);

        if (container != null)
            container.paint(g);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dim = super.getPreferredSize();

        dim.setSize(100, 100);

        return dim;
    }

    // ========== Scaleable ==========

    @Override
    public void setValue(T value) {
        container.setValue(value);
        updateUI();
    }

    @Override
    public T getValue() {
        return null;
    }

    @Override
    public int getScale() {
        return container != null ? container.getScale() : 0;
    }

    @Override
    public void setScale(int scale) {
        if (container != null)
            container.setScale(scale);
    }

    @Override
    public void setTransparent(boolean enabled) {

    }

    @Override
    public boolean isTransparent() {
        return false;
    }

    @Override
    public void setOffColor(Color color) {

    }

    @Override
    public Color getOffColor() {
        return null;
    }

    @Override
    public void clear(Graphics g) {

    }

    public void dispose() {

    }
}
