public class StackQ {
    static class Stack {
        private int maxSize;
        private int[] stackArray;
        private int top;

        public Stack(int size) {
            this.maxSize = size;
            this.stackArray = new int[maxSize];
            this.top = -1;
        }

        public void push(int value) {
            if (top == maxSize - 1) {
                System.out.println("Stack is full");
                return;
            }
            stackArray[++top] = value;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return stackArray[top--];
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return stackArray[top];
        }

        public boolean isEmpty() {
            return (top == -1);
        }

        public void print() {
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
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
