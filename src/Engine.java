import java.util.Objects;

public class Engine {
    private int productionYear, id;

    public Engine(int productionYear, int id) {
        this.productionYear = productionYear;
        this.id = id;
    }

    public Engine(Engine e) {
        this.productionYear = e.getProductionYear();
        this.id = e.getId();
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "productionYear=" + productionYear +
                ", id=" + id +
                '}';
    }

    public boolean equals(Engine e) {
        return this.toString().equals(e.toString());
    }
}
