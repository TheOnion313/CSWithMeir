package Classes;

public class Class6_3 {

    public static void main(String[] args) {
        int sum = 0;
        int tmp;
        for (int i = 501; i <= 599; i++) {
            tmp = i;
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += tmp % 10;
                tmp /= 10;
            }
            System.out.println("The sum of " + i + "'s digits is " + sum);
        }
    }
}
