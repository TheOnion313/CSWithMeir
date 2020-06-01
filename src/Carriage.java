public class Carriage {
    private int id, capacity;

    public Carriage(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Carriage(Carriage c) {
        this.id = c.getId();
        this.capacity = c.getCapacity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "id=" + id +
                ", capacity=" + capacity +
                '}';
    }

    public boolean equals(Carriage c) {
        return this.toString().equals(c.toString());
    }
}
