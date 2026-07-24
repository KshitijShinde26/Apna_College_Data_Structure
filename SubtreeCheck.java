public class SubtreeCheck {
    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.val != b.val) return false;

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public static void main(String[] args) {
        // Example usage
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(2);

        Node subRoot = new Node(4);
        subRoot.left = new Node(1);
        subRoot.right = new Node(2);

        boolean result = isSubtree(root, subRoot);
        System.out.println("Is subtree: " + result);
    }
}
