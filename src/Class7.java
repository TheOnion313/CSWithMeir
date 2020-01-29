package Classes;

public class Class7 {

    public static int addTwo(int num1, int num2) {  //function that returns the sum of two numbers
        return num1 + num2;
    }

    public static boolean mod17(int num) {  //checks whether or not a number can be divided by 17 without carry
        return num % 17 == 0;
    }

    public static void kModL(int k, int l) {
        /*
        the function checks if two numbers divide without leftover

        complexity: O(1)
         */
        System.out.println(k + " % " + l + " == 0 " + (k % l == 0));
    }

    public static boolean isEven(int num) {
        /*
        a function that tells you whether a number is even or not
        param: num is the number that you check whether a number is even or not
        return: true or false, if num is even, return true, if its odd, return false
        complexity: O(1)
         */
        return num % 2 == 0;
    }

    public static int numDig(int num) {
        /*
        a function that tells you how many digits a number has
        param: num is the number that's digits are counted
        return: the number of digits num has

        l is n's number of digits
        complexity: O(1 + l)
         */
        int digits = 0;
        if (num == 0) {
            return 1;
        } else while (num > 0) {
            digits++;
            num /= 10;
        }
        return digits;
    }

    public static int digitSum(int num) {
        /*
        a function that calculates the sum of digits of a number
        param: num is the number which's digits are summed
        return: the sum of digits of num

        l is n's number of digits
        complexity: O(l)
         */
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int swingDigSum(int num) {
        /*
        like digitSum except it adds the digit once and then subtracts once, starting at adding at the units digit

        complexity: O(l*2)
         */
        int sum = 0;
        boolean plusminus = true;
        while (num > 0) {
            if (plusminus) {
                sum += num % 10;
                plusminus = false;
            } else {
                sum -= num % 10;
                plusminus = true;
            }
            num /= 10;
        }
        return sum;
    }

    public static boolean isPerfect(int num) {
        /*
        checks whether a number is "perfect" or not
        perfect: the sum of its dividers equal to itself
        param: num is the number that you check if its perfect or not
        return: true or false, true being that the number is perfect, false being that it is not

        complexity: O(n/2)
         */
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static boolean isPrime(int num) {
        /*
        checks if a number is prime
        n is the number
        since the software checks every number from 2 to n / 2 complexity is the difference + 1 which is n / 2 - 2 + 1 =
        complexity: O(n / 2 - 1)
         */
        boolean isPrime = true;
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    public static int cntPrimes(int lo, int hi) {
        /*
        checks the number of prime numbers in a range lo-hi
                hi is the higher number and lo is the lower

        complexity: O((hi + lo) * (hi - lo) / 2 )
         */
        int sum = 0;
        for (int i = lo; i <= hi; i++) {
            if (isPrime(i)) {
                sum++;
            }
        }
        return sum;
    }

    public static void dispPrimes(int lo, int hi) {
        /*
        input first the low number and then the higher one
        presents all prime numbers within a range lo - hi
        hi is the higher number and lo is the lower

        complexity: O((hi - lo + 1) ^ 2 / 2)
         */
        System.out.print("{");
        for (int i = lo; i <= hi; i++) {
            if (isPrime(i)) {
                System.out.print(i + ", ");
            }
        }
        System.out.println("}");
    }

    public static void twoHighPrimes(int lo, int hi) {
        /*
        input first lower number and then higher number
        presents two highest prime numbers within range lo - hi
        hi is the higher number and lo is the lower
        complexity: O((hi - lo + 1) ^ 2 / 2)
         */
        int first = 0;
        int second = 0;
        for (int i = hi; i >= lo; i--) {
            if (isPrime(i)) {
                if (first != 0) {
                    second = i;
                    i = lo - 1;
                } else {
                    first = i;
                }
            }
        }
        System.out.println("{" + second + ", " + first + "}");
    }

    public static void digitSumBelowNum(int num) {
        /*
        prints the numbers which's sum of digits is equal to the number and are below it
        num is the bar number that is compared to

        complexity: complexity of digitSum plus complexity of digitSum times num
        there for where n is num and m is num's digits complexity is O(m + n * m)
         */
        int numSum = digitSum(num);
        for (int i = 0; i < num; i++) {
            if (digitSum(i) == numSum) {
                System.out.println(i);
            }
        }

    }

    public static int digitInNum(int num, int d) {
        /*
        checks how many times does a certain digit appear in a certain number
        num is the number and d is the digit

        complexity: goes over the digits of num once therefore
        complexity is O(n) where n is the number of digits that num has
         */
        int sum = 0;
        if(d == 0 && num == 0) {
            return 1;
        }
        while(num > 0) {
            if(num % 10 == d) {
                sum++;
            }
            num /= 10;
        }
        return sum;
    }

    public static void locationInNum(int num, int d) {
        /*
        the function finds where a certain digit appears in a certain number
        num is the number and d is the digit

        complexity: goes over the digits of num once to get numDig
        and once again going over the digits
        therefore complexity is O(2n) where n is the number of digits that num has
         */
        System.out.print("[");
        for(int i = 1; i <= numDig(num); i++) {
            if(num % 10 == d) {
                System.out.print(i + ", ");
            }
            num /= 10;
        }
        System.out.println("]");

    }

    public static void main(String[] args) {    //main function
        System.out.println(addTwo(5, 6));
        System.out.println(mod17(34));
        kModL(15, 6);
        System.out.println(isEven(4));
        System.out.println(numDig(13265));
        System.out.println(digitSum(1365));
        System.out.println(swingDigSum(13289));
        System.out.println(isPerfect(6));
        System.out.println(isPrime(22));
        System.out.println(cntPrimes(54, 109));
        dispPrimes(34, 200);
        twoHighPrimes(100, 9000);
        digitInNum(10853929, 9);
        locationInNum(10853929, 9);
    }

}

