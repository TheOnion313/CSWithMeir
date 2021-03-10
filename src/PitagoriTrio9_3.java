import DS.BinNode;

public class PitagoriTrio9_3 {

    public static boolean isPitag3(int value1, int value2, int value3) {
        value1 *= value1;
        value2 *= value2;
        value3 *= value3;
        return value1 == value2 + value3 || value2 == value1 + value3 || value3 == value1 + value2;
    }

    public static boolean isPitagoriTrio(BinNode<Integer> tree) {
        if (tree.getRight() == null || tree.getLeft() == null) return false;
        int value1 = tree.getValue(), value2 = tree.getLeft().getValue(), value3 = tree.getRight().getValue();
        return isPitag3(value1, value2, value3);
    }

    public static boolean isPitagTreeR(BinNode<Integer> tree) {
        if (BinNodeUtils.isLeaf(tree)) return true;
        return isPitagoriTrio(tree) && isPitagTreeR(tree.getRight()) && isPitagTreeR(tree.getLeft());
    }

    public static boolean isPitagTree(BinNode<Integer> tree) {
        if (!BinNodeUtils.twoOrZeroSon(tree)) return false;
        return isPitagTreeR(tree);
    }
}
