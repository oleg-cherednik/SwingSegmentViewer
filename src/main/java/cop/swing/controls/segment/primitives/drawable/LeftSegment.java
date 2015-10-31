package cop.swing.controls.segment.primitives.drawable;

import cop.swing.controls.segment.primitives.BasicShape;
import cop.swing.controls.segment.primitives.TriangleShape;

public final class LeftSegment extends DrawableSegment {
    public static SimpleSegment create() {
        return create(false);
    }

    public static SimpleSegment create(boolean invert) {
        return invert ? new RightSegment() : new LeftSegment();
    }

    LeftSegment() {
        super(TriangleShape.create(), BasicShape.RIGHT);
    }
}
