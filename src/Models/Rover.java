package Models;

/**
 * The Rover class represents informations and operations that a squad of robotic rovers
 * can perform on a plateau on Mars.
 */
public class Rover {

    /**
     * Constants
     */
    public static final char SPIN_90_DEG_LEFT = 'L'; // the rover spins 90 degrees left
    public static final char SPIN_90_DEG_RIGHT = 'R'; // the rover spins 90 degrees right
    public static final char MOVE_FORWARD_1_GRID = 'M'; // the rover moves forward one grid point
    public static final char EAST = 'E'; // cardinal compass points: East
    public static final char SOUTH = 'S'; // cardinal compass points: South
    public static final char WEST = 'W'; // cardinal compass points: West
    public static final char NORTH = 'N'; // cardinal compass points: North

    /**
     * Properties
     */
    private int x_coord; // x co-ordinates of rover position on a plateau
    private int y_coord; // y co-ordinates of rover position on a plateau
    private char cardinalPoint; // rover’s orientation
    private Plateau plateau; // plateau to get the upper-right coordinates

    /**
     * Constructor.
     *
     * @param  x_coord   the x co-ordinates of rover position
     * @param  y_coord   the y co-ordinates of rover position
     * @param  cardinalPoint   rover’s orientation
     * @param  plateau   to get the upper-right coordinates
     */
    public Rover(int x_coord, int y_coord, char cardinalPoint, Plateau plateau) {
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.cardinalPoint = cardinalPoint;
        this.plateau = plateau;
    }

    /**
     * Getter of x co-ordinates of rover position.
     *
     * @return the value of x co-ordinates of rover position
     */
    public int getX_coord() {
        return x_coord;
    }

    /**
     * Getter of y co-ordinates of rover position.
     *
     * @return the value of y co-ordinates of rover position
     */
    public int getY_coord() {
        return y_coord;
    }

    /**
     * Getter of rover’s orientation.
     *
     * @return the value of rover’s orientation.
     */
    public char getCardinalPoint() {
        return cardinalPoint;
    }

    /**
     * Main method to control a rover in order to to explore the plateau.
     *
     * @param instruction instruction telling the rover how to explore the plateau
     */
    public void explore(char instruction) {

        switch(instruction) {
            case SPIN_90_DEG_LEFT:
                turnLeft();
                break;
            case SPIN_90_DEG_RIGHT:
                turnRight();
                break;
            case MOVE_FORWARD_1_GRID:
                MoveForward();
                break;
            default:

        }
    }

    /**
     * Private method to update rover’s orientation after spined 90 degrees left.
     *
     */
    private void turnLeft(){
        if (cardinalPoint == EAST)
            cardinalPoint = NORTH; // East -> North
        else if (cardinalPoint == NORTH)
            cardinalPoint = WEST; // North -> West
        else if (cardinalPoint == WEST)
            cardinalPoint = SOUTH; // West -> South
        else if (cardinalPoint == SOUTH)
            cardinalPoint = EAST; // South -> East
    }

    /**
     * Private method to update rover’s orientation after spined 90 degrees right.
     *
     */
    private void turnRight(){
        if (cardinalPoint == EAST)
            cardinalPoint = SOUTH; // East -> South
        else if (cardinalPoint == SOUTH)
            cardinalPoint = WEST; // South -> West
        else if (cardinalPoint == WEST)
            cardinalPoint = NORTH; // West -> North
        else if (cardinalPoint == NORTH)
            cardinalPoint = EAST; // North -> East
    }

    /**
     * Private method to update x and y co-ordinates of rover position after moved formard one grid.
     * If it reached plateau's limits, the rover will remain at grid of plateau boundaries.
     *
     */
    private void MoveForward(){
        if ((cardinalPoint == EAST) && (x_coord < plateau.getUpperRightCoord_x()))
            x_coord += 1;
        else if ((cardinalPoint == SOUTH) && (y_coord > 0))
            y_coord -= 1;
        else if ((cardinalPoint == WEST) && (x_coord > 0))
            x_coord -= 1;
        else if ((cardinalPoint == NORTH) && (y_coord < plateau.getUpperRightCoord_y()))
            y_coord += 1;
    }

    /**
     * Method to return its properties  in string format.
     *
     * @return the x co-ordinates of rover position, the y co-ordinates of rover position and rover's orientation
     */
    @Override
    public String toString() {
        return " " + x_coord +
                " " + y_coord +
                " " + cardinalPoint;
    }
}
