package Models;

/**
 * The Plateau class is like a grid to simplify rover's navigation, which contains the upper-right coordinates.
 */
public final class Plateau {

    private static Plateau plateau; // Unique instance
    private int upperRightCoord_x; // the x upper-right co-ordinates
    private int upperRightCoord_y; // the x upper-right co-ordinates

    /**
     * Private constructor used in Singleton design pattern in order to deny a global access point get
     * more than one instance.
     *
     * @param  upperRightCoord_x   the x upper-right co-ordinates
     * @param  upperRightCoord_y   the y upper-right co-ordinates
     */
    private Plateau(int upperRightCoord_x, int upperRightCoord_y) {
        this.upperRightCoord_x = upperRightCoord_x;
        this.upperRightCoord_y = upperRightCoord_y;
    }

    /**
     * Method to return its properties (x and y upper-right co-ordinates) in string format.
     *
     * @return x and y upper-right co-ordinates in string
     */
    @Override
    public String toString() {
        return "upperRightCoord_x=" + upperRightCoord_x +
                ", upperRightCoord_y=" + upperRightCoord_y +
                ' ';
    }

    /**
     * X upper-right co-ordinates property getter.
     *
     * @return the value of X upper-right co-ordinates
     */
    public int getUpperRightCoord_x() {
        return upperRightCoord_x;
    }

    /**
     * Y upper-right co-ordinates property getter.
     *
     * @return the value of Y upper-right co-ordinates
     */
    public int getUpperRightCoord_y() {
        return upperRightCoord_y;
    }

    /**
     * Method used in Singleton pattern design in order to get an unique instance of this class.
     * If this unique instance does not exist, then it will be created.
     * Once created, no more objects are made from this class.
     *
     * @param  upperRightCoord_x   the x upper-right co-ordinates
     * @param  upperRightCoord_y   the y upper-right co-ordinates
     * @return the unique instance of this class.
     */
    public static Plateau getInstance(int upperRightCoord_x, int upperRightCoord_y){
        if (plateau == null) {
            plateau = new Plateau(upperRightCoord_x, upperRightCoord_y);
        }
        return plateau;
    }

}
