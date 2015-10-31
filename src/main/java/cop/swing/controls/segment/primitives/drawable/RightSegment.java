package cop.swing.controls.segment.primitives.drawable;

import cop.swing.controls.segment.primitives.BasicShape;
import cop.swing.controls.segment.primitives.TriangleShape;

public final class RightSegment extends DrawableSegment {
    public static SimpleSegment create() {
        return create(false);
    }

    public static SimpleSegment create(boolean invert) {
        return invert ? new LeftSegment() : new RightSegment();
    }

    RightSegment() {
        super(TriangleShape.create(), BasicShape.LEFT);
    }
}
