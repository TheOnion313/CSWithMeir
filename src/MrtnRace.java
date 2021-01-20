import DS.Node;

@SuppressWarnings("ALL")
public class MrtnRace {
    private String country;
    private int yearMrtn;
    private Node<Runner> IstRunners;

    public MrtnRace(String country, int yearMrtn) {
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
            cur.setNext(new Node<>(new Runner(r)));
        }
    }

    public void addScoreToRunner(int score, String id) {
        Node<Runner> cur = IstRunners;
        while (!cur.getValue().getId().equals(id) && cur.hasNext()) {
            cur = cur.getNext();
        }
        if (cur.getValue().getId().equals(id)) {
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

    public static void checkAddRunner() {
        MrtnRace m = new MrtnRace("Israel", 2021);
        m.addRunner(new Runner("328766567", 2004, new Node<>(new Item(2008, 9000))));
        System.out.println("One runner:\n\t" + m + "\n"); // check add runner func
        m.addRunner(new Runner("328766732", 2002, new Node<>(new Item(2010, 20))));
        System.out.println("Two runners: \n\t" + m + "\n\n"); // again
    }

    public static void checkAddScoreToRunner() {
        MrtnRace m = new MrtnRace("Israel", 2021);
        Runner runners = new Runner("4637634734", 1999, new Node<>(new Item(2008, 9000)));
        runners.addMrtn(new Item(2012, 900));
        m.addRunner(runners);
        Runner runner = new Runner("129982109", 1990, new Node<>(new Item(2002, 80)));
        runner.addMrtn(new Item(2020, 900));
        m.addRunner(runner);

        System.out.println("Before new score was added:\n\t" + m + "\n"); // check functions acctually added runners to marathon
        m.addScoreToRunner(9000, "129982109");
        System.out.println("Runner with id 129982109 was added a new score:\n\t " + m + "\n\n"); // check score was added to runner appropriately
    }

    public static void check3InARow() {
        MrtnRace m = new MrtnRace("Israel", 2021);
        Runner runner = new Runner("49837943", 1980, new Node<>(new Item(2002, 80)));
        m.addRunner(runner);
        runner.addMrtn(new Item(2003, 80));
        System.out.println("There are no consistent runners: " + consistentRunners(m)); // this runner didnt run 3 in a row so there are 0

        runner.addMrtn(new Item(2004, 80));
        m.addRunner(runner);

        System.out.println("One runner is consistent: " + consistentRunners(m)); // this time we added a new runner (the function copies each one they give so it doesn't point to the same one)
        // this runner did run 3 in a row so it should print 1

    }

    public static void main(String[] args) {
        checkAddRunner();
        checkAddScoreToRunner();
        check3InARow();

    }


}
