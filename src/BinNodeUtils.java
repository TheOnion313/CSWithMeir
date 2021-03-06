import DS.BinNode;

public class BinNodeUtils {

    public static <T> boolean isLeaf(BinNode<T> node) {
        return !(node.hasLeft() || node.hasRight());
    }

    public static <T> int countLeaves(BinNode<T> node) {
        if (isLeaf(node)) return 1;
        return (node.hasRight() ? countLeaves(node.getRight()) : 0) + (node.hasLeft() ? countLeaves(node.getLeft()) : 0);
    }

    public static <T> void insertTreeRandom(BinNode<T> tree, BinNode<T> newNode) {
        if (Math.random() < 0.5) {
            if (!tree.hasLeft()) {
                tree.setLeft(newNode);
            } else {
                insertTreeRandom(tree.getLeft(), newNode);
            }
        } else {
            if (!tree.hasRight()) {
                tree.setRight(newNode);
            } else {
                insertTreeRandom(tree.getRight(), newNode);
            }
        }
    }

    public static int randInt(int hi, int lo) {
        return (int) (Math.random() * (hi - lo + 1)) + lo;
    }

    public static BinNode<Integer> genTree(int size, int hi, int lo) {
        BinNode<Integer> head = new BinNode<>(randInt(hi, lo));

        for (int i = 1; i < size; i++) {
            insertTreeRandom(head, new BinNode<Integer>(randInt(hi, lo)));
        }

        return head;
    }

    public static <T> boolean isValExist(BinNode<T> tree, T val) {
        if (isLeaf(tree)) return tree.getValue() == val;
        if (!tree.hasLeft()) {
            return isValExist(tree.getRight(), val);
        }
        if (!tree.hasRight()) {
            return isValExist(tree.getLeft(), val);
        }
        return isValExist(tree.getRight(), val) || isValExist(tree.getLeft().getLeft(), val);
    }

    private static String tree2StrSub(BinNode<Integer> tree) {
        return tree.getValue() + ", " + (tree.hasLeft() ? tree2Str(tree.getLeft()) : "") + (tree.hasRight() ? tree2Str(tree.getRight()) : "");
    }

    public static String tree2Str(BinNode<Integer> tree) {
        String s = tree2StrSub(tree);
        return s.substring(0, s.length() - 2);
    }

    public static <T> boolean isNodeExist(BinNode<T> tree, BinNode<T> intersection) {
        if (tree == null) return false;
        if (intersection == tree) return true;
        return isNodeExist(tree.getLeft(), intersection) || isNodeExist(tree.getRight(), intersection);
    }

    public static BinNode<Integer> findNodeByVal(BinNode<Integer> tree, int value) {
        if (tree == null) return null;
        if (tree.getValue() == value) return tree;
        BinNode<Integer> left = findNodeByVal(tree.getLeft(), value);
        if (left != null) return left;

        return findNodeByVal(tree.getRight(), value);
    }

    public static <T> boolean twoOrZeroSon(BinNode<T> tree) {
        if ((tree.getLeft() == null) == (tree.getRight() == null)) {
            if (tree.getLeft() == null) return true;
            return twoOrZeroSon(tree.getRight()) && twoOrZeroSon(tree.getLeft());
        }

        return false;
    }

    public static String valsAtLevel(BinNode<Integer> t, int level) {
        assert level >= 0;
        if (level == 0) return "" + t;
        else return valsAtLevel(t.getLeft(), level - 1) + ", " + valsAtLevel(t.getRight(), level - 1);
    }

    public static boolean contains(BinNode<Integer> t1, BinNode<Integer> t2) {
        if(t2 == null) return true;
        if(findNodeByVal(t1, t2.getValue()) == null) return false;
        return contains(t1, t2.getLeft()) && contains(t1, t2.getRight());
    }

    public static boolean equalsByVal(BinNode<Integer> t1, BinNode<Integer> t2) {
        return contains(t1, t2) && contains(t2, t1);
    }

}
