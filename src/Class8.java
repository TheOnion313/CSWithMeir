package Classes;

public class Class8 {
    public static int revInt(int num) {
        int num1 = num;
        int counter = 0;
        int revNum = 0;
        while(num1 > 0) {
            counter++;
            num1 /= 10;
        }
        for(int i = counter; i > 0; i--) {
            revNum += num % 10 * Math.pow(10, i - 1);
            num /= 10;
    }
        return revNum;
    }

    public static boolean evenPos(int num) {
        int num1 = num;
        int counter = 0;
        while(num1 > 0) {
            counter++;
            num1 /= 10;
        }
        boolean evenPos = false;
        for(int i = 0; i < counter; i++) {
            if(num % 10 % 2 == 0 && !evenPos) {
                return false;
            }
            evenPos = !evenPos;
        }
        return true;
    }

    public static boolean isPali(int num) {
        return num == revInt(num);
    }

    public static void paliRange(int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            System.out.print(isPali(i) ? i + "\n" : "");
        }
    }

    public static void evenPosRange(int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            System.out.print(evenPos(i) ? i + "\n" : "");
        }
    }

    public static void evenPosAndPaliRange(int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            System.out.print(evenPos(i) && isPali(i) ? i + "\n" : "");
        }
    }




    public static void main(String[] args) {
        System.out.println(revInt(2956));
        System.out.println(evenPos(2345));
        System.out.println(isPali(23432));
        System.out.println("paliRange");
        paliRange(1050, 9080);
        System.out.println("evenPosRange");
        evenPosRange(1050, 9080);
        System.out.println("both");
        evenPosAndPaliRange(1050, 9080);
    }
}
