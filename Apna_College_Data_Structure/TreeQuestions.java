public class TreeQuestions {

    // ---------- Node Class ----------
    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
        }
    }

    // =========================================================
    // 1) Kth Level (root level = 1)
    // =========================================================
    public static void printKthLevel(Node root, int k) {
        if (root == null) return;

        if (k == 1) {
            System.out.print(root.val + " ");
            return;
        }
        printKthLevel(root.left, k - 1);
        printKthLevel(root.right, k - 1);
    }

    // =========================================================
    // 2) Lowest Common Ancestor (LCA)
    // =========================================================
    public static Node lca(Node root, int p, int q) {
        if (root == null) return null;

        if (root.val == p || root.val == q) return root;

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        if (left != null && right != null) return root;

        return (left != null) ? left : right;
    }

    // =========================================================
    // 3) Minimum Distance Between Two Nodes
    // =========================================================
    public static int minDistance(Node root, int a, int b) {
        Node lcaNode = lca(root, a, b);

        int d1 = distanceFromRoot(lcaNode, a);
        int d2 = distanceFromRoot(lcaNode, b);

        return d1 + d2;
    }

    private static int distanceFromRoot(Node root, int target) {
        if (root == null) return -1;
        if (root.val == target) return 0;

        int left = distanceFromRoot(root.left, target);
        if (left != -1) return left + 1;

        int right = distanceFromRoot(root.right, target);
        if (right != -1) return right + 1;

        return -1;
    }

    // =========================================================
    // 4) Kth Ancestor of a Node
    // =========================================================
    static int kthAns = -1;

    public static int kthAncestor(Node root, int target, int k) {
        kthAns = -1;
        findAncestor(root, target, k);
        return kthAns;
    }

    private static int findAncestor(Node root, int target, int k) {
        if (root == null) return -1;

        if (root.val == target) return 0;

        int leftDist = findAncestor(root.left, target, k);
        int rightDist = findAncestor(root.right, target, k);

        int dist = Math.max(leftDist, rightDist);

        if (dist != -1) {
            dist = dist + 1;
            if (dist == k) kthAns = root.val;
            return dist;
        }

        return -1;
    }

    // =========================================================
    // 5) Transform to Sum Tree
    // =========================================================
    public static int transformToSumTree(Node root) {
        if (root == null) return 0;

        int leftSum = transformToSumTree(root.left);
        int rightSum = transformToSumTree(root.right);

        int oldVal = root.val;
        root.val = leftSum + rightSum;

        return oldVal + root.val;
    }

    // Helper: Print Inorder traversal
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4  5  6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // ------------------ 1) Kth Level ------------------
        int k = 3;
        System.out.print("Kth Level (k=" + k + "): ");
        printKthLevel(root, k);
        System.out.println();

        // ------------------ 2) LCA ------------------
        int p = 4, q = 5;
        Node lcaNode = lca(root, p, q);
        System.out.println("LCA of " + p + " and " + q + " = " + (lcaNode != null ? lcaNode.val : -1));

        // ------------------ 3) Minimum Distance ------------------
        int a = 4, b = 7;
        System.out.println("Minimum Distance between " + a + " and " + b + " = " + minDistance(root, a, b));

        // ------------------ 4) Kth Ancestor ------------------
        int target = 5;
        int kth = 2;
        System.out.println(kth + "th Ancestor of " + target + " = " + kthAncestor(root, target, kth));

        // ------------------ 5) Transform to Sum Tree ------------------
        System.out.print("Inorder BEFORE Sum Tree: ");
        inorder(root);
        System.out.println();

        transformToSumTree(root);

        System.out.print("Inorder AFTER Sum Tree:  ");
        inorder(root);
        System.out.println();
    }
}
