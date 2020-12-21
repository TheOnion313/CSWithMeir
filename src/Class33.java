import DS.Node;

public class Class33 {

    public static int findMinV(Node<Integer> head) {
        int min = head.getValue();
        Node<Integer> cur = head;

        while (cur != null) {
            if (cur.getValue() < min) {
                min = cur.getValue();
            }
            cur = cur.getNext();
        }

        return min;
    }

    public static Node<Integer> findMinP(Node<Integer> head) {
        Node<Integer> min = head;
        Node<Integer> cur = head;

        while (cur != null) {
            if (cur.getValue() < min.getValue()){
                min = cur;
            }
            cur = cur.getNext();
        }

        return min;
    }

    public static Node<Integer> insertBefore(Node<Integer> lst, Node<Integer> be, Node<Integer> pt) {
        Node<Integer> copy = lst;
        Node<Integer> cur = lst;

        while (cur.getNext() != be) {
            cur = cur.getNext();
        }

        Class32.insertAfter(be, pt);

        return copy;
    }

    public static Node<Integer> remove(Node<Integer> lst, Node<Integer> pt) {
		if(pt == lst) {
			return lst.getNext();
		}
    	Node<Integer> copy = lst;
		Node<Integer> cur = lst;

		while (cur.getNext() != pt) {
			cur = cur.getNext();
		}

		cur.setNext(cur.getNext().getNext());

		return copy;
    }

    public static Node<Integer> sort(Node<Integer> lst) {
        Node<Integer> ret = new Node(findMinP(lst));
        lst = remove(lst, findMinP(lst));

        Node<Integer> cur = ret;

        while (lst != null) {
            cur.setNext(findMinP(lst));
            lst = remove(lst, findMinP(lst));
            cur = cur.getNext();
        }

        return ret;
    }

    public static Node<Integer> mergeNotSorted(Node<Integer> lst1, Node<Integer> lst2) {
        Node<Integer> cur = lst1;
        while (cur.hasNext()) {
            cur = cur.getNext();
        }
        cur.setNext(lst2);

        return lst1;
    }

    public static Node<Integer> mergeSorted(Node<Integer> lst1, Node<Integer> lst2) {
        Node<Integer> ret;
        if (findMinV(lst1) < findMinV(lst2)) {
            ret = findMinP(lst1);
            lst1 = remove(lst1, findMinP(lst1));
        } else {
            ret = findMinP(lst2);
            lst2 = remove(lst2, findMinP(lst2));
        }

        while (lst2 != null || lst1 != null) {
            if (lst2 == null) {
                ret.setNext(findMinP(lst1));
                lst1 = remove(lst1, findMinP(lst1));
            } else if (lst1 == null) {
                ret.setNext(findMinP(lst2));
                lst2 = remove(lst2, findMinP(lst2));
            } else if (findMinV(lst1) < findMinV(lst2)) {
                ret.setNext(findMinP(lst1));
                lst1 = remove(lst1, findMinP(lst1));
            } else {
                ret.setNext(findMinP(lst2));
                lst2 = remove(lst2, findMinP(lst2));
            }

            ret = ret.getNext();
        }

        return ret;
    }

    public static Node<Integer> removeDups(Node<Integer> lst) {
        Node<Integer> ret = lst;
        Node<Integer> cur = lst;
        Node<Integer> head = ret;

        while (lst.hasNext()) {
            if (Class32.inLst(ret, cur.getNext().getValue())) {
                ret.setNext(cur.getNext());
                ret = ret.getNext();
            }
            cur = cur.getNext();
        }

        return head;
    }


}
