/***
 * A class for representing the graph in the Graph Coloring problem.
 * <p>
 * It needs data members for
 * <p>
 * allNodes: an array of Node it builds from the input file
 * colorAssignments:  TreeMap<Integer,TreeSet<Integer>>  for holding all
 * the color assignments to display;  suppose the colors used
 * were 0, 1, ..., k; Then the the colorAssignments map will hold
 * (0, ordered set of the node ids of nodes assigned color 0)
 * (1, ordered set of the node ids of the nodes assigned color 1)
 * ...
 * (k, ordered set of the node ids of the nodes assigned color k)
 * <p>
 * The colorAssignments map object  is needed for us to see the results
 * of your color assignment algorithms, and you will need to code a
 * method to write its contents to standard out.
 * <p>
 * The best approach to this data member is to initialize the
 * colorAssignments map to the empty map at the start of each of the
 * coloring methods colorLF, colorSL, colorRLF, and modify it each time
 * you color a node.  However, since SLI does change colors of nodes,
 * it may be better in that particular algorithm to wait until all
 * the nodes have been assigned a color before constructing this map data
 * member.  TreeSet has a clear method that will remove all map entries,
 * so you don't need to create the object more than once.
 * <p>
 * Graph needs a constructor that takes a Scanner with the input data formated
 * as described in the assignment; it creates the allNodes array from the
 * Scanner, loading it with Node objects.
 * <p>
 * public Graph(Scanner inputFile)
 * // load the allNodes array based on the Scanner's contents, then iterate
 * // over the array again and call each Node's setAdjNodes method.
 * <p>
 * <p>
 * <p>
 * Needed methods
 * <p>
 * void draw()
 * // if the number of Nodes > 40, this does nothing,
 * // otherwise draws all nodes and edges in the Turtle, coloring the
 * // the nodes  from the palette array
 * <p>
 * void sequentialAssignColor()   // used by LF and SL
 * // iterates down the allNodes array and assigns the colors;
 * // it assumes that all the colors are currently -1, so if that is not
 * // the case, they all need to be set back to -1;
 * // also, the SL algorithm dynamically changes the counts of the
 * // adjacent nodes;
 * <p>
 * void sequentialAssignColorWithInterchange() // used by SLI
 * // modifies the basic sequential assignment algorithm to try to
 * // avoid using the next higher color by looking for a chance to interchange
 * // a pair of node colors
 * <p>
 * <p>
 * void colorLF() // colors the nodes in the allNodes array using the LF
 * // algorithm; it should print out the node id's in the allNodes
 * // array after sorting it by the largest degree first order,
 * // twenty node id's to a line for testing against our solution,
 * // before displaying the color assignments
 * <p>
 * void colorSL() // colors the nodes in the allNodes array using the SL
 * // algorithm; discussed in Implementation notes; again,
 * // it should print out the order of the node id's in the
 * // allNodes array after the SL sorting for comparison with
 * // our solution and before printing out the color assignments
 * <p>
 * Do one or the other of the following two algorithms and uncomment the code
 * in the driver for the one you do.  You can do the second for extra
 * credit.
 * <p>
 * void colorSLI() // colors the nodes in the allNodes array using the SLI
 * // algorithm; discussed in Implementation notes
 * <p>
 * void colorRLF() // colors the nodes in the allNodes array using the RLF
 * // algorithm; discussed in Implementation notes
 * <p>
 * <p>
 * int numberOfColorsUsed() // reports the total number of colors
 * // used by a coloring algorithm; only
 * // defined AFTER one of the coloring methods
 * // has been called, but then should be the
 * // correct answer for the most recently called
 * // coloring method;  If the colorAssignments
 * // map data member is up to date, it should
 * // be the number of entries in the map
 * <p>
 * void displayColoringResults()
 * //
 * // iterates over the colorAssignments map object for each color from 0
 * // to the max color used, and lists to System.out  the color as an int(plainly labeled) and
 * // the list of node ids that were colored that color, formatted for easy reading;
 * // The following scheme is what we ask for.
 * //
 * // Color c: n1 n2 n3 ...
 * //
 * // with <= 20 node ids per line. If there are more than 20, indent the subsequent
 * // lines 5 spaces, and put twenty more on the next line, for example,
 * //
 * // Color 0: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 56 82 90 91
 * //      100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119
 * //      123 124 125
 * // Color 1: 16 17 18 19 20 21 22 23 24 25 26
 * //
 * // etc.
 * <p>
 * // needed if you do the SLI algorithm
 * Set<ConnectedComponent> calculateCCs(int k, Node curr, int i, int j)
 * //
 * // assumes that k is the maximum color
 * // value that has been used so far, that curr is a Node that is adjacent
 * // to nodes of each color from 0 to k, and so would need to be colored
 * // with k+1, and that 0 <= i < j <= k.
 * //
 * // Conceptually, it constructs and returns a set of the connected components
 * // of the reduced graph that contains ONLY nodes colored i or j, but only
 * // those connected components that contain a node adjacent to
 * // curr colored i.
 * //
 * // If none of those connected components contains also a node
 * // colored j adjacent to curr, it returns the set of those
 * // ConnectedComponents it constructed.
 * //
 * // As it is constructing them, if it encounters a connected component
 * // that DOES contain both a node colored i that is adjacent to curr and
 * // a node colored j that is adjacent to curr, then it stops looking
 * // and returns null to indicate that color interchanging won't fix the
 * // problem.
 * //
 * // In either case, it restores the addedToAuxList data member of all of
 * // the nodes to false.
 * //
 * // Implementation is discussed in the notes.
 */

import java.awt.*;
import java.io.IOError;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Graph {

    // code to establish a palette of colors with some contrast

    // only display the nodes if there are fewer than 41 of them
    private static final int MAX_VERTICES_FOR_TURTLE = 40;
    private static Color[] palette = new Color[MAX_VERTICES_FOR_TURTLE];

    // Don't know how many until we read the file
    private Node[] nodes;
    private List<Integer>[] adjacent;

    static {
        // static initialization block
        // use primary colors FIRST
        palette[0] = new Color(204, 0, 204); //  purple
        palette[1] = Color.RED;
        palette[2] = Color.YELLOW;
        palette[3] = Color.BLUE;
        palette[4] = Color.LIGHT_GRAY;
        palette[5] = Color.GREEN;
        palette[6] = new Color(0, 100, 0);
        palette[7] = new Color(255, 20, 147);
        palette[8] = Color.PINK;
        palette[9] = Color.BLACK;

        palette[10] = new Color(60, 179, 113);
        palette[11] = Color.CYAN;
        palette[12] = Color.DARK_GRAY;
        palette[13] = new Color(102, 0, 0);
        palette[14] = new Color(220, 20, 60);
        palette[15] = new Color(160, 82, 45);
        palette[16] = new Color(120, 120, 120);
        palette[17] = new Color(255, 127, 36);
        palette[18] = new Color(0, 205, 0);
        palette[19] = new Color(222, 184, 135);

        palette[20] = new Color(255, 215, 0);
        palette[21] = new Color(178, 34, 34);
        palette[22] = new Color(0, 128, 128);
        palette[23] = new Color(255, 236, 139);
        palette[24] = new Color(0, 0, 102);
        palette[25] = new Color(139, 69, 19);
        palette[26] = new Color(135, 38, 87);
        palette[27] = new Color(188, 210, 238);
        palette[28] = new Color(75, 0, 130);
        palette[29] = new Color(104, 34, 139);

        palette[30] = new Color(148, 0, 211);
        palette[31] = new Color(205, 85, 85);
        palette[32] = new Color(139, 117, 0);
        palette[33] = new Color(128, 0, 0);
        palette[34] = new Color(153, 255, 153);// a lighter green
        palette[35] = new Color(255, 62, 150);
        palette[36] = Color.MAGENTA;
        palette[37] = new Color(255, 160, 122);
        palette[38] = new Color(65, 105, 225);
        palette[39] = new Color(140, 149, 237);
    }

    public Graph(Scanner src) {
        int nodeCount = src.nextInt();
        this.nodes = new Node[nodeCount];
        this.adjacent = new ArrayList[nodeCount];

        for (int node = 0; node < nodeCount; ++node) {
            this.nodes[node] = new Node(new Point(src.nextDouble(), src.nextDouble())); // first line contains x, y doubles
            this.adjacent[node] = new ArrayList<Integer>(); // initial the next "receiver" for adjacent nodes
            while(src.hasNextInt()) {
                // read all ints on this line
                this.adjacent[node].add(src.nextInt());
            }
            if (src.hasNext()) {
                src.next(); // mode to next line
            }
        }
    }

    public String toString() {
        String result = "<Graph " + this.nodes.length + ": ";
        for (int node = 0; node < this.nodes.length; ++node) {
            result += node + ") ";
            for (int adjacent : this.adjacent[node]) {
                result += adjacent + ", ";
            }
        }
        return result + ">";
    }

}
