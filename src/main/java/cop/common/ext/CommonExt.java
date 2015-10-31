/**
 * @licence GNU Leser General Public License
 * <p/>
 * $Id: CommonExtension.java 313 2011-03-10 07:34:02Z oleg.cherednik $
 * $HeadURL: https://cop-swt-controls.googlecode.com/svn/SegmentIndicator/trunk/SegmentIndicator/src/cop/common/extensions/CommonExtension.java $
 */
package cop.common.ext;

/**
 * Class provides common methods that can't be placed into other named extension classes.<br>
 * This class contains only <i><u>static</u></i> methods. It can't be instantiated or inherited.
 *
 * @author cop (Cherednik, Oleg)
 */
public final class CommonExt {
    /**
     * Closed constructor
     */
    private CommonExt() {
    }

    /**
     * Checks if <b>obj1</b> equals <b>obj2</b> or not.<br>
     *
     * @param <T> template parameter
     * @param obj1 first comparison object
     * @param obj2 seconds comparison object
     * @return <b>true</b> in case of <code>obj1.equals(bij2)</code>
     */
    public static <T> boolean isEqual(T obj1, T obj2) {
        return (obj1 == null) ? (obj2 == null) : obj1.equals(obj2);
    }
}
