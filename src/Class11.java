package Classes;

public class Class11 {

    public static boolean isZigZagU(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(i % 2 == 0) {
                if(arr[i] >= arr[i - 1]) {
                    return false;
                }
            } else if(arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZigZagD(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(i % 2 != 0) {
                if(arr[i] >= arr[i - 1]) {
                    return false;
                }
            } else if(arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnyZigZag(int[] arr) {
        return isZigZagU(arr) || isZigZagD(arr);
    }


    public static boolean isArrayPalindrom(int[] arr) {
        //complexity: O(n) max O(1) min
        for(int i = 0; i < arr.length / 2; i++) {
            if(arr[i] != arr[arr.length - 1 - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 1, 2, 1, 3, 1};
        System.out.println(isAnyZigZag(a));
    }

}