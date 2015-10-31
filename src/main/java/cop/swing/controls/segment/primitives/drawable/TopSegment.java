package cop.swing.controls.segment.primitives.drawable;

import cop.swing.controls.segment.primitives.BasicShape;
import cop.swing.controls.segment.primitives.TriangleShape;

public final class TopSegment extends DrawableSegment {
    public static SimpleSegment create() {
        return create(false);
    }

    public static SimpleSegment create(boolean invert) {
        return invert ? new BottomSegment() : new TopSegment();
    }

    TopSegment() {
        super(TriangleShape.create(), BasicShape.DOWN);
    }
}
