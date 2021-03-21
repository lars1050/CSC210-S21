
public class Main {

    /* Change this constant to contain your name.
     *
     * WARNING: Once you've set set this constant and started exploring your maze,
     * do NOT edit the value of kYourName. Changing kYourName will change which
     * maze you get back, which might invalidate all your hard work!
     */
    private static final String YOUR_NAME = "TODO: Replace this with your name to randomly generate maze";

    /* Change these constants to contain the paths out of your mazes (e.g. "EESSWNWE". */
    private static final String PATH_OUT_OF_MAZE = "TODO: Replace this string with your path out of the normal maze.";
    private static final String PATH_OUT_OF_TWISTY_MAZE = "TODO: Replace this string with your path out of the twisty maze.";

    public static void main(String[] args) {
        MazeCell startLocation = MazeUtilities.mazeFor(YOUR_NAME);

        /* Set a breakpoint here to explore your maze! */
        if (MazeUtilities.isPathToFreedom(startLocation, PATH_OUT_OF_MAZE)) {
            System.out.println("Congratulations! You've found a way out of your labyrinth.");
        } else {
            System.out.println("Sorry, but you're still stuck in your labyrinth.");
        }


        /** This is a more difficult maze with unexpected twists and turns.
         * Going east and immediately west does not necessarily put you back in the same place!
         */
        /*

        MazeCell twistyStartLocation = MazeUtilities.twistyMazeFor(YOUR_NAME);
        // Set a breakpoint here to explore your twisty maze!
        
        if (MazeUtilities.isPathToFreedom(twistyStartLocation, PATH_OUT_OF_TWISTY_MAZE)) {
            System.out.println("Congratulations! You've found a way out of your twisty labyrinth.");
        } else {
            System.out.println("Sorry, but you're still stuck in your twisty labyrinth.");
        }
        */
    }
}
