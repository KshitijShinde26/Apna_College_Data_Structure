import java.util.Queue;

public class StackQ {
    static class Stack {
        static Queue<Integer> q1 = new java.util.LinkedList<>();
        static Queue<Integer> q2 = new java.util.LinkedList<>();
        static int size;
        Stack(int n) {
            size = n;
        }
        public  boolean isEmpty() {
            return q1.isEmpty();
        }
        public void push(int data) {
            if (q1.size() == size) {
                System.out.println("Stack is full");
                return;
            }
            q1.add(data);
        }
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            int popped = q1.remove();
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return popped;
        }
        public  int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            int top = q1.remove();
            q2.add(top);
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return top;
        }
        public  void print() {
            for (int item : q1) {
                System.out.print(item + " ");
            }
            System.out.println();
        }   
    }
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print(); // 10 20 30
        System.out.println(stack.pop()); // 30
        System.out.println(stack.peek()); // 20
        stack.print(); // 10 20
    }
}
