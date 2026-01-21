import java.util.LinkedList;
import java.util.Queue;

public class InterLeaveQ {
    public static void interLeave(Queue<Integer> q) {
        int n = q.size();
        if (n % 2 != 0) return; // Assuming even size for interleaving
        Queue<Integer> first = new LinkedList<>();
        for (int i = 0; i < n / 2; i++) {
            first.add(q.remove());
        }
        // Now q has the second half
        Queue<Integer> result = new LinkedList<>();
        while (!first.isEmpty()) {
            result.add(first.remove());
            result.add(q.remove());
        }
        // Clear original queue and add interleaved elements
        q.clear();
        q.addAll(result);
    }

    public static void printQueue(Queue<Integer> q) {
        for (Integer num : q) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        interLeave(q);
        printQueue(q);
    }
}
