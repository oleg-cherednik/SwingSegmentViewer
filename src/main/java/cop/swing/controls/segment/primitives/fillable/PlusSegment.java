package cop.swing.controls.segment.primitives.fillable;

import cop.swing.controls.segment.primitives.BasicShape;
import cop.swing.controls.segment.primitives.PlusShape;

public final class PlusSegment extends FillableSegment {
    public PlusSegment() {
        super(PlusShape.create(), BasicShape.HORIZONTAL);
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
        return (getScale() <= 1) ? (BASE_LENGTH - 1) : ((BASE_LENGTH - 1) * getScale());
    }
}
