public class Book {
    private String name;
    private int shelf;
    private boolean interesting;

    public Book(String name, int shelf, boolean interesting) {
        this.name = name;
        this.shelf = shelf;
        this.interesting = interesting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public boolean isInteresting() {
        return interesting;
    }

    public void setInteresting(boolean interesting) {
        this.interesting = interesting;
    }
}
