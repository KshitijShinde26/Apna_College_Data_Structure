public class QueueDeque {
    static class Queue{
        java.util.Deque<Integer> d = new java.util.LinkedList<>();
        public void enqueue(int x){
            d.addLast(x);
        }
        public int dequeue(){
            return d.removeFirst();
        }
        public int front(){
            return d.getFirst();
        }
        public boolean isEmpty(){
            return d.isEmpty();
        }
        public void printQueue(){
            for(int i : d){
                System.out.print(i + " ");
            }
            System.out.println();
        } 
    } 
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printQueue();
        System.out.println(q.front());
        System.out.println(q.dequeue());
        q.printQueue();
        System.out.println(q.isEmpty());
    }
}
