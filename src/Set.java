import DS.Queue;

import java.lang.reflect.Constructor;

public class Set<T> {
    private Queue<T> q;

    public Set() {
        this.q = new Queue<>();
    }

    public Set(Queue<T> q) throws Exception {
        q.insert(null);
        while (q.head() != null) {
            this.add(copy(q.head()));
        }
        q.remove();
    }

    public static <T> T copy(T item) throws Exception {

        Class<?> clazz = item.getClass();
        Constructor<?> copyContructor = clazz.getConstructor(clazz);

        @SuppressWarnings("unchecked")
        T copy = (T) copyContructor.newInstance(item);

        return copy;
    }

    public Queue<T> getQ() {
        return new Queue<>(this.q);
    }

    public boolean inGroup(T val) {
        this.q.insert(null);
        boolean there = false;
        while (this.q.head() != null) {
            T temp = this.q.remove();
            if (val.equals(temp)) there = true;
            q.insert(temp);
        }
        q.remove();

        return there;
    }

    public void add(T val) throws Exception {
        if (!this.inGroup(val)) this.q.insert(copy(val));
    }


    public void remove(T val) {
        this.q.insert(null);
        while (this.q.head() != null) {
            if (this.q.head().equals(val)) {
                this.q.remove();
            }
            this.q.insert(this.q.remove());
        }
        q.remove();
    }


    public Set<T> union(Set<T> s) throws Exception {
        Set<T> ret = new Set<>(this.q);

        Queue<T> tmp = s.getQ();
        tmp.insert(null);

        while (!tmp.isEmpty()) {
            ret.add(copy(tmp.head()));
        }

        return ret;
    }

    public Set<T> intersection(Set<T> s) throws Exception {
        Set<T> ret = new Set<>();

        Queue<T> tmp = this.getQ();
        while (!tmp.isEmpty()) {
            if (s.inGroup(tmp.head())) {
                ret.add(copy(tmp.head()));
            }
            tmp.remove();
        }

        return ret;
    }
}
