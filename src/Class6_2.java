package Classes;

public class Class6_2 {

    public static void main(String[] args) {
        boolean foundFirst = false;
        int secondDivided = 0;
        for (int i = 10000; i <= 20000; i++) {
            if (i % 53 == 0) {
                if (!foundFirst) {
                    foundFirst = true;
                } else {
                    secondDivided = i;
                    i = 20001;
                }
            }
        }
        System.out.println(secondDivided);
    }
}
