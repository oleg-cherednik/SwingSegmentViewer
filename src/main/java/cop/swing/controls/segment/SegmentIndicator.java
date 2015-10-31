package cop.swing.controls.segment;

import cop.swing.controls.segment.interfaces.ISegment;
import cop.swing.controls.segment.primitives.BasicShape;
import cop.swing.controls.segment.primitives.drawable.SimpleSegment;
import org.apache.commons.lang3.ArrayUtils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import static cop.common.ext.BitExt.isAnyBitSet;
import static cop.common.ext.BitExt.isBitSet;

/**
 * @author Oleg Cherednik
 * @since 31.10.2015
 */
public abstract class SegmentIndicator extends AbstractSegmentIndicator<SimpleSegment, Character> {
    protected static final int DEFAULT_ORIENTATION = BasicShape.VERTICAL | BasicShape.UP;
    protected static final int HORIZONTAL_ORIENTATION = BasicShape.LEFT | BasicShape.RIGHT | BasicShape.HORIZONTAL;

//    private GC gc;
//    protected Canvas canvas;

    protected SegmentIndicator(/*Canvas canvas,*/ int orientation) {
        super(orientation);

//        setCanvas(canvas);
//        initGC();
    }
//
//    public Canvas getCanvas() {
//        return canvas;
//    }
//
//    protected void initGC() {
//        if (gc != null)
//            gc.dispose();
//
//        if (canvas != null)
//            gc = new GC(canvas);
//    }

    private void drawParts(Graphics g, Color color) {
        if (ArrayUtils.isNotEmpty(segments))
            for (ISegment segment : segments)
                segment.draw(g, color);
    }

    protected void drawPart(Graphics g, int mask, int i, int bit) {
        if (isBitSet(mask, bit))
            segments[i].draw(g, onColor);
        else
            segments[i].draw(g, isTransparent() ? g.getColor() : offColor);
    }

	/*
     * ISegment
	 */

    @Override
    public void setPosition(int x, int y) {
//        if (isDisposed(canvas))
//            super.setPosition(x, y);
//        else {
//            Rectangle rect = getBounds().union(new Rectangle(x, y, x + this.width, y + this.height));
//
//            super.setPosition(x, y);
//            canvas.paint(rect.x, rect.y, rect.width, rect.height, false);
//        }
    }

    @Override
    public void setScale(int scale) {
//        if (isDisposed(canvas))
//            super.setScale(scale);
//        else {
//            Rectangle rect = null;
//
//            if (scale < getScale())
//                rect = getBounds().union(new Rectangle(x, y, x + this.width, y + this.height));
//
//            super.setScale(scale);
//
//            if (rect == null)
//                rect = getBounds().union(new Rectangle(x, y, x + this.width, y + this.height));
//
//            canvas.paint(rect.x, rect.y, rect.width, rect.height, false);
//        }
    }

    @Override
    public void setBounds(int x, int y, int scale) {
        Rectangle rect = getBounds().union(new Rectangle(x, y, x + this.width, y + this.height));

        super.setBounds(x, y, scale);
//        canvas.paint(rect.x, rect.y, rect.width, rect.height, false);
    }

	/*
     * AbstractSegment
	 */

    @Override
    protected int getWidth() {
        int h = getDefaultHeight();
        int w = getDefaultWidth();
        return isHorizontalOrientation() ? getDefaultHeight() : getDefaultWidth();
    }

    @Override
    protected int getHeight() {
        return isHorizontalOrientation() ? getDefaultWidth() : getDefaultHeight();
    }

    @Override
    protected boolean isHorizontalOrientation() {
        return isAnyBitSet(orientation, HORIZONTAL_ORIENTATION);
    }

    @Override
    public void setOrientation(int orientation) {
        super.setOrientation(orientation);
        rebuild();
    }

    protected void hide() {
//        if (!isDisposed(canvas))
//            drawParts(canvas.getBackground());
    }

    @Override
    protected int getDefaultOrientation() {
        return DEFAULT_ORIENTATION;
    }

    @Override
    protected int getDefaultWidth() {
        return super.getDefaultWidth() + 2;
    }

    @Override
    protected int getDefaultHeight() {
        return getDefaultWidth() * 2 - 1;
    }

	/*
     * AbstractSegmentIndicator
	 */

    @Override
    protected boolean isInverted(boolean horizontal) {
        return horizontal ? isBitSet(orientation, BasicShape.LEFT) : isBitSet(orientation, BasicShape.DOWN);
    }

    @Override
    protected void rebuild() {
        boolean vis = visible;

        setVisible(false);

        createParts();
        build();

        setVisible(vis);
    }

//    @Override
//    public void setCanvas(Canvas canvas) {
//        if (isDisposed(canvas) || canvas.equals(this.canvas))
//            return;
//
//        this.canvas = canvas;
//
//        initGC();
//        paint();
//    }

	/*
     * Clearable
	 */

    @Override
    public void clear(Graphics g) {
        if (visible)
            drawParts(g, isTransparent() ? g.getColor() : offColor);
    }

	/*
     * IControl
	 */

    @Override
    public void setVisible(boolean visible) {
        if (this.visible == visible)
            return;

        this.visible = visible;

//        if (visible)
//            redraw();
//        else
//            hide();
    }
}

