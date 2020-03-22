import java.util.Arrays;

public class Event {
    private Date date;
    private String description;
    private Location address;
    private Name[] guestList;

    public Event(Date dt, String desc, Location addr, Name[] gstLst) {
        date = dt;
        description = desc;
        address = addr;
        guestList = gstLst;
    }

    public Event(Event evnt) {
        date = evnt.getDate();
        description = evnt.getDescription();
        address = evnt.getAddress();
        guestList = evnt.getGuestList();
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Location getAddress() {
        return address;
    }

    public Name[] getGuestList() {
        return guestList;
    }

    public void setDate(Date dt) {
        date = dt;
    }

    public void setAddress(Location lct) {
        address = lct;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public void setGuestList(Name[] gstLst) {
        guestList = gstLst;
    }

    public String toString() {
        return String.format("%s\n%s\n%s\nInvited:%s", description, date, address, Arrays.toString(guestList));
    }
}
