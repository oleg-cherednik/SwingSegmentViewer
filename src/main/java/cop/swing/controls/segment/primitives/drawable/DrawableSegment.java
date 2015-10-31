package cop.swing.controls.segment.primitives.drawable;

import cop.swing.controls.segment.primitives.BasicShape;

import java.awt.Color;
import java.awt.Graphics;

public abstract class DrawableSegment extends SimpleSegment {
	public DrawableSegment(BasicShape basicShape, int orientation) {
		super(basicShape, orientation);
	}

	/*
	 * IShape
	 */

	@Override
	public void draw(Graphics g, Color color) {
		g.setColor(color);
		g.drawPolygon(polygon);
	}
}
