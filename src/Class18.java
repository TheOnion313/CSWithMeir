public class Class18 {

    public static int linearSortedLim(int[] arr, int val, int lo, int hi) {
        // function finds value in bounds of an array, return index of value in array
        // if value not found returns -1
        for(int i = lo; i <= hi; i++) { // loops through array from index lo to hi including
            if(arr[i] == val) return i; // if value at index is val return index
            else if(arr[i] > val) return -1; // if not then if value is greater means value doesn't exist in array since it is sorted, return -1
        }
        return -1; // if done searching in bounds and not found \ over means either not in array or after bounds, return -1
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 6, 8, 90, 120, 200, 201};
        System.out.println(linearSortedLim(arr, 90, 0, 6)); // should return 5
    }

}
