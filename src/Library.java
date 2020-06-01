public class Library {
    private Book[] arr;

    public Library(Book[] arr) {
        this.arr = copyArr(arr);
    }

    public Book[] copyArr(Book[] arr) {
        Book[] n = new Book[arr.length];
        for (int i = 0; i < arr.length; i++) {
            n[i] = new Book(arr[i].getName(), arr[i].getShelf(), arr[i].isInteresting());
        }
        return n;
    }

    public Book[] getArr() {
        return copyArr(arr);
    }

    public void setArr(Book[] arr) {
        this.arr = copyArr(arr);
    }

    public boolean isInteresting(int shelf) {
        int interesting = 0, notInteresting = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getShelf() == shelf) {
                if (arr[i].isInteresting()) {
                    interesting++;
                } else {
                    notInteresting++;
                }
            }
        }
        return interesting >= notInteresting;
    }

    public int maxShelf() {
        int[] shelfCaps = new int[100];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getShelf() != 0) {
                shelfCaps[arr[i].getShelf() - 1]++;
            }
        }
        int maxShelf = -1, maxIdx = 0;
        for (int i = 0; i < shelfCaps.length; i++) {
            if (shelfCaps[i] > maxShelf) {
                maxIdx = i + 1;
                maxShelf = shelfCaps[i];
            }
        }
        return maxIdx;
    }
}
