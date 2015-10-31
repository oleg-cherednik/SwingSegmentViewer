package cop.swing.controls.segment.seven;

import java.awt.Graphics;

import static cop.common.ext.StringExt.isNumber;

public abstract class NumericSevenSegment extends SevenSegmentIndicator {
    public NumericSevenSegment() {
        super(/*null,*/ DEFAULT_ORIENTATION);
    }

    public NumericSevenSegment(/*Canvas canvas,*/ int orientation) {
        super(/*canvas,*/ orientation);
    }

	/*
     * IControl
	 */

    @Override
    public void clear(Graphics g) {
        value = null;
        super.clear(g);
    }

	/*
	 * AbstractSegmentIndicator
	 */

    @Override
    public boolean isValueValid(Character value) {
        return value == null || isNumber(value.charValue()) || value == '-';
    }

    @Override
    public void paint(Graphics g) {
        if (value == null)
            super.clear(g);
        else
            _setValue(g, factory.getSegments(value));
    }
}
