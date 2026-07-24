import java.util.*;
public class DequeQ {
    public static void main(String[] args) {
        final Deque<Integer> d = new ArrayDeque<>();
        d.addFirst(10);
        d.addLast(20);
        d.addLast(30);
        d.addLast(40);
        System.out.println(d);
        d.removeFirst();
        System.out.println(d);
        d.removeLast();
        System.out.println(d);
        System.out.println(d.getFirst());
        System.out.println(d.getLast());
    }
}
