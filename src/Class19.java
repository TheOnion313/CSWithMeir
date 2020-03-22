public class Class19 {

    public static void main(String[] args) {
        //planning my wedding
        Date dateOfWedding = new Date(31, 12, 2020);
        String description = "You are invited to Kobi and Maya's wedding!!!\n   Can't wait to see you.";
        Location address = new Location("Israel", "Tzfat", "Or", "609A");
        Name[] guestList = new Name[]{
            new Name("Kobi", "Keshet"), new Name("Maya", "Or"), new Name("May", "Zehavi"), new Name("Gal", "Zehavi"),
            new Name("Or", "Zehavi"), new Name("Tami", "Zehavi"), new Name("Avi", "Zehavi"), new Name("Shlomo", "Zehavi"),
            new Name("Arnon", "Zehavi"), new Name("Arie", "Zehavi")};
        Event wedding = new Event(dateOfWedding, description, address, guestList);
        System.out.println(wedding);
    }
}
