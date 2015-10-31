package cop.swing.controls.segment.seven;

import cop.swing.controls.segment.SegmentIndicator;
import cop.swing.controls.segment.primitives.BasicShape;
import cop.swing.controls.segment.primitives.drawable.BottomSegment;
import cop.swing.controls.segment.primitives.drawable.CenterSegment;
import cop.swing.controls.segment.primitives.drawable.LeftSegment;
import cop.swing.controls.segment.primitives.drawable.RightSegment;
import cop.swing.controls.segment.primitives.drawable.SimpleSegment;
import cop.swing.controls.segment.primitives.drawable.TopSegment;
import cop.swing.controls.segment.tmp.factories.SevenSegmentSymbolFactory;

import java.awt.Graphics;
import java.awt.Rectangle;

import static cop.common.ext.ArrayExt.EMPTY_INT_ARR;
import static cop.swing.controls.segment.tmp.factories.BasicSegmentSymbolFactory.SEG_BOTTOM_SIDE_LEFT;
import static cop.swing.controls.segment.tmp.factories.BasicSegmentSymbolFactory.SEG_BOTTOM_SIDE_RIGHT;
import static cop.swing.controls.segment.tmp.factories.BasicSegmentSymbolFactory.SEG_TOP_SIDE_LEFT;
import static cop.swing.controls.segment.tmp.factories.BasicSegmentSymbolFactory.SEG_TOP_SIDE_RIGHT;
import static cop.swing.controls.segment.tmp.factories.SevenSegmentSymbolFactory.SEG_BOTTOM;
import static cop.swing.controls.segment.tmp.factories.SevenSegmentSymbolFactory.SEG_CENTER;
import static cop.swing.controls.segment.tmp.factories.SevenSegmentSymbolFactory.SEG_TOP;

public abstract class SevenSegmentIndicator extends SegmentIndicator {
    protected static final int TOP = 0;
    protected static final int TOP_SIDE_RIGHT = 1;
    protected static final int BOTTOM_SIDE_RIGHT = 2;
    protected static final int BOTTOM = 3;
    protected static final int BOTTOM_SIDE_LEFT = 4;
    protected static final int TOP_SIDE_LEFT = 5;
    protected static final int CENTER = 6;

    protected static final SevenSegmentSymbolFactory factory = SevenSegmentSymbolFactory.getInstance();

    public SevenSegmentIndicator(/*Canvas canvas,*/ int orientation) {
        super(/*canvas,*/ orientation);
    }

    protected void _setValue(Graphics g, int value) {
        drawPart(g, value, TOP, SEG_TOP);
        drawPart(g, value, TOP_SIDE_RIGHT, SEG_TOP_SIDE_RIGHT);
        drawPart(g, value, BOTTOM_SIDE_RIGHT, SEG_BOTTOM_SIDE_RIGHT);
        drawPart(g, value, BOTTOM, SEG_BOTTOM);
        drawPart(g, value, BOTTOM_SIDE_LEFT, SEG_BOTTOM_SIDE_LEFT);
        drawPart(g, value, TOP_SIDE_LEFT, SEG_TOP_SIDE_LEFT);
        drawPart(g, value, CENTER, SEG_CENTER);
    }

	/*
     * IShape
	 */

    @Override
    public int[] getShape() {
        // TODO implements
        return null;
    }

    @Override
    public int[] getShape(Rectangle rect) {
        if (rect == null)
            return EMPTY_INT_ARR;

        // TODO implements

        return null;
    }

	/*
     * AbstractSegmentIndicator
	 */

    @Override
    protected void buildVerticalOrientatedIndicator(boolean invert) {
        int center = height >> 1;
        int _x = 0, _y = 0, _yy = 0;

        _y = y + height - 1;
        segments[TOP].setBounds(x + 1, invert ? _y : y, getScale());
        segments[BOTTOM].setBounds(x + 1, invert ? y : _y, getScale());

        _x = x + width - 1;
        _y = y + center + 1;
        _yy = y + 1;
        segments[TOP_SIDE_RIGHT].setBounds(invert ? x : _x, invert ? _y : _yy, getScale());
        segments[BOTTOM_SIDE_LEFT].setBounds(invert ? _x : x, invert ? _yy : _y, getScale());
        segments[TOP_SIDE_LEFT].setBounds(invert ? _x : x, invert ? _y : _yy, getScale());
        segments[BOTTOM_SIDE_RIGHT].setBounds(invert ? x : _x, invert ? _yy : _y, getScale());

        segments[CENTER].setBounds(x + 1, y + center, getScale());
    }

    @Override
    protected void buildHorizontalOrientatedIndicator(boolean invert) {
        int center = height - 1;
        int _x = 0, _xx = 0, _y = 0;

        _x = x + width - 1;
        segments[TOP].setBounds(invert ? x : _x, y + 1, getScale());
        segments[BOTTOM].setBounds(invert ? _x : x, y + 1, getScale());

        _x = x + center + 1;
        _y = y + height - 1;
        _xx = x + 1;
        segments[TOP_SIDE_RIGHT].setBounds(invert ? _xx : _x, invert ? y : _y, getScale());
        segments[BOTTOM_SIDE_LEFT].setBounds(invert ? _x : _xx, invert ? _y : y, getScale());
        segments[TOP_SIDE_LEFT].setBounds(invert ? _xx : _x, invert ? _y : y, getScale());
        segments[BOTTOM_SIDE_RIGHT].setBounds(invert ? _x : _xx, invert ? y : _y, getScale());

        segments[CENTER].setBounds(x + center, y + 1, getScale());
    }

    @Override
    protected void createHorizontalOrientatedParts(boolean invert) {
        segments = new SimpleSegment[7];

        segments[TOP] = RightSegment.create(invert);
        segments[BOTTOM] = LeftSegment.create(invert);
        segments[TOP_SIDE_RIGHT] = BottomSegment.create(invert);
        segments[TOP_SIDE_LEFT] = TopSegment.create(invert);
        segments[BOTTOM_SIDE_RIGHT] = BottomSegment.create(invert);
        segments[BOTTOM_SIDE_LEFT] = TopSegment.create(invert);
        segments[CENTER] = CenterSegment.create(BasicShape.VERTICAL);
    }

    @Override
    protected void createVerticalOrientatedParts(boolean invert) {
        segments = new SimpleSegment[7];

        segments[TOP] = TopSegment.create(invert);
        segments[BOTTOM] = BottomSegment.create(invert);
        segments[TOP_SIDE_RIGHT] = RightSegment.create(invert);
        segments[TOP_SIDE_LEFT] = LeftSegment.create(invert);
        segments[BOTTOM_SIDE_RIGHT] = RightSegment.create(invert);
        segments[BOTTOM_SIDE_LEFT] = LeftSegment.create(invert);
        segments[CENTER] = CenterSegment.create(BasicShape.HORIZONTAL);
    }
}
