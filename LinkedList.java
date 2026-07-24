public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }

    public void printList() {
        Node n = head;
        System.out.print("Linked List: ");
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public Node midNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reversNode(Node head){
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public boolean equal(Node curr, Node temp){
        while(curr != null && temp != null){
            if(curr.data != temp.data){
                return false;
            }
            curr = curr.next;
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.append(1);
        llist.append(2);
        llist.append(2);
        llist.append(1);
        
        llist.printList();
        
        Node mid = llist.midNode(llist.head);
        Node secondHalf = llist.reversNode(mid);
        
        boolean isPalindrome = llist.equal(llist.head, secondHalf);
        
        System.out.println("\nIs palindrome? " + isPalindrome);
        if(isPalindrome){
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
