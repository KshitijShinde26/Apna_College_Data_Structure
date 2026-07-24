public class DiameterOfTree {
    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static int diameter = 0;

    public static int diameterOfBinaryTree(Node root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private static int height(Node root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        diameter = Math.max(diameter, lh + rh);

        return 1 + Math.max(lh, rh);
    }

    // Example
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(diameterOfBinaryTree(root)); // Output: 3
    }
}
