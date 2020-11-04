import DS.Queue;

public class Test11d4d2020 {

    public static Queue<Integer> subQ(Queue<Integer> q, int len) {
        Queue<Integer> ret = new Queue<>();
        int count = 0;
        q.insert(null);
        while (q.head() != null) {
            if (count < len)
                ret.insert(q.head());
            count++;
            q.insert(q.remove());
        }
        q.remove();
        return ret;
    }

    public static void revQ(Queue<Integer> q) {
        if(q.isEmpty()) return;
        int tmp = q.remove();
        revQ(q);
        q.insert(tmp);
    }

    public static Queue<Integer> copyQ(Queue<Integer> q) {
        Queue<Integer ret = new Queue<>();
        q.insert(null);
        while(q.head() != null) {
            ret.insert(q.head());
            q.insert(q.remove());
        }
        q.remove();
        return ret;
    }

    public static boolean equalsQ(Queue<Integer> q1, Queue<Integer> q2) {
        q1.insert(null);
        q2.insert(null);
        boolean ret = true;
        while(q2.head() != null && q1.head() != null) {
            if(!q1.head().equals(q2.head())) ret = false;
            int tmp1 = q1.remove();
            int tmp2 = q2.remove();
            if(q2.head() == null || q1.head() == null && !q1.head().equals(q2.head())) ret = false;
            q1.insert(tmp1);
            q2.insert(tmp2);
        }
        return ret;
    }

    public static boolean isShortPali(Queue<Integer> q, int len) {
        Queue<Integer> sub = subQ(q, len);
        Queue<Integer> rev = copyQ(sub);
        revQ(rev);
        return equalsQ(sub, rev);
    }


}
