public class Location {
    private String country, city, street, number;

    public Location(String cntry, String cty, String strt, String num) {
        country = cntry;
        city = cty;
        street = strt;
        number = num;
    }

    public Location(Location loc) {
        country = loc.getCountry();
        city = loc.getCity();
        street = loc.getStreet();
        number = loc.getNumber();
    }

    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }
    public String getNumber() {
        return number;
    }
    public void setCountry(String cntry) {
        country = cntry;
    }
    public void setCity(String cty) {
        city = cty;
    }
    public void setStreet(String strt) {
        street = strt;
    }
    public void setNumber(String num) {
        number = num;
    }


    public String toString() {
        return String.format("%s, %s %s St. %s", country, city, street, number);
    }
}
