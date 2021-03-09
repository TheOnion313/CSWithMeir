import DS.BinNode;

public class Pitagori9_3 {

    public static boolean isPitag3(int a, int b, int c) {
        return a == b || b == c || a == c;
    }

    public static boolean isPitag3(BinNode<Integer> tree) {
        return isPitag3(tree.getValue(), tree.getLeft().getValue(), tree.getRight().getValue());
    }

    public static boolean isPitagTree(BinNode<Integer> tree) {
        if (!BinNodeUtils.twoOrZeroSon(tree)) return false; // can't have pitagoric if not all nodes have 2 sons
        return isPitagTreeR(tree);
    }

    private static boolean isPitagTreeR(BinNode<Integer> tree) {
        if (BinNodeUtils.isLeaf(tree)) return true;
        return isPitag3(tree) && isPitagTreeR(tree.getLeft()) && isPitagTreeR(tree.getRight());
    }
}
