import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
    This is the main entry point for this program. This file's main method will call functions on the ColorCombination
    class, which contains all the logic.
 */
public class ColorCombinationMain {

    public static void main(String[] args) {

        ArrayList<String> input = readFileAsArray(args[0]);

        // program should terminate if input file is malformed
        if (input.size() % 2 != 0) {
            System.out.println("Input file has an odd number of colors! Terminating...");
            System.exit(0);
        }

        ColorCombination cc = new ColorCombination(input);
        cc.searchForCombination();
        boolean result = cc.combinationIsPossible;
        System.out.println(result ? "Correct Combination: " + cc.solution : "Cannot unlock master pannel!");

    }

    /*
        Reads data from the given file with each color as a new String in an ArrayList
     */
    public static ArrayList<String> readFileAsArray(String fileName) {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();

            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(Arrays.asList(line.split(",")));
    }
}
