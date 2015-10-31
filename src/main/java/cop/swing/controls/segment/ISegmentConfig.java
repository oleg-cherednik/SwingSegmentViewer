package cop.swing.controls.segment;

import cop.swing.controls.segment.tmp.SignPositionEnum;
import cop.swing.controls.segment.tmp.SignTypeEnum;

/**
 * @author Oleg Cherednik
 * @since 31.10.2015
 */
public interface ISegmentConfig {
    SignTypeEnum getSignType();

    SignPositionEnum getSignPosition();

    int getOrientation();

    int getTotalSegments();

    boolean isLeadingZero();
}
