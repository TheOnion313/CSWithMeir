public class Ring {
    private String size; // גודל הטבעת
    private int color; // צבע הטבעת

    public Ring() {
        this.size = "L";
        this.color = 0;
    }

    public Ring(String str, int c) {
        this.size = str;
        this.color = c;
    }

    public String getSize() {
        return this.size;
    }

    public int getColor() {
        return this.color;
    }

    public String toString() {
        return String.format("{Size: '%s'; Color: %d}", this.size, this.color);
    }
}
