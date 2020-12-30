import java.util.Arrays;
import java.util.Random;

public class MrtnRace {
    private String country;
    private int yearMrtn, currRunners;
    private Runner[] IstRunners;

    public MrtnRace(String country, int yearMrtn, int maxR) {
        this.country = country;
        this.yearMrtn = yearMrtn;
        IstRunners = new Runner[maxR];
    }

    public void addRunner(Runner r) {
        // complexity: the function checks if current amount of runners doesn't exceed max, if so it doesn't add, therefore.
        // complexity is O(1)
        if (currRunners < IstRunners.length) {
            currRunners++;
            IstRunners[currRunners - 1] = new Runner(r);
        }
    }

    public void addScoreToRunner(int score, String id) {
        // complexity: define n as index of correct runner in array, n is not limited.
        // since the function goes over the array of runners until it finds the correct runner and terminates, complexity is O(n)
        for(int i = 0; i < currRunners; i++) {
            if(IstRunners[i].getId().equals(id)) {
                IstRunners[i].addMrtn(new Item(this.yearMrtn, score));
                break;
            }
        }
    }

    public String getCountry() {
        return country;
    }

    public int getYearMrtn() {
        return yearMrtn;
    }

    public Runner[] getIstRunners() {
        Runner[] runners = new Runner[this.IstRunners.length];
        for (int i = 0; i < runners.length; i++) {
            runners[i] = this.IstRunners[i];
        }
        return runners;
    }

    public int getCurrRunners() {
        return currRunners;
    }

    public static Runner[] consistentRunners(MrtnRace m) {
        //define m as each runner's amount of marathons, and n as the amount of runners in the marathon, n and m are not limited.
        //the function goes over every runner in the race twice and for each runner it goes over all its marathons, therefore 2*n*m
        // take out factors: O(nm)
        int count = 0;
        Runner[] runners = m.getIstRunners();
        for(int i = 0; i < m.getCurrRunners(); i++) {
            if(runners[i].ran3InARow()) {
                count++;
            }
        }
        Runner[] returnn = new Runner[count];
        count = 0;
        for(int i = 0; i < m.getCurrRunners(); i++) {
            if(runners[i].ran3InARow()) {
                returnn[count] = new Runner(runners[i]);
                count++;
            }
        }
        return returnn;
    }

    @Override
    public String toString() {
        return "MrtnRace{" +
                "country='" + country + '\'' +
                ", yearMrtn=" + yearMrtn +
                ", currRunners=" + currRunners +
                ", IstRunners=" + Arrays.toString(IstRunners) +
                '}';
    }

    public static void main(String[] args) {
        int cap = 45;
        MrtnRace m = new MrtnRace("Finland", 2017, cap);
        Random r = new Random();
        m.addRunner(new Runner("12345", 1999, 0, new Item[80]));
        m.addScoreToRunner(r.nextInt(), "12345");
        System.out.println(m);
        System.out.println(Arrays.toString(consistentRunners(m)));
        m.addRunner(new Runner("456789", 1980, 3,
                new Item[] {new Item(2003, 567), new Item(2004, 0), new Item(2005, 20)}));
        System.out.println(m);
        System.out.println(Arrays.toString(consistentRunners(m)));
    }

}
