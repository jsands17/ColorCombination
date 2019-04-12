
/*
    Abstract representation of a tile with two colors. The tile can be flipped to switch the right and left colors.
 */
public class Bicolor {

    private String color1, color2;

    public Bicolor(String c1, String c2) {
        this.color1 = c1;
        this.color2 = c2;
    }

    public String getLeftColor() {
        return this.color1;
    }

    public String getRightColor() {
        return this.color2;
    }

    public void flip() {
        String temp = this.color1;
        this.color1 = this.color2;
        this.color2 = temp;
    }

    @Override
    public String toString() {
        return this.color1 + "|" + this.color2;
    }
}
