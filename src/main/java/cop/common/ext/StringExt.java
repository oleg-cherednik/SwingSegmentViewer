/**
 * @licence GNU Leser General Public License
 * <p/>
 * $Id: StringExtension.java 309 2011-03-08 12:23:25Z oleg.cherednik $
 * $HeadURL: https://cop-swt-controls.googlecode.com/svn/SegmentIndicator/trunk/SegmentIndicator/src/cop/common/extensions/StringExtension.java $
 */
package cop.common.ext;

import static cop.common.ext.NumericExt.isInRangeMinMax;

public final class StringExt {
    private StringExt() {
    }

    public static boolean isNumber(char ch) {
        return isInRangeMinMax(new Integer(ch), 48, 57);
    }
}
