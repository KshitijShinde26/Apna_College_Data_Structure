import java.util.LinkedList;
import java.util.Deque;
public class StackDeque {
    static class Stack{
        Deque<Integer> d = new LinkedList<>();
        public void push(int x){
            d.addLast(x);
        }
        public int pop(){
            return d.removeLast();
        }
        public int top(){
            return d.getLast();
        }
        public boolean isEmpty(){
            return d.isEmpty();
        }
        public void printStack(){
            for(int i : d){
                System.out.print(i + " ");
            }
            System.out.println();
        } 
    } 
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.printStack();
        System.out.println(s.top());
        System.out.println(s.pop());
        s.printStack();
        System.out.println(s.isEmpty());
    }
}
