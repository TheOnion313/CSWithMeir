import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PassPort {
    private String name, lastName, number, id;
    private Date issueDate, expDate, birth;

    public PassPort(String name, String lastName, String number, String id, Date issueDate, Date expDate, Date birth) {
        this.name = name;
        this.lastName = lastName;
        this.number = number;
        this.id = id;
        this.issueDate = issueDate;
        this.expDate = expDate;
        this.birth = birth;
    }

    public PassPort(PassPort p) {
        this.name = p.getName();
        this.lastName = p.getLastName();
        this.number = p.getNumber();
        this.id = p.getId();
        this.issueDate = p.getIssueDate();
        this.expDate = p.getExpDate();
        this.birth = p.getBirth();
    }


    @Override
    public String toString() {
        return "PassPort{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number='" + number + '\'' +
                ", id='" + id + '\'' +
                ", issueDate=" + issueDate +
                ", expDate=" + expDate +
                ", birth=" + birth +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public static boolean willBeExpired(PassPort p, Date t) {
        return !t.isBefore(p.getExpDate());
    }

    public static void main(String[] args) {
        main1(args);
        PassPort p = new PassPort("a", "b", "c", "d", new Date(1, 2, 3),
                new Date(2, 3, 4), new Date(3, 4, 5));
        PassPort p1 = new PassPort("a", "b", "c", "d", new Date(1, 2, 3),
                new Date(13, 15, 78), new Date(3, 4, 5));
        PassPort p2 = new PassPort("a", "b", "c", "d", new Date(1, 2, 3),
                new Date(14, 15, 78), new Date(3, 4, 5));
        Date today = new Date(13, 15, 78);
        System.out.println(willBeExpired(p, today));
        System.out.println(willBeExpired(p1, today));
        System.out.println(willBeExpired(p2, today));
    }

    public static void main1(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = -1;
        while (n <= 0) {
            System.out.println("Put positive number");
            n = s.nextInt();
        }
        Random r = new Random();
        PassPort[] ps = new PassPort[n];
        String[] names = new String[]{"Cohen", "Mizrahi", "Abu", "Ali", "Licht", "Or", "Nevo", "Nisgav", "Atias"};
        Date[] dates = new Date[]{new Date(r.nextInt(), r.nextInt(), r.nextInt()), new Date(r.nextInt(), r.nextInt(),
                r.nextInt()), new Date(r.nextInt(), r.nextInt(), r.nextInt()), new Date(r.nextInt(), r.nextInt(), r.nextInt()),
                new Date(r.nextInt(), r.nextInt(), r.nextInt()), new Date(r.nextInt(), r.nextInt(), r.nextInt()), new Date(r.nextInt(),
                r.nextInt(), r.nextInt()), new Date(r.nextInt(), r.nextInt(), r.nextInt()), new Date(r.nextInt(), r.nextInt(),
                r.nextInt()), new Date(r.nextInt(), r.nextInt(), r.nextInt()), new Date(r.nextInt(), r.nextInt(), r.nextInt()),
                new Date(r.nextInt(), r.nextInt(), r.nextInt()), new Date(r.nextInt(), r.nextInt(), r.nextInt()), new Date(r.nextInt(),
                r.nextInt(), r.nextInt()), new Date(r.nextInt(), r.nextInt(), r.nextInt()), new Date(r.nextInt(), r.nextInt(), r.nextInt()),
                new Date(r.nextInt(), r.nextInt(), r.nextInt()), new Date(r.nextInt(), r.nextInt(), r.nextInt())};
        for (int i = 0; i < ps.length; i++) {
            ps[i] = new PassPort(names[r.nextInt(names.length)], names[r.nextInt(names.length)], names[r.nextInt(names.length)],
                    names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], dates[r.nextInt(dates.length)],
                    dates[r.nextInt(dates.length)]);
        }
        PassPort[] sorted = insertionSort(ps);
        System.out.println(Arrays.toString(sorted));
        System.out.println("\n\n");

        for (int i = 0; i < ps.length; i++) {
            String currentLast = ps[i].getLastName();
            for (int j = i + 1; j < ps.length; j++) {
                if (ps[j].getLastName().equals(ps[i].getLastName())) {
                    swap(ps, j, i + 1);
                    i++;D
                }
            }
            i++;
        }
        System.out.println(Arrays.toString(ps));


    }

    public static void swap(PassPort[] arr, int id1, int id2) {
        PassPort tmp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = tmp;
    }

    public static PassPort[] insertionSort(PassPort[] arr) {
        int minidx;
        for (int i = 0; i < arr.length; i++) {
            minidx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].getBirth().isAfter(arr[minidx].getBirth())) {
                    minidx = j;
                }
            }
            swap(arr, minidx, i);
        }
        return arr;
    }
}
