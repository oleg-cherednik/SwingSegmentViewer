package cop.swing.controls.segment.primitives.drawable;

import cop.swing.controls.segment.AbstractSegment;
import cop.swing.controls.segment.primitives.BasicShape;

import java.awt.Polygon;
import java.awt.Rectangle;

import static cop.common.ext.ArrayExt.EMPTY_INT_ARR;
import static cop.common.ext.ArrayExt.isEmpty;
import static cop.common.ext.BitExt.isAnyBitSet;

/**
 * @author Oleg Cherednik
 * @since 22.10.2010
 */
public abstract class SimpleSegment extends AbstractSegment {
    protected static final int DEFAULT_ORIENTATION = BasicShape.HORIZONTAL | BasicShape.UP;
    protected static final int HORIZONTAL_ORIENTATION = BasicShape.UP | BasicShape.DOWN | BasicShape.HORIZONTAL;

    private final BasicShape basicShape;

    private int[] points;
    Polygon polygon;

    protected SimpleSegment(BasicShape basicShape) {
        this(basicShape, DEFAULT_ORIENTATION);
    }

    protected SimpleSegment(BasicShape basicShape, int orientation) {
        super(orientation);

        this.basicShape = basicShape;
    }

    protected int[] getPoints() {
        return points;
    }

    protected int[] getPointArray() {
        return basicShape.getShape(x, y, width, height, orientation);
    }

    // ========== AbstractSegment ==========

    @Override
    protected boolean isHorizontalOrientation() {
        return isAnyBitSet(orientation, HORIZONTAL_ORIENTATION);
    }

    @Override
    protected int getDefaultOrientation() {
        return DEFAULT_ORIENTATION;
    }

    @Override
    protected final void build() {
        super.build();
        points = getPointArray();

        polygon = new Polygon();

        for (int i = 0; i < points.length; i += 2)
            polygon.addPoint(points[i], points[i + 1]);
    }

    // ========== IShape ==========

    @Override
    public int[] getShape() {
        return isEmpty(points) ? EMPTY_INT_ARR : points.clone();
    }

    @Override
    public int[] getShape(Rectangle rect) {
        if (rect == null || isEmpty(points))
            return EMPTY_INT_ARR;

        int[] arr = new int[points.length];
        int len = 0;

        for (int i = 0, size = points.length; i < size; i += 2) {
            if (!rect.contains(points[i], points[i + 1]))
                continue;

            arr[len++] = points[i];
            arr[len++] = points[i + 1];
        }

        return arr;
    }
}
