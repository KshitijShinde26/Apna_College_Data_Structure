public class parentheses {
    public static void main(String[] args) {
        String str = "((()))";
        System.out.println(isBalanced(str)); // Output: true

    }
    public static boolean isBalanced(String str) {
        int balance = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
                if (balance < 0) {
                    return false; // More closing parentheses than opening
                }
            }
        }
        return balance == 0; // True if balanced, false otherwise
    }
}
