public class Class18_2 {

    public static int BSLim(int[] arr, int val, int lo, int hi) {
        int mid; // middle of range
        while(lo < hi) { // until array over
            mid = (hi + lo) / 2; // find new middle
            if(val > arr[mid]) lo = mid + 1; // if value is ahead lo is middle - 1
            else if(val < arr[mid]) hi = mid - 1; // if value is before hi is middle + 1
            else return mid; // if not ahead or before, we found it! return middle AKA index
        }
        return -1; // value not in range, return -1
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 6, 8, 90, 120, 200, 201};
        System.out.println(BSLim(arr, 8, 1, 7));
    }

}
