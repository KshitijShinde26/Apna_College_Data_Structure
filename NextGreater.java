import java.util.*;

public class NextGreater {
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] result = nextGreaterElements(arr);
        System.out.println(Arrays.toString(result)); // Fixed: Use Arrays.toString to print array contents
        System.out.println("Using Stack Approach:");
        int[] resultStack = nextGreaterElementsStack(arr);
        System.out.println(Arrays.toString(resultStack));
    }
    ///brute force approach
    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j];
                    break;  // Added: Stop after finding the next greater element
                }
            }
        }
        return res;
    }
    //using stack
    public static int[] nextGreaterElementsStack(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }
}