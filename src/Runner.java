import java.util.Arrays;

public class Runner {
    private String id;
    private int yearB, currMrtns;
    private Item[] IstItems;

    @Override
    public String toString() {
        return "Runner{" +
                "id='" + id + '\'' +
                ", yearB=" + yearB +
                ", currMrtns=" + currMrtns +
                ", IstItems=" + Arrays.toString(IstItems) +
                '}';
    }

    public Runner(String id, int yearB, int currMrtns, Item[] istItems) {
        this.id = id;
        this.yearB = yearB;
        this.currMrtns = currMrtns;
        this.IstItems = new Item[istItems.length];
        for (int i = 0; i < istItems.length; i++) {
            this.IstItems[i] = istItems[i];
        }
    }

    public Runner(Runner r) {
        currMrtns = r.getCurrMrtns();
        id = r.getId();
        yearB = r.getYearB();
        IstItems = r.getIstRunners();
    }

    public int getCurrMrtns() {
        return currMrtns;
    }

    public String getId() {
        return id;
    }

    public int getYearB() {
        return yearB;
    }

    public Item[] getIstRunners() {
        Item[] items = new Item[this.IstItems.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = this.IstItems[i];
        }
        return items;
    }

    public void addMrtn(Item i) {
        if (currMrtns < IstItems.length) {
            IstItems[currMrtns] = new Item(i);
            currMrtns++;
        }
    }

    public boolean ran3InARow() {
        for (int i = 0; i < currMrtns - 2; i++) {
            if (IstItems[i].getYear() == IstItems[i+1].getYear() - 1 && IstItems[i + 1].getYear() == IstItems[i + 2].getYear() - 1) {
                return true;
            }
        }
        return false;
    }
}
