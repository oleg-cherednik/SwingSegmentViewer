/**
 * @licence GNU Leser General Public License
 * <p/>
 * $Id: CollectionExtension.java 313 2011-03-10 07:34:02Z oleg.cherednik $
 * $HeadURL: https://cop-swt-controls.googlecode.com/svn/SegmentIndicator/trunk/SegmentIndicator/src/cop/common/extensions/CollectionExtension.java $
 */
package cop.common.ext;

import java.util.Collection;

import static cop.common.ext.ArrayExt.EMPTY_INT_ARR;

public final class CollectionExt {
    private CollectionExt() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static int[] convertToIntArray(Collection<Integer> values) {
        if (isEmpty(values))
            return EMPTY_INT_ARR;

        int[] arr = new int[values.size()];
        int i = 0;

        for (Integer value : values)
            arr[i++] = (value != null) ? value.intValue() : 0;

        return arr;
    }

    public static char[] replaceAll(char[] arr, char oldVal, char newVal) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == oldVal)
                arr[i] = newVal;

        return arr;
    }
}
