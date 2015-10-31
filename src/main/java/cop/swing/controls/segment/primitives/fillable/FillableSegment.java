package cop.swing.controls.segment.primitives.fillable;

import cop.swing.controls.segment.primitives.BasicShape;
import cop.swing.controls.segment.primitives.drawable.SimpleSegment;

import java.awt.Color;
import java.awt.Graphics;

public abstract class FillableSegment extends SimpleSegment {
    public FillableSegment(BasicShape basicShape, int orientation) {
        super(basicShape, orientation);
    }

	/*
     * IShape
	 */

    @Override
    public void draw(Graphics g, Color color) {
        if (g == null || color == null)
            return;

//        g.setBackground(color);
//        g.fillPolygon(getPoints());
    }
}
