import java.util.*;

/***
 * A class to hold a connected component for the SLI algorithm.
 * <p>
 * YOU HAVE TO CODE ALL OF THE METHODS AND THE CONSTRUCTOR AS DISCUSSED
 * IN THE IMPLEMENTATION NOTES
 ***/

public class ConnectedComponent {

    private Set<Node> nodesOfCC;


    public ConnectedComponent() {
      /*
          creates a new empty set for the data member;

      */
    }

    public void resetAddedToAuxList() {
        //  iterates over the nodes of the data member and sets the
        //  addToAuxList data member each to false
    }


    /*
        This method should only be called if the calculateCCs method of Graph
        is successful.

        It should iterate over the data member and change to color of each
        node colored i to j and each node colored j to i.


    */
    public void performInterchange(int i, int j) {
    }


    // adds p to the set data member
    public void addNode(Node p) {
    }

}



