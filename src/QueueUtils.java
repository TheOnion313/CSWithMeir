import DS.Queue;

public class QueueUtils {

    public static <T> Queue<T> newFrom(T... vals) {
        Queue<T> ret = new Queue<T>();

        for (T val : vals) {
            ret.insert(val);
        }

        return ret;
    }

    public static <T> String stringify(Queue<T> q) {
        String ret = q.q() + "";
        q.insert(q.remove());

        q.insert(null);
        while (q.q() != null) {
            ret += "--> " + q.q();
            q.insert(q.remove());
        }
        q.remove();

        return ret;
    }

    public static <T> Queue<T> copy(Queue<T> q) {
        Queue<T> copy = new Queue<>();

        q.insert(null);

        while (q.q() != null) {
            copy.insert(q.q());
            q.insert(q.remove());
        }
        q.remove();

        return copy;
    }

    public static <T> T getLast(Queue<T> q) {
        T last = null;
        q.insert(null);
        while (q.head() != null) {
            last = q.head();
            q.insert(q.remove());
        }
        q.remove();

        return last;
    }

    public static <T> T getQueue(Queue<T> q, int index) {
        q.insert(null);
        T ret = null;
        int cnt = 0;
        while (q.head() != null) {
            if (cnt == index) {
                ret = q.head();
            }
            cnt++;
            q.insert(q.remove());
        }
        q.remove();
        return ret;
    }

    public static <T> int size(Queue<T> q) {
        int size = 0;
        q.insert(null);
        while (q.head() != null) {
            size++;
            q.insert(q.remove());
        }
        q.remove();
        return size;
    }

    public static <T> boolean equals(Queue<T> a, Queue<T> b) {
        a.insert(null);
        b.insert(null);
        boolean ret = true;

        while (!(a.head() == null && b.head() == null)) {
            if (a.head() == null || b.head() == null || a.head() != b.head()) {
                ret = false;
            }
            if (a.head() != null) a.insert(a.remove());
            if (b.head() != null) b.insert(b.remove());
        }
        a.remove();
        b.remove();

        return ret;
    }

    public static <T> boolean contains(Queue<T> q, T val) {
        q.insert(null);
        boolean ret = false;

        while (q.head() != null) {
            if (q.head() == val) {
                ret = true;
            }
            q.insert(q.remove());
        }
        q.remove();

        return ret;
    }

    public static <T> void insertAfter(Queue<T> q, T aft, T val) {
        q.insert(null);
        boolean inserted = false;
        while (q.head() != null) {
            if (q.head() == aft && !inserted) {
                q.insert(q.remove());
                q.insert(val);
                inserted = true;
            } else {
                q.insert(q.remove());
            }
        }
        q.remove();
    }

    public static int findMinV(Queue<Integer> q) {
        q.insert(null);
        int min = q.head();
        while (q.head() != null) {
            q.insert(q.remove());

            if (q.head() < min) {
                min = q.head();
            }
        }
        q.remove();

        return min;
    }

    public static <T> void insertBefore(Queue<T> q, T be, T val) {
        q.insert(null);
        boolean inserted = false;

        while (q.head() != null) {
            if (q.head() == be && !inserted) {
                q.insert(val);
                inserted = true;
            }
            q.insert(q.remove());
        }
        q.remove();
    }

    public static <T> void remove(Queue<T> q, T val) {
        q.insert(null);
        boolean removed = false;

        while (q.head() != null) {
            if (q.head() == val && !removed) {
                q.remove();
                removed = true;
            } else {
                q.insert(q.remove());
            }
        }
        q.remove();
    }

    public static Queue<Integer> sort(Queue<Integer> q) {
        Queue<Integer> ret = new Queue<>();
        Queue<Integer> copy = copy(q);
        while (!copy.isEmpty()) {
            int min = findMinV(copy);
            remove(copy, min);
            ret.insert(min);
        }
        return ret;
    }

    public static <T> Queue<T> mergeNotSorted(Queue<T> a, Queue<T> b) {
        Queue<T> ret = new Queue<>();
        a.insert(null);
        b.insert(null);

        while (a.head() != null || b.head() != null) {
            if (a.head() == null) {
                ret.insert(b.head());
                b.insert(b.remove());
            } else if (b.head() == null) {
                ret.insert(a.head());
                a.insert(a.remove());
            } else {
                ret.insert(a.head());
                ret.insert(b.head());

                a.insert(a.remove());
                b.insert(b.remove());
            }
        }
        a.remove();
        b.remove();

        return ret;
    }

    public static Queue<Integer> mergeSorted(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> ret = new Queue<>();
        q1.insert(null);
        q2.insert(null);

        while (q1.head() != null || q2.head() != null) {
            if (q1.head() == null || q2.head() < q1.head()) {
                ret.insert(q2.head());
                q2.insert(q2.remove());
            } else {
                ret.insert(q1.head());
                q1.insert(q1.remove());
            }
        }
        q1.remove();
        q2.remove();

        return ret;
    }

    public static <T> void removeDups(Queue<T> q) {
        Queue<T> remedies = new Queue<>();
        q.insert(null);

        while(q.head() != null) {
            if(!contains(remedies, q.head())) {
                remedies.insert(q.head());
                q.insert(q.remove());
            } else {
                q.remove();
            }
        }
        q.remove();
    }

    public static Queue<Integer> randList(int length, int lo, int hi) {
        Queue<Integer> ret = new Queue<>();

        for(int i = 0; i < length; i++) {
            ret.insert((int)(Math.random() * (hi - lo + 1)) + lo);
        }
        
        return ret;
    }
}