package cop.swing.controls.segment.primitives;

/**
 * @author Oleg Cherednik
 * @since 30.10.2015
 */
public interface BasicShape {
    int HORIZONTAL = 256;
    int DOWN = 1024;
    int RIGHT = 131072;
    int LEFT = 16384;
    int UP = 128;
    int NONE = 0;
    int DEFAULT = -1;
    int VERTICAL = 512;

    int[] getShape(int x, int y, int width, int height);

    int[] getShape(int x, int y, int width, int height, int orientation);
}
