public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(Date dt) {
        this.day = dt.getDay();
        this.month = dt.getMonth();
        this.year = dt.getYear();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int dd) {
        day = dd;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int mm) {
        month = mm;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int yy) {
        year = yy;
    }

    public boolean equals(Date dt) {
        return (day == dt.getDay() && month == dt.getMonth() && year == dt.getYear());
    }

    public boolean isAfter(Date dt) {
        return year > dt.getYear() || (year == dt.getYear() && month > dt.getMonth()) || (year == dt.getYear() && month == dt.getMonth() && day > dt.getDay());
    }

    public boolean isBefore(Date dt) {
        return dt.isAfter(this);
    }

    public String toString() {
        return String.format("Day: %d\nMonth: %d\nYear: %d", day, month, year);
    }
}
