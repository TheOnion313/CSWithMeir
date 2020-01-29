package Classes;

public class Class2_3 {
    public static void main(String[] args) {
        int num = 69;
        int sum = 0;
        int product = 1;
        int units = num % 10;
        while(num > 0) {
            if(units % 2 == 0) {
                sum += num % 10;
            } else {
                if(num % 10 % 2 != 0) {
                    product *= num % 10;
                }
            }
            num /= 10;
        }
        System.out.println();
    }
}
