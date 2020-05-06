public class Time {

    private int seconds;
    private int minutes;
    private int hours;

    public Time(int seconds, int minutes, int hours) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    public Time(Time dt) {
        this.seconds = dt.getSeconds();
        this.minutes = dt.getMinutes();
        this.hours = dt.getHours();
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int dd) {
        seconds = dd;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int mm) {
        minutes = mm;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int yy) {
        hours = yy;
    }

    public boolean equals(Time dt) {
        return (seconds == dt.getSeconds() && minutes == dt.getMinutes() && hours == dt.getHours());
    }

    public boolean isAfter(Time dt) {
        return hours > dt.getHours() || (hours == dt.getHours() && minutes > dt.getMinutes()) || (hours == dt.getHours() && minutes == dt.getMinutes() && seconds > dt.getSeconds());
    }

    public boolean isBefore(Time dt) {
        return dt.isAfter(this);
    }

    public String toString() {
        return String.format("Seconds: %d\nMinutes: %d\nHours: %d", seconds, minutes, hours);
    }
}
