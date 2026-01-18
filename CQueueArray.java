public class CQueueArray {
    static int size = 5;
    static int q[] = new int[size];
    static int front = -1, rear = -1;
    public static void enqueue(int e){
        if(rear == -1 && front == -1){
            rear =0;
            front =0;
            q[rear] = e;
        }
        else if(front == (rear+1%size)){
            System.out.println("Queue is full");
        }
        else{
            rear=(rear+1)%size;
            q[rear] =e;
        }
    }
    public static void dequeue(){
        if(rear==-1 && front==-1){
            System.out.println("Queue is empty");
        }


        else if (front == rear) 
        {
	        System.out.println("Deleted element from queue is  "+q[front]);
            front = -1;
            rear = -1;
        }  
        else 
        {
            System.out.println("Deleted element from queue is  "+q[front]);
            front = (front + 1) % size;
        }
    }
    public static void display(){
        int i;
        if (rear==-1 && front==-1){
            System.out.println("Queue is empty");
        }
        else 
        {
            System.out.println("Front: "+ front);
            System.out.println("Elements: ");
            for (i = front; i != rear; i = (i + 1) %size) 
            {
                System.out.println(q[i]);
            }
            
            System.out.println(" Rear -> "+ rear);
        }
    }
    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);
        display();
        dequeue();
        display();       
    }    
}