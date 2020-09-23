//22.9.20
public class Class_25 {
    public static int BridgeXY(int x, int y) {
        return BridgeXY(x, y, 0);
    }

    public static int BridgeXY(int x, int y, int count) {
        if (x == y) {
            return count;
        }
        count++;
        if (2 * x < y && x > 0) {
            return BridgeXY(2 * x, y, count);
        }
        return BridgeXY(x + 1, y, count);
    }

    public static int BridgeXY2(int x, int y) {
        if(y % 2 == 0) {
            if(x > y / 2) return y - x;
            else return BridgeXY2(x, y/2) + 1;
        } else {
            if(x > (y - 1) / 2) return y - x;
            else return BridgeXY2(x, (y - 1) / 2) + 2;
        }
    }

    public static int[] removeCell(int[] arr, int idx) {
        int[] ret = new int[arr.length - 1];
        for(int i = 0; i < ret.length; i++) {
            if(i != idx) {
                ret[i] = arr[i];
            } else {
                ret[i] = arr[i + 1];
                i++;
            }
        }
        return ret;
    }

    public static boolean arrSubSum(int[] arr, int sum) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == sum) {
                return true;
            } else if (arrSubSum(removeCell(arr, i), sum - arr[i])) {
                return true;
            }
        }
        return false;
    }

    public static int avg(int a, int b) {
        return (a + b) / 2;
    }

    public static boolean isFoundBS(int n, int[] sortedNums, int idxLow, int idxHi) {
        int a = avg(idxLow, idxHi);
        if(n == sortedNums[idxLow] || n == sortedNums[idxHi]) return true;
        if(n == sortedNums[a]) return true;
        if(a == idxLow || a == idxHi) return false;
        if(sortedNums[a] > n) {
            return isFoundBS(n, sortedNums, idxLow, a);
        }
        return isFoundBS(n, sortedNums, a, idxHi);
    }

    public static int maxDelta(int[] arr, int idx) {
        if(idx == 0) return arr[idx];
        else if(maxDelta(arr, idx - 1) > arr[idx]) return maxDelta(arr, idx - 1);
        return arr[idx];
    }

    public static void main(String[] args) {
        System.out.println(BridgeXY2(3, 19, 0));
    }
}

