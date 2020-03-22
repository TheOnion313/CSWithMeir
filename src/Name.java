public class Name {
    private String lastName, firstName;

    public Name(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastName = lastname;
    }

    public Name(Name nm) {
        this.firstName = nm.getFirstName();
        this.lastName = nm.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

}
