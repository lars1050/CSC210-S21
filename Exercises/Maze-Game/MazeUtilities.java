import java.util.*;

public class MazeUtilities {
    /**
     * Given a location in a maze, returns whether the given sequence of
     * steps will let you escape the maze. The steps should be given as
     * a string made from N, S, E, and W for north/south/east/west without
     * spaces or other punctuation symbols, such as "WESNNNS"
     * <p>
     * To escape the maze, you need to find the Potion, the Spellbook, and
     * the Wand. You can only take steps in the four cardinal directions,
     * and you can't move in directions that don't exist in the maze.
     * <p>
     * It's assumed that the input MazeCell is not null.
     *
     * @param start The start location in the maze.
     * @param moves The sequence of moves.
     * @return Whether that sequence of moves picks up the needed items
     *         without making nay illegal moves.
     */
    public static boolean isPathToFreedom(MazeCell start, String moves) {
        MazeCell curr = start;
        Set<String> items = new HashSet<String>();
        
        /* Fencepost issue: pick up items from starting location, if any. */
        if (!start.whatsHere.equals("")) items.add(start.whatsHere);
        
        for (char ch: moves.toCharArray()) {
            /* Take a step. */
            if      (ch == 'N') curr = curr.north;
            else if (ch == 'S') curr = curr.south;
            else if (ch == 'E') curr = curr.east;
            else if (ch == 'W') curr = curr.west;
            else return false; // Unknown character?
            
            /* Was that illegal? */
            if (curr == null) return false;
            
            /* Did we get anything? */
            if (!curr.whatsHere.equals("")) items.add(curr.whatsHere);
        }
        
        /* Do we have all three items? */
        return items.size() == 3;
    }
    
    /* Simple rolling hash. Stolen shameless from StanfordCPPLib, maintained by a collection
     * of talented folks at Stanford University. We use this hash implementation to ensure
     * consistency from run to run and across systems.
     */
    private static final int HASH_SEED = 5381;       // Starting point for first cycle
    private static final int HASH_MULTIPLIER = 33;   // Multiplier for each cycle
    private static final int HASH_MASK = 0x7FFFFFFF; // All 1 bits except the sign
    
    private static int hashCode(int value) {
        return value & HASH_MASK;
    }
    
    private static int hashCode(String str) {
        int hash = HASH_SEED;
        for (char ch: str.toCharArray()) {
            hash = HASH_MULTIPLIER * hash + ch;
        }
        return hashCode(hash);
    }
    
    /*
     * Computes a composite hash code from a list of multiple values.
     * The components are scaled up so as to spread out the range of values
     * and reduce collisions.
     */
    private static int hashCode(String str, int... values) {
        int result = hashCode(str);
        for (int value: values) {
            result = result * HASH_MULTIPLIER + value;
        }
        return hashCode(result);
    }

    /* Size of a normal maze. */
    private static final int NUM_ROWS = 4;
    private static final int NUM_COLS = 3;
    
    /* Size of a twisty maze. */
    private static final int TWISTY_MAZE_SIZE = 12;

    /**
     * Returns a maze specifically tailored to the given name.
     *
     * We've implemented this function for you. You don't need to write it
     * yourself.
     *
     * Please don't make any changes to this function - we'll be using our
     * reference version when testing your code, and it would be a shame if
     * the maze you solved wasn't the maze we wanted you to solve!
     */
    public static MazeCell mazeFor(String name) {
        /* Java Random is guaranteed to produce the same sequence of values across
         * all systems with the same seed.
         */
        Random generator = new Random(hashCode(name, NUM_ROWS, NUM_COLS));
        MazeCell[][] maze = makeMaze(NUM_ROWS, NUM_COLS, generator);
        
        List<MazeCell> linearMaze = new ArrayList<MazeCell>();
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                linearMaze.add(maze[row][col]);
            }
        }
        
        int[][] distances = allPairsShortestPaths(linearMaze);
        int[]   locations = remoteLocationsIn(distances);
        
        /* Place the items. */
        linearMaze.get(locations[1]).whatsHere = "Spellbook";
        linearMaze.get(locations[2]).whatsHere = "Potion";
        linearMaze.get(locations[3]).whatsHere = "Wand";

        /* We begin in position 0. */
        return linearMaze.get(locations[0]);
    }

    /**
     * Returns a twisty maze specifically tailored to the given name.
     *
     * Please don't make any changes to this function - we'll be using our
     * reference version when testing your code, and it would be a shame if
     * the maze you solved wasn't the maze we wanted you to solve!
     */
    public static MazeCell twistyMazeFor(String name) {
        /* Java Random is guaranteed to produce the same sequence of values across
         * all systems with the same seed.
         */
        Random generator = new Random(hashCode(name, TWISTY_MAZE_SIZE));
        List<MazeCell> maze = makeTwistyMaze(TWISTY_MAZE_SIZE, generator);

        /* Find the distances between all pairs of nodes. */
        int[][] distances = allPairsShortestPaths(maze);

        /* Select a 4-tuple maximizing the minimum distances between points,
         * and use that as our item/start locations.
         */
        int[] locations = remoteLocationsIn(distances);

        /* Place the items there. */
        maze.get(locations[1]).whatsHere = "Spellbook";
        maze.get(locations[2]).whatsHere = "Potion";
        maze.get(locations[3]).whatsHere = "Wand";

        return maze.get(locations[0]);
    }

    /* Returns if two nodes are adjacent. */
    private static boolean areAdjacent(MazeCell first, MazeCell second) {
        return first.east  == second ||
               first.west  == second ||
               first.north == second ||
               first.south == second;
    }

    /* Uses the Floyd-Warshall algorithm to compute the shortest paths between all
     * pairs of nodes in the maze. The result is a table where table[i][j] is the
     * shortest path distance between maze[i] and maze[j].
     */
    private static int[][] allPairsShortestPaths(List<MazeCell> maze) {
        /* Floyd-Warshall algorithm. Fill the grid with "infinity" values. */
        int[][] result = new int[maze.size()][maze.size()];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = maze.size() + 1;
            }
        }

        /* Set distances of nodes to themselves at 0. */
        for (int i = 0; i < maze.size(); i++) {
            result[i][i] = 0;
        }

        /* Set distances of edges to 1. */
        for (int i = 0; i < maze.size(); i++) {
            for (int j = 0; j < maze.size(); j++) {
                if (areAdjacent(maze.get(i), maze.get(j))) {
                    result[i][j] = 1;
                }
            }
        }

        /* Dynamic programming step. Keep expanding paths by allowing for paths
         * between nodes.
         */
        for (int i = 0; i < maze.size(); i++) {
            int[][] next = new int[maze.size()][maze.size()];
            for (int j = 0; j < maze.size(); j++) {
                for (int k = 0; k < maze.size(); k++) {
                    next[j][k] = Math.min(result[j][k], result[j][i] + result[i][k]);
                }
            }
            result = next;
        }

        return result;
    }

    /* Given a list of distinct nodes, returns the "score" for their distances,
     * which is a sequence of numbers representing pairwise distances in sorted
     * order.
     */
    private static List<Integer> scoreOf(int[] nodes, int[][] distances) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nodes.length; i++) {
            for (int j = i + 1; j < nodes.length; j++) {
                result.add(distances[nodes[i]][nodes[j]]);
            }
        }

        Collections.sort(result);
        return result;
    }
    
    /* Lexicographical comparison of two arrays; they're assumed to have the same length. */
    private static boolean lexicographicallyFollows(List<Integer> lhs, List<Integer> rhs) {
        for (int i = 0; i < lhs.size(); i++) {
            if (lhs.get(i) != rhs.get(i)) return lhs.get(i) > rhs.get(i);
        }
        return false;
    }

    /* Given a grid, returns a combination of four nodes whose overall score
     * (sorted list of pairwise distances) is as large as possible in a
     * lexicographical sense.
     */
    private static int[] remoteLocationsIn(int[][] distances) {
        int[] result = new int[]{0, 1, 2, 3};

        /* We could do this recursively, but since it's "only" four loops
         * we'll just do that instead. :-)
         */
        for (int i = 0; i < distances.length; i++) {
            for (int j = i + 1; j < distances.length; j++) {
                for (int k = j + 1; k < distances.length; k++) {
                    for (int l = k + 1; l < distances.length; l++) {
                        int[] curr = new int[]{ i, j, k, l };
                        if (lexicographicallyFollows(scoreOf(curr, distances), scoreOf(result, distances))) {
                            result = curr;
                        }
                    }
                }
            }
        }

        return result;
    }

    /* Clears all the links between the given group of nodes. */
    private static void clearGraph(List<MazeCell> nodes) {
        for (MazeCell node: nodes) {
            node.whatsHere = "";
            node.north = node.south = node.east = node.west = null;
        }
    }
    
    /* Enumerated type representing one of the four ports leaving a MazeCell. */
    private enum Port {
        NORTH,
        SOUTH,
        EAST,
        WEST
    };

    /* Returns a random unassigned link from the given node, or nullptr if
     * they are all assigned.
     */
    private static Port randomFreePortOf(MazeCell cell, Random generator) {
        List<Port> ports = new ArrayList<Port>();
        if (cell.east  == null) ports.add(Port.EAST);
        if (cell.west  == null) ports.add(Port.WEST);
        if (cell.north == null) ports.add(Port.NORTH);
        if (cell.south == null) ports.add(Port.SOUTH);
        if (ports.isEmpty()) return null;

        int port = generator.nextInt(ports.size());
        return ports.get(port);
    }
    
    /* Links one MazeCell to the next using the specified port. */
    private static void link(MazeCell from, MazeCell to, Port link) {
        switch (link) {
            case EAST:
                from.east = to;
                break;
            case WEST:
                from.west = to;
                break;
            case NORTH:
                from.north = to;
                break;
            case SOUTH:
                from.south = to;
                break;
            default:
                throw new RuntimeException("Unknown port.");
        }
    }

    /* Use a variation of the Erdos-Renyi random graph model. We set the
     * probability of any pair of nodes being connected to be ln(n) / n,
     * then artificially constrain the graph so that no node has degree
     * four or more. We generate mazes this way until we find one that's
     * conencted.
     */
    private static boolean erdosRenyiLink(List<MazeCell> nodes, Random generator) {
        /* High probability that everything is connected. */
        double threshold = Math.log(nodes.size()) / nodes.size();

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (generator.nextDouble() <= threshold) {
                    Port iLink = randomFreePortOf(nodes.get(i), generator);
                    Port jLink = randomFreePortOf(nodes.get(j), generator);

                    /* Oops, no free links. */
                    if (iLink == null || jLink == null) {
                        return false;
                    }
                    
                    link(nodes.get(i), nodes.get(j), iLink);
                    link(nodes.get(j), nodes.get(i), jLink);
                }
            }
        }

        return true;
    }

    /* Returns whether the given maze is connected. Uses a BFS. */
    private static boolean isConnected(List<MazeCell> maze) {
        Set<MazeCell> visited = new HashSet<MazeCell>();
        Queue<MazeCell> frontier = new LinkedList<MazeCell>();
        
        frontier.add(maze.get(0));

        while (!frontier.isEmpty()) {
            MazeCell curr = frontier.remove();

            if (!visited.contains(curr)) {
                visited.add(curr);

                if (curr.east  != null) frontier.add(curr.east);
                if (curr.west  != null) frontier.add(curr.west);
                if (curr.north != null) frontier.add(curr.north);
                if (curr.south != null) frontier.add(curr.south);
            }
        }

        return visited.size() == maze.size();
    }

    /* Generates a random twisty maze. This works by repeatedly generating
     * random graphs until a connected one is found.
     */
    private static List<MazeCell> makeTwistyMaze(int numNodes, Random generator) {
        List<MazeCell> result = new ArrayList<MazeCell>();
        for (int i = 0; i < numNodes; i++) {
            result.add(new MazeCell());
        }

        /* Keep generating mazes until we get a connected one. */
        do {
            clearGraph(result);
        } while (!erdosRenyiLink(result, generator) || !isConnected(result));

        return result;
    }
    
    /* Type representing an edge between two maze cells. */
    private static final class EdgeBuilder {
        MazeCell from;
        MazeCell to;
        
        Port fromPort;
        Port toPort;
        
        public EdgeBuilder(MazeCell from, MazeCell to, Port fromPort, Port toPort) {
            this.from     = from;
            this.to       = to;
            this.fromPort = fromPort;
            this.toPort   = toPort;
        }
    }
    
    /* Returns all possible edges that could appear in a grid maze. */
    private static List<EdgeBuilder> allPossibleEdgesFor(MazeCell[][] maze) {
        List<EdgeBuilder> result = new ArrayList<EdgeBuilder>();
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (row + 1 < maze.length) {
                    result.add(new EdgeBuilder(maze[row][col], maze[row + 1][col], Port.SOUTH, Port.NORTH));
                }
                if (col + 1 < maze[row].length) {
                    result.add(new EdgeBuilder(maze[row][col], maze[row][col + 1], Port.EAST,  Port.WEST));
                }
            }
        }
        return result;
    }

    /* Union-find FIND operation. */
    private static MazeCell repFor(Map<MazeCell, MazeCell> reps, MazeCell cell) {
        while (reps.get(cell) != cell) {
            cell = reps.get(cell);
        }
        return cell;
    }

    /* Shuffles the edges using the Fischer-Yates shuffle. */
    private static void shuffleEdges(List<EdgeBuilder> edges, Random generator) {
        for (int i = 0; i < edges.size(); i++) {
            int j = generator.nextInt(edges.size() - i) + i;
            
            EdgeBuilder temp = edges.get(i);
            edges.set(i, edges.get(j));
            edges.set(j, temp);
        }
    }

    /* Creates a random maze of the given size using a randomized Kruskal's
     * algorithm. Edges are shuffled and added back in one at a time, provided
     * that each insertion links two disconnected regions.
     */
    private static MazeCell[][] makeMaze(int numRows, int numCols, Random generator) {
        MazeCell[][] maze = new MazeCell[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                maze[row][col] = new MazeCell();
                //maze[row][col].whatsHere = nextValue();
            }
        }

        List<EdgeBuilder> edges = allPossibleEdgesFor(maze);
        shuffleEdges(edges, generator);

        /* Union-find structure, done without path compression because N is small. */
        Map<MazeCell, MazeCell> representatives = new HashMap<MazeCell, MazeCell>();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                MazeCell elem = maze[row][col];
                representatives.put(elem, elem);
            }
        }

        /* Run a randomized Kruskal's algorithm to build the maze. */
        int edgesLeft = numRows * numCols - 1;
        for (int i = 0; edgesLeft > 0 && i < edges.size(); i++) {
            EdgeBuilder edge = edges.get(i);

            /* See if they're linked already. */
            MazeCell rep1 = repFor(representatives, edge.from);
            MazeCell rep2 = repFor(representatives, edge.to);

            /* If not, link them. */
            if (rep1 != rep2) {
                representatives.put(rep1, rep2);
                
                link(edge.from, edge.to, edge.fromPort);
                link(edge.to, edge.from, edge.toPort);

                edgesLeft--;
            }
        }
        if (edgesLeft != 0) throw new RuntimeException("Edges remain?"); // Internal error!

        return maze;
    }

    /* Not meant to be instantiated. */
    private MazeUtilities() {
    
    }
}
