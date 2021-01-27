import DS.Node;

public class NodeUtils {

    public static <T> Node<T> newFrom(T... vals) {
        Node<T> app = null, ret = null;

        for (T val : vals) {
            if (ret == null) {
                ret = new Node<>(val);
                app = ret;
            } else {
                app.setNext(new Node<>(val));
                app = app.getNext();
            }
        }

        return ret;
    }

    public static <T> String stringify(Node<T> head) {
        if (head.hasNext()) {
            return head.getValue() + " --> " + stringify(head.getNext());
        } else {
            return "" + head.getValue();
        }
    }

    public static <T> Node<T> copy(Node<T> head) {
        if (head.hasNext()) {
            return new Node<>(head.getValue(), copy(head.getNext()));
        }
        return new Node<>(head.getValue());
    }

    public static <T> Node<T> getLast(Node<T> head) {
        if (head.hasNext()) {
            return getLast(head.getNext());
        }
        return head;
    }

    public static <T> Node<T> getNode(Node<T> head, int index) {
        if (index == 0) {
            return head;
        }
        return getNode(head.getNext(), index - 1);
    }

    public static <T> int size(Node<T> head) {
        if (head == null) {
            return 0;
        }
        return size(head.getNext()) + 1;
    }

    public static <T> boolean equals(Node<T> a, Node<T> b) {
        if (a == null && b == null) return true;
        if (a == null ^ b == null) return false;
        return a.getValue() == b.getValue() && equals(b.getNext(), a.getNext());
    }

    public static <T> boolean contains(Node<T> list, T val) {
        if (list == null) return false;
        if (list.getValue() == val) return true;
        return contains(list.getNext(), val);
    }

    public static <T> boolean isLoop(Node<T> lst) {
        Node<T> copy = copy(lst);
        Node<T> postcard = new Node<>(null);

        Node<T> cur = copy;
        while (cur != null) {
            if (cur.getNext() == postcard) return true;
            cur = cur.getNext();
        }
        return false;
    }

    public static <T> void insertAfter(Node<T> aft, Node<T> lst) {
        Node<T> tmp = lst.getNext();
        lst.setNext(aft);
        while (lst.hasNext()) {
            lst = lst.getNext();
        }

        lst.setNext(tmp);
    }

    public static Node<Integer> findMinP(Node<Integer> lst) {
        Node<Integer> min = lst;
        while (lst != null) {
            lst = lst.getNext();
            if (lst.getValue() < min.getValue()) min = lst;
        }
        return min;
    }

    public static int findMinV(Node<Integer> lst) {
        return findMinP(lst).getValue();
    }

    public static <T> Node<T> insertBefore(Node<T> fst, Node<T> be, Node<T> pt) {
        Node<T> cur = fst;

        if (be == fst) {
            insertAfter(fst, getLast(pt));
            return pt;
        }

        while (cur.getNext() != be) {
            cur = cur.getNext();
        }
        insertAfter(pt, cur);

        return fst;
    }

    public static <T> Node<T> remove(Node<T> fst, Node<T> pt) {
        return insertBefore(fst, pt, pt.getNext());
    }

    public static Node<Integer> sort(Node<Integer> fst) {
        if (fst == null) return null;
        if (!fst.hasNext()) return fst;

        Node<Integer> min = findMinP(fst);
        fst = remove(fst, min);
        min.setNext(sort(fst));

        return min;
    }

    public static <T> Node<T> mergeNotSorted(Node<T> a, Node<T> b) {
        getLast(a).setNext(b);
        return a;
    }

    public static Node<Integer> mergeSorted(Node<Integer> a, Node<Integer> b) {
        if (a == null && b == null) return null;
        if (a == null) return b;
        if (b == null) return a;

        Node<Integer> ret;

        if (a.getValue() < b.getValue()) {
            ret = new Node<>(a.getValue());
            remove(a, a);
        } else {
            ret = new Node<>(b.getValue());
            remove(b, b);
        }
        Node<Integer> app = ret;

        while (a != null || b != null) {
            if (b == null) {
                app.setNext(a);
                app = app.getNext();

                remove(a, a);
            } else if (a == null) {
                app.setNext(b);
                app = app.getNext();

                remove(b, b);
            } else {
                if (a.getValue() < b.getValue()) {
                    app.setNext(a);
                    app = app.getNext();

                    remove(a, a);
                } else {
                    app.setNext(b);
                    app = app.getNext();

                    remove(b, b);
                }
            }
        }

        return ret;
    }

    public static <T> void removeDups(Node<T> fst) {
        Node<T> cur = fst.getNext();
        while (cur != null) {
            Node<T> curInner = fst;
            while (curInner.getNext() != cur) {
                if (curInner == cur) {
                    remove(fst, cur);
                }
                curInner = curInner.getNext();
            }
            cur = cur.getNext();
        }
    }

    private static int rand(int from, int to) {
        return (int) (Math.random() * (to - from + 1)) + from;
    }

    public static Node<Integer> randList(int length, int from, int to) {
        Node<Integer> ret = new Node<>(rand(from, to));
        Node<Integer> app = ret;

        for (int i = 1; i < length; i++) {
            app.setNext(new Node<>(rand(from, to)));
            app = app.getNext();
        }

        return ret;
    }
}