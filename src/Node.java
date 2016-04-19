/***
 * A class for representing nodes in the graph for the Graph Coloring project.
 * <p>
 * It needs private data members for
 * <p>
 * State Data
 * <p>
 * id  : an integer, which will be the index of its position in the input file, 0
 * for the first node, 1 for the second, etc.
 * location: a Point, for plotting in the Turtle
 * color: a nonnegative integer indicating how the node is colored, initially -1 to indicate
 * not yet colored
 * adjNodeIds: a set of Integer (this will be created as the graph is read in,
 * then converted to the next data member once all the nodes have been read)
 * adjNodes:  a set of Node (constructed from adjNodeIds and the Graph
 * object's array of Node; once this is filled, adjNodeIds can be
 * set to null)
 * <p>
 * Support Data for the coloring algorithms are as follows.
 * <p>
 * <p>
 * // for SL
 * unsortedAdjCount: integer // initially this should be the same
 * // as the size of the adjNodeIds list when the Node is
 * // constructed;
 * <p>
 * // for SLI
 * addedToAuxList: boolean   // should be initially false
 * <p>
 * // for RLF
 * inT: boolean;  // initially true
 * countOfUncoloredAdjacentNodes: int; // initially same as size of adjNodes set,
 * // the degree of this node
 * countOfAdjacentNodesInU: int; // initially 0; this always has to be <= the previous
 * // data member, since every node in U is uncolored
 * <p>
 * <p>
 * <p>
 * <p>
 * The constructor takes values for id, location, and adjNodeIds, sets color to -1;
 * the adjNodes set is created later.
 * <p>
 * public Node(int id, Point loc, Set<Integer> aNIds)
 * <p>
 * Needed Methods
 * <p>
 * void setAdjNodes(Node[] allNodes)
 * constructs the adjNodes data member by loading it with the Node objects in allNodes
 * corresponding to the integer values in adjNodeIds, then sets adjNodeIds to null;
 * <p>
 * // needed for LF
 * int compareTo(Node other)
 * // codes the comparison to sort the Graph object's array of Node for LF and
 * // to break ties when nodes are selected; just order by the node id, so that
 * // this.
 * <p>
 * boolean equals(Node other)
 * // should use the id data member; return true if the same, else
 * // false;
 * // needed for SLI, which uses sets;
 * <p>
 * <p>
 * void draw(Color[] palette)
 * // draws the Node in the Turtle, using Graph.palette[color] for the Turtle color
 * // and draw all the edges to Node's in this's adjacency list; edges should be black);
 * // when there is an edge between v and w, v will be in w's adjacency list and w
 * // will be in v's adjacency list, so to suppress drawing the same edge twice, you
 * // can just draw the edge when this.id < other.id
 * <p>
 * <p>
 * YOU WILL NEED ADDITIONAL GETTERS AND SETTERS BECAUSE THE ALGORITHMS CHANGE DATA MEMBERS
 * DYNAMICALLY.  Exactly what you need to do will be implied in the discussion of each
 * algorithm.
 ***/

public class Node implements Comparable<Node> {

    private Point p = null;
    public Node(Point p) {
        this.p = p;
    }

    // for the compiler
    // you will need to code this
    public int compareTo(Node other) {
        // code it to compare by degree first, making the larger degree'd node
        // less than the smaller degee'd node; if the two degrees are equal,
        // return this.id - other.id


        return 0;
    }

}

