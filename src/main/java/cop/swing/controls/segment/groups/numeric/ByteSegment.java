package cop.swing.controls.segment.groups.numeric;

import cop.swing.controls.segment.ISegmentConfig;
import cop.swing.controls.segment.tmp.SignPositionEnum;
import cop.swing.controls.segment.tmp.SignTypeEnum;

public final class ByteSegment extends NumericSegmentContainer<Byte> {
    private static final int TOTAL_SEGMENTS = 3;

    public static ByteSegment create() {
        return new ByteSegment(/*null,*/ DEFAULT_ORIENTATION);
    }

    public static ByteSegment create(/*Canvas canvas,*/ int orientation) {
        return new ByteSegment(/*canvas,*/ orientation);
    }

    public static ByteSegment createPositive(/*Canvas canvas,*/ int orientation) {
        ByteSegment obj = new ByteSegment(/*canvas,*/ orientation);

        obj.minimum = 0;

        return obj;
    }

    public static ByteSegment createNegative(/*Canvas canvas,*/ int orientation) {
        ByteSegment obj = new ByteSegment(/*canvas,*/ orientation);

        obj.maximum = 0;

        return obj;
    }

    private ByteSegment(/*Canvas canvas,*/ int orientation) {
        super(/*canvas,*/ new ByteSegmentConfig(SignTypeEnum.PLUS_MINUS, SignPositionEnum.INSIDE, orientation,
                TOTAL_SEGMENTS));

        minimum = Byte.MIN_VALUE;
        maximum = Byte.MAX_VALUE;
    }

    private static class ByteSegmentConfig implements ISegmentConfig {
        private SignTypeEnum signType = SignTypeEnum.PLUS_MINUS;
        private SignPositionEnum signPosition = SignPositionEnum.OUTSIDE;
        private int orientation;
        private int totalSegmens;

        ByteSegmentConfig(SignTypeEnum signType, SignPositionEnum signPosition, int orientation, int totalSegmens) {
            this.signType = signType;
            this.orientation = orientation;
            this.totalSegmens = totalSegmens;
            this.signPosition = signPosition;
        }

        @Override
        public SignTypeEnum getSignType() {
            return signType;
        }

        @Override
        public SignPositionEnum getSignPosition() {
            return signPosition;
        }

        @Override
        public int getOrientation() {
            return orientation;
        }

        @Override
        public int getTotalSegments() {
            return totalSegmens;
        }

        @Override
        public boolean isLeadingZero() {
            return false;
        }
    }
}
