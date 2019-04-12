import java.util.ArrayList;

class ColorCombinationTest {

    static boolean allTestsPassed;

    public static void main(String args[]) {
        allTestsPassed = true;
        testEmptyTilesSameColoredMarker();
        testEmptyTilesMismatchColoredMarker();
        testOneTileNoPossibleCombo();
        testOneTileComboPossible();
        testProblemExample1();
        testProblemExample2();
        testProblemExample3();

        if (allTestsPassed) {
            System.out.println("----ALL TESTS PASSED!----");
        }
    }

    public static void testEmptyTilesSameColoredMarker () {
        ArrayList<String> input = ColorCombinationMain.readFileAsArray("tests/emptyTilesSameColoredMarkers.txt");
        ColorCombination cc = new ColorCombination(input);
        cc.searchForCombination();
        boolean result = cc.combinationIsPossible;

        if (!result || !cc.solution.isEmpty()) {
            displayTestError("empty tiles same colored marker");
        }
    }


    public static void testEmptyTilesMismatchColoredMarker () {
        ArrayList<String> input = ColorCombinationMain.readFileAsArray("tests/emptyTilesMismatchColoredMarkers.txt");
        ColorCombination cc = new ColorCombination(input);
        cc.searchForCombination();
        boolean result = cc.combinationIsPossible;

        if (result || !cc.solution.isEmpty()) {
            displayTestError("empty tiles mismatch colored marker");
        }
    }


    public static void testOneTileNoPossibleCombo () {
        ArrayList<String> input = ColorCombinationMain.readFileAsArray("tests/oneTileNoPossibleCombo.txt");
        ColorCombination cc = new ColorCombination(input);
        cc.searchForCombination();
        boolean result = cc.combinationIsPossible;

        if (result || !cc.solution.isEmpty()) {
            displayTestError("one tile with no possible combination");
        }
    }


    public static void testOneTileComboPossible () {
        ArrayList<String> input = ColorCombinationMain.readFileAsArray("tests/oneTileComboPossible.txt");
        ColorCombination cc = new ColorCombination(input);
        cc.searchForCombination();
        boolean result = cc.combinationIsPossible;

        if (!result || cc.solution.isEmpty()) {
            displayTestError("one tile with a combination possible");
        }
    }

    public static void testProblemExample1() {
        ArrayList<String> input = ColorCombinationMain.readFileAsArray("tests/test3.txt");
        ColorCombination cc = new ColorCombination(input);
        cc.searchForCombination();
        boolean result = cc.combinationIsPossible;

        if (result || !cc.solution.isEmpty()) {
            displayTestError("5 tiles with no possible combination");
        }
    }

    public static void testProblemExample2() {
        ArrayList<String> input = ColorCombinationMain.readFileAsArray("tests/test1.txt");
        ColorCombination cc = new ColorCombination(input);
        cc.searchForCombination();
        boolean result = cc.combinationIsPossible;

        if (!result || cc.solution.isEmpty()) {
            displayTestError("5 tiles with possible combination");
        }
    }

    public static void testProblemExample3() {
        ArrayList<String> input = ColorCombinationMain.readFileAsArray("tests/test2.txt");
        ColorCombination cc = new ColorCombination(input);
        cc.searchForCombination();
        boolean result = cc.combinationIsPossible;

        if (!result || cc.solution.isEmpty()) {
            displayTestError("8 tiles with possible combination");
        }
    }

    public static void displayTestError(String testName) {
        System.out.println("TEST FAILED: " + testName);
        allTestsPassed = false;
    }

}