package cop.common.ext;

/**
 * @author Oleg Cherednik
 * @since 30.10.2015
 */
public class BitExt {
    /**
     * Checks if any bits of giving bit set are set or not
     *
     * @param value checked value
     * @param bits  checked bit or bit set
     * @return <code>true</code> if any of giving bit(s) are set
     */
    public static boolean isAnyBitSet(int value, int bits) {
        return (value & bits) != 0;
    }

    /**
     * Checks if all bits of giving bit set are set or not
     *
     * @param value checked value
     * @param bits  checked bit or bit set
     * @return <code>true</code> if all selected bit(s) are set
     */
    public static boolean isBitSet(int value, int bits) {
        return (value & bits) == bits;
    }
}
