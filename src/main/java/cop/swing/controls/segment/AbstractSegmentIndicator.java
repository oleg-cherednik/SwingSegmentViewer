package cop.swing.controls.segment;

import cop.swing.controls.segment.interfaces.ISegment;
import cop.swing.controls.segment.interfaces.ISegmentIndicator;

import java.awt.Color;
import java.awt.Graphics;

import static cop.common.ext.ArrayExt.isEmpty;
import static cop.common.ext.CommonExt.isEqual;

/**
 * @author Oleg Cherednik
 * @since 31.10.2015
 */
public abstract class AbstractSegmentIndicator<T extends ISegment, N> extends AbstractSegment implements ISegmentIndicator<N> {
    protected boolean visible = true;
    private boolean transparent;
    protected T[] segments;
    protected N value;

    protected Color offColor = Color.DARK_GRAY;
    protected Color onColor = Color.WHITE;

    protected AbstractSegmentIndicator(int orientation) {
        super(orientation);
    }

    protected void createParts() {
        if (isHorizontalOrientation())
            createHorizontalOrientatedParts(isInverted(true));
        else
            createVerticalOrientatedParts(isInverted(false));
    }

    public void paint(int x, int y, int width, int height) {
//        paint();
    }

    public ISegment[] getParts() {
        return (segments != null) ? segments.clone() : null;
    }

    protected void _setValue() {
    }

    protected/* abstract */boolean isValueValid(N value) {
        return true;
    }

    // ========== abstract ==========

    public abstract void paint(Graphics g);

//    public abstract void setCanvas(Canvas canvas);

    protected abstract boolean isInverted(boolean horizontal);

    protected abstract void createHorizontalOrientatedParts(boolean invert);

    protected abstract void createVerticalOrientatedParts(boolean invert);

    protected abstract void rebuild();

    protected abstract void buildVerticalOrientatedIndicator(boolean invert);

    protected abstract void buildHorizontalOrientatedIndicator(boolean invert);

    // ========== AbstractSegment ==========

    @Override
    protected void build() {
        super.build();

        if (isHorizontalOrientation())
            buildHorizontalOrientatedIndicator(isInverted(true));
        else
            buildVerticalOrientatedIndicator(isInverted(false));

        super.build();

//        paint();
    }

    // ========== ISegmentIndicator ==========

    @Override
    public N getValue() {
        return value;
    }

    @Override
    public final void setValue(N value) {
        if (isEqual(value, this.value) || !isValueValid(value))
            return;

        this.value = value;
        _setValue();
//        paint();
    }

    @Override
    public boolean isTransparent() {
        return transparent;
    }

    @Override
    public void setTransparent(boolean enabled) {
        transparent = enabled;
    }

    @Override
    public void setOffColor(Color color) {
        offColor = (color != null) ? color : Color.DARK_GRAY;
//        paint();
    }

    @Override
    public Color getOffColor() {
        return offColor;
    }

//    @Override
    public void setForeground(Color color) {
        onColor = (color != null) ? color : Color.WHITE;
//        paint();
    }

//    @Override
    public Color getForeground() {
        return onColor;
    }

    // ========== IControl ==========

//    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

//    @Override
    public boolean isVisible() {
        return visible;
    }

    // ========== IShape ==========

    @Override
    public void draw(Graphics g, Color color) {
        if (g == null || color == null || isEmpty(segments))
            return;

        for (ISegment segment : segments)
            segment.draw(g, color);
    }

    // ========== Object ==========

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(super.toString());

        buf.append(", value=").append(value);

        return buf.toString();
    }
}
