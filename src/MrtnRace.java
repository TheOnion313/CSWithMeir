import DS.Node;

import java.util.Arrays;
import java.util.Random;

public class MrtnRace {
    private String country;
    private int yearMrtn;
    private Node<Runner> IstRunners;

    public MrtnRace(String country, int yearMrtn, int maxR) {
        this.country = country;
        this.yearMrtn = yearMrtn;
    }

    public void addRunner(Runner r) {
        if (IstRunners == null) {
            IstRunners = new Node<>(r);
        } else {
            Node<Runner> cur = IstRunners;
            while (cur.hasNext()) {
                cur = cur.getNext();
            }
            cur.setNext(new Node<>(r));
        }
    }

    public void addScoreToRunner(int score, String id) {
        Node<Runner> cur = IstRunners;
        while (!cur.getValue().getId().equals(id) && cur.hasNext()) {
            cur = cur.getNext();
        }
        cur.getValue().addMrtn(new Item(this.getYearMrtn(), score));
    }

    public String getCountry() {
        return country;
    }

    public int getYearMrtn() {
        return yearMrtn;
    }

    public Node<Runner> getIstRunners() {
        return IstRunners;
    }


    public static Node<Runner> consistentRunners(MrtnRace m) {
        Node<Runner> cur = m.getIstRunners();
        Node<Runner> ret = null;
        Node<Runner> c = ret;

        while (cur != null) {
            if (cur.getValue().ran3InARow()) {
                if (ret == null) {
                    Runner value = cur.getValue();
                    ret = new Node<>(new Runner(value.getId(), value.getYearB(), value.getIstRunners()));
                    c = ret;
                } else {
                    Runner value = cur.getValue();
                    c.setNext(new Node<>(new Runner(value.getId(), value.getYearB(), value.getIstRunners())));
                    c = c.getNext();
                }
            }
            cur = cur.getNext();
        }

        return ret;
    }

    @Override
    public String toString() {
        return "MrtnRace{" +
                "country='" + country + '\'' +
                ", yearMrtn=" + yearMrtn +
                ", IstRunners=" + IstRunners +
                '}';
    }
    
}
