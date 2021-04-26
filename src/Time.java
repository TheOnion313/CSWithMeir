public class Time {
    int hour, minute;

    public Time(int hour, int minute) {
        this.hour = hour >= 0 && hour <= 23 ? hour : 0;
        this.minute = minute >= 0 && minute <= 59 ? minute : 0;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
