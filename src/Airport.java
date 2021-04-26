public class Airport {
    Flight[] flights;

    public Airport(Flight[] flights) {
        this.flights = flights;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    public boolean isFlyWrong() {
        for (int i = 0; i < flights.length; i++) {
            if (flights[i].getName().equals("Sky")) return true;
            return false;
        }
        /* C1
        הפעולה תחזיר שקר למרות שהתוצאה אמורה להיות אמת
        הפעולה תבדוק האם שם חברת התעופה בטיסה הראשונה היא Sky
        מכיוון שהיא לא הפעולה לא תפעיל את התוצאה של התנאי ותמשיך הלאה
        שם תחזיר שקר, ולא תמשיך את הלולאה
         */
        /* C2
        השגיאה בפעולה היא שהחזרת השקר במידה ואין טיסה מטעם חברת Sky
        נמצאת בתוך הלולאה ולא מחוץ לה, לכן ברגע שהטיסה הראשונה אינה
        של חברת Sky מוחזר שקר לפני שנבדקות שאר הטיסות
         */
    }

    public boolean isFly() {
        for (Flight f : flights) { // check each flight
            if (f.getName().equals("Sky")) { // if one of the flights' name is "Sky" return true
                return true;
            }
        }
        // None of the flights' company name is Sky, return false
        return false;
    }
}
