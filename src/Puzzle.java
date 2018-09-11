import java.util.*;
import java.io.*;

public class Puzzle {

    /*
    STATES
     */

    //goal state
    int goalState [][]= {{0,1,2}, {3,4,5}, {6,7,8}};

    //current state
    int currentState [][] = {{0,1,2}, {3,4,5}, {6,7,8}};

    //position of blank
    int blank [] = {0,0};

    /*
    CONSTRUCTORS
     */

    /*
    HELPER METHODS
     */

    //Print the state of the puzzle
    public void printState (){

        String print = "";
        System.out.println("The state of the puzzle is:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (currentState[i][j] == 0)
                    print += "b";
                else
                    print += currentState [i][j];
                    print += " ";
            }
            System.out.println(print);
            print = "";

        }
    }

    //Set the state of the puzzle
    public void setState(String s)
    {
        int k = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s.charAt(k) == ('b')) {
                    currentState[i][j] = 0;
                    blank[0] = i;
                    blank[1] = j;
                } else {
                    currentState[i][j] = s.charAt(k) - '0';
                }
                k++;
            }
        }
    }

    //Move the blank piece around
    public void move(String s){
        if (s == "up" && blank[0] != 0){
            //swap the tiles
            int x = currentState[blank[0]-1][blank[1]];
            currentState[blank[0]-1][blank[1]] = 0;
            currentState[blank[0]][blank[1]] = x;

            //overwrite location of blank tile
            blank [0] = blank[0] - 1;

        } else if (s == "down" && blank[0] != 2 ){
            //swap the tiles
            int x = currentState[blank[0]+1][blank[1]];
            currentState[blank[0]+1][blank[1]] = 0;
            currentState[blank[0]][blank[1]] = x;

            //overwrite location of blank tile
            blank [0] = blank[0] + 1;

        } else if (s == "left" && blank[1] != 0){
            //swap the tiles
            int x = currentState[blank[0]][blank[1]-1];
            currentState[blank[0]][blank[1] - 1] = 0;
            currentState[blank[0]][blank[1]] = x;

            //overwrite location of blank tile
            blank [1] = blank[1] - 1;

        } else if (s =="right" && blank[1] != 2){
            //swap the tiles
            int x = currentState[blank[0]][blank[1]+1];
            currentState[blank[0]][blank[1] + 1] = 0;
            currentState[blank[0]][blank[1]] = x;

            //overwrite location of blank tile
            blank [1] = blank[1] + 1;

        } else {
            System.out.println("Not a valid move, please try again.");
        }
    }

    /*
    MAIN METHOD
     */
    public static void main(String[] args) {

        Puzzle puzzle = new Puzzle();
        System.out.println("Welcome to Anna's Project!");
        System.out.println();

        puzzle.setState("b12345678");
        puzzle.printState();

        puzzle.move("right");
        puzzle.printState();

        puzzle.move("left");
        puzzle.printState();

        puzzle.move("down");
        puzzle.printState();

        puzzle.move("up");
        puzzle.printState();

        /*
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName)));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                // process line
            }
        } finally {
            br.close();
        }*/

        //Check for input
        if (args.length > 0) {
            if (args[0].equals( "printState"))
                puzzle.printState();
            if (args[0].equals("setState"))
                puzzle.setState(args[1] + args[2] + args[3]);
        }
        else
            System.out.println("No command line arguments found, check your inputs.");
    }
}
