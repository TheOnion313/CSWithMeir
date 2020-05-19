import java.util.Objects;

public class DateTime {
    private Date dt;
    private Time tm;

    public DateTime(Date dt, Time tm) {
        this.dt = new Date(dt);
        this.tm = new Time(tm);
    }

    public DateTime(DateTime dtm) {
        this.dt = dtm.getDate();
        this.tm = dtm.getTime();
    }

    public Date getDate() {
        return new Date(dt);
    }

    public void setDate(Date dt) {
        this.dt = new Date(dt);
    }

    public Time getTime() {
        return new Time(tm);
    }

    public void setTime(Time tm) {
        this.tm = new Time(tm);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTime dateTime = (DateTime) o;
        return Objects.equals(dt, dateTime.dt) &&
                Objects.equals(tm, dateTime.tm);
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "date=" + dt.toString() +
                ", time=" + tm.toString() +
                '}';
    }

    public boolean isBefore(DateTime dt) {
        if (this.dt.isBefore(dt.getDate())) {
            return true;
        } else if (this.dt.isAfter(dt.getDate())) {
            return false;
        } else return this.tm.isBefore(dt.getTime());
    }

    public boolean isAfter(DateTime dt) {
        if (this.dt.isAfter(dt.getDate())) {
            return true;
        } else if (this.dt.isBefore(dt.getDate())) {
            return false;
        } else return this.tm.isAfter(dt.getTime());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Date d = new Date(7, 1, 2004);
        Time t = new Time(12, 30, 15);


        Date d2 = new Date(23, 12, 1998);
        Time t2 = new Time(1, 24, 54);

        DateTime a = new DateTime(d, t);
        DateTime a2 = new DateTime(d2, t2);


        System.out.println(a2.isBefore(a));
        System.out.println(a.isBefore(a2));

        System.out.println(a.getDate().toString());

        System.out.println(a.toString());

    }
}
