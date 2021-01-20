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
            IstRunners = new Node<>(new Runner(r));
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
	if(cur.getValue().getId().equals(id)) {
        	cur.getValue().addMrtn(new Item(this.getYearMrtn(), score));
	}
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


    public static int consistentRunners(MrtnRace m) {
        Node<Runner> cur = m.getIstRunners();
	int count = 0;

        while (cur != null) {
            if (cur.getValue().ran3InARow()) {
                count++;
            }
            cur = cur.getNext();
        }

        return count;
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
