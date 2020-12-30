public class Item {

    private int year, score;

    public Item(int year, int score) {
        this.year = year;
        this.score = score;
    }

    public Item(Item i) {
        this.year = i.getYear();
        this.score = i.getScore();
    }

    public int getYear() {
        return year;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return "Item{" +
                "year=" + year +
                ", score=" + score +
                '}';
    }

}
