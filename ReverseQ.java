import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class ReverseQ {
    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while(!q.isEmpty()) {
            stack.push(q.remove());
        }
        while(!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println("Original Queue: " + q);
        reverseQueue(q);
        System.out.println("Reversed Queue: " + q);
    }
}
