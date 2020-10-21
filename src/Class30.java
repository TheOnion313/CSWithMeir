import DS.*;

public class Class29 {

    public static void moveQ(Queue<Integer> fr, Queue<Integer> to) {
        Queue<Integer> tmp = copyQ(fr);

        while (!tmp.isEmpty()) {
            to.insert(tmp.remove());
        }
    }

    public static Queue<Integer> copyQ(Queue<Integer> fr) {
        Queue<Integer> tmp = new Queue<>();
        while (!fr.isEmpty()) {
            tmp.insert(fr.remove());
        }

        Queue<Integer> copy = new Queue<>();
        while (!tmp.isEmpty()) {
            fr.insert(tmp.head());
            copy.insert(tmp.remove());
        }

        return copy;
    }

    public static int occInQue(Queue<Integer> qu, Integer val) {
        Queue<Integer> copy = copyQ(qu);
        int cnt = 0;
        while (!copy.isEmpty()) {
            if (copy.remove().equals(val)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean inQ(Queue<Integer> qu, Integer val) {
        return occInQue(qu, val) > 0;
    }

    public static Integer findSmallest(Queue<Integer> qu) {
        Queue<Integer> copy = copyQ(qu);
        int min = copy.remove();
        while (!copy.isEmpty()) {
            if (copy.head() < min) {
                min = copy.remove();
            }
        }
        return min;
    }

    public static void remVal(Queue<Integer> qu, Integer val) {
        Queue<Integer> tmp = new Queue<>();
        boolean removed = false;
        while (!qu.isEmpty()) {
            if (!qu.head().equals(val) || removed) {
                tmp.insert(qu.remove());
            } else {
                qu.remove();
                removed = true;
            }
        }
    }


    public static Queue<Integer> sortQ(Queue<Integer> qu) {
        Queue<Integer> copy = copyQ(qu);
        Queue<Integer> ret = new Queue<>();

        while (!copy.isEmpty()) {
            Integer min = findSmallest(copy);
            ret.insert(min);
            remVal(copy, min);
        }

        return ret;
    }

    public static void mergeSortedQ(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> cp1 = copyQ(q1);
        Queue<Integer> cp2 = copyQ(q2);
        Queue<Integer> merge = new Queue<>();
        while (!cp1.isEmpty() && !cp2.isEmpty()) {
            if(cp1.head() < cp2.head()) {
                merge.insert(cp1.remove());
            } else {
                merge.insert(cp2.remove());
            }
        }

        moveQ(cp1, merge);
        moveQ(cp2, merge);

        q1 = copyQ(merge);
    }

}
