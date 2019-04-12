import java.util.ArrayList;

/*
    This class contains all of the logic required to search for a combination of color tiles.
 */
public class ColorCombination {

    public ArrayList<Bicolor> solution;
    public boolean combinationIsPossible;

    private ArrayList<Bicolor> bicolors;
    private String startingColorChip;
    private String endingColorChip;


    public ColorCombination(ArrayList<String> strs) {
        bicolors = new ArrayList<>();
        solution = new ArrayList<>();
        dissectColorsFromArrayList(strs);
    }

    public void searchForCombination() {
        this.combinationIsPossible = getCorrectColorCombination(bicolors, solution, startingColorChip);
    }

    /*
        Searches through the remaining tiles left to see if a combination of tiles is possible
     */
    public boolean getCorrectColorCombination(ArrayList<Bicolor> bagOfTiles, ArrayList<Bicolor> correctOrder, String startingColor) {

        // once there are no more tiles left, we have reached a valid combination only if the startingColor parameter
        // is equal to the endingColorChip instance variable
        if (bagOfTiles.isEmpty()) {
            if (startingColor.equals(endingColorChip)) {
                return true;
            } else {
                return false;
            }
        }

        // I use a temporary ArrayList here to prevent a concurrent modification exception while iterating through the
        // bag of tiles
        ArrayList<Bicolor> temp = new ArrayList<>(bagOfTiles);

        for (Bicolor bicolor : bagOfTiles) {
            if (bicolor.getLeftColor().equals(startingColor)) {
                temp.remove(bicolor);

                // recursive call to search for next valid color tile
                if (!getCorrectColorCombination(temp, correctOrder, bicolor.getRightColor())) {
                    temp.add(bicolor);
                } else {
                    correctOrder.add(0, bicolor);
                    return true;
                }

            } else if (bicolor.getRightColor().equals(startingColor)) {
                bicolor.flip();
                temp.remove(bicolor);

                // recursive call to search for next valid color tile
                if (!getCorrectColorCombination(temp, correctOrder, bicolor.getRightColor())) {
                    temp.add(bicolor);
                } else {
                    correctOrder.add(0, bicolor);
                    return true;
                }
            }
        }
        return false;

    }

    /*
        Separates the array of colors into Bicolors; each Bicolor represents a tile with two colors
     */
    private void dissectColorsFromArrayList(ArrayList<String> arr) {
        startingColorChip = arr.get(0);
        endingColorChip = arr.get(1);

        for (int i = 2; i < arr.size(); i += 2) {

            // this is safe only because we are assuming the ArrayList arr always has an even number of elements
            bicolors.add(new Bicolor(arr.get(i), arr.get(i + 1)));
        }
    }
}
