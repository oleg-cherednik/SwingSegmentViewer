package cop.swing.controls.segment.primitives;

/**
 * @author Oleg Cherednik
 * @since 30.10.2015
 */
public abstract class AbstractBasicShape implements BasicShape {
    // ========== static ==========

    protected static int addPoint(int[] arr, int offs, int x, int y) {
        arr[offs++] = x;
        arr[offs++] = y;
        return offs;
    }
}
