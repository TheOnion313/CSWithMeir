import java.util.Objects;

public class DateTime {
    private Date dt;
    private Time tm;

    public DateTime(Date dt, Time tm) {
        this.dt = new Date(dt);
        this.tm = new Time(tm);
    }

    public DateTime(DateTime dtm) {
        this.dt = dtm.getDt();
        this.tm = dtm.getTm();
    }

    public Date getDt() {
        return new Date(dt);
    }

    public void setDt(Date dt) {
        this.dt = new Date(dt);
    }

    public Time getTm() {
        return new Time(tm);
    }

    public void setTm(Time tm) {
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
                "dt=" + dt.toString() +
                ", tm=" + tm.toString() +
                '}';
    }
}
