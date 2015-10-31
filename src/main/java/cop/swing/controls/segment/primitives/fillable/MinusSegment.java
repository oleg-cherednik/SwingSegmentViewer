package cop.swing.controls.segment.primitives.fillable;

import cop.swing.controls.segment.primitives.BasicShape;
import cop.swing.controls.segment.primitives.RectangleShape;

public final class MinusSegment extends FillableSegment {
    public MinusSegment() {
        super(RectangleShape.create(), BasicShape.HORIZONTAL);
    }

	/*
     * AbstractSegment
	 */

    @Override
    protected int getDefaultWidth() {
        return (getScale() <= 1) ? BASE_LENGTH : (BASE_LENGTH * getScale() - getScale() + 1);
    }

    @Override
    protected int getDefaultHeight() {
        return getScale();
    }
}
