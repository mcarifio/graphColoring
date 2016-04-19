import java.util.*;
import java.io.*;

public class GraphColoringDriver {

    private static Scanner stdIn = new Scanner(System.in);

    private static Graph g;

    private static Scanner src;

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Name of input file should be on command line.");
            return;
        }
        try {
            System.out.println(System.getProperty("user.dir"));
            src = new Scanner(new File(args[0]));

            g = new Graph(src);
            System.out.println(g);

            // Turtle.create(800, 800);


            /* g.colorLF();
            System.out.println("\nLF used " + g.numberOfColorsUsed() + " colors.");
            g.displayColoringResults();
            g.draw();
            Turtle.render();
            System.out.println("Hit enter to continue.");
            stdIn.nextLine();

            Turtle.clear();
            g.colorSL();
            System.out.println("\nSL used " + g.numberOfColorsUsed() + " colors.");
            g.displayColoringResults();
            g.draw();
            Turtle.render();
            System.out.println("Hit enter to continue.");
            stdIn.nextLine();

            /***

             uncomment whichever of these two that you do.

             Turtle.clear();
             g.colorSLI();
             System.out.println("\nSLI used " + g.numberOfColorsUsed() + " colors.");
             g.displayColoringResults();
             g.draw();
             Turtle.render();
             System.out.println("Hit enter to continue.");
             stdIn.nextLine();


             Turtle.clear();
             g.colorRLF();
             System.out.println("\nRLF used " + g.numberOfColorsUsed() + " colors.");
             g.displayColoringResults();
             g.draw();
             Turtle.render();

             ***/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
