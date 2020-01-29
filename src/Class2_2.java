package Classes;

public class Class2_2 {
    public static void main(String[] args) {
        //Calculates number's digits' sum
        int sum = 0;
        int num = 177;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        System.out.println("Sum of digits: " + sum);

        //Calculates number's digits' product
        int product = 1;
        int productNum = 177;
        while (productNum > 0) {
            product *= product % 10;
            productNum = productNum / 10;
        }
        System.out.println("Product of digits: " + product);

        //Checks if all digits are even
        boolean even = true;
        int evenNum = 266;
        while (evenNum > 0 && even) {
            even = evenNum % 2 == 0;
            evenNum /= 10;
        }
        String ui = even ? "all even" : "not all even";
        System.out.println("The digits are " + ui);


    }
}
