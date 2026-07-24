import java.util.*;
public class BitManipulation {
    public static void main(String[] args) {
        /*Bitwise Opearation */
        /* 
        System.out.println("AND: "+(5&6));
        System.out.println("OR: "+(5|6));
        System.out.println("XOR: "+(5^6));
        System.out.println("NOT: "+(~5));
        System.out.println("Left Shift: "+(5<<2));
        System.out.println("Right Shift: "+(6>>1));
        */
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=in.nextInt();
        /*EvenOdd(n, in);
        getb(n, in);
        setb(n, in);
        clearb(n, in);
        updateb(n, in);
        clearlastb(n,in);
        clearRange(n,in);
        powerOfTwo(n,in);*
        changetoOne(n,in);*/
        fastExpo(n,in);
        in.close();
    }
    public static void EvenOdd(int n, Scanner sc){
        int m = 1;
        if((n & m) == 0){
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
    public static void getb(int n, Scanner sc){
        System.out.println("Enter the position to get number at that place:");
        int i = sc.nextInt();
        int p = 1<<i;
        if((n & p) == 0){
            System.out.println("Number at that place: "+0);
        } else {
            System.out.println("Number at that place: "+1);
        }
    }
    public static void setb(int n, Scanner sc) {
        System.out.println("Enter the position to set number at that place :");
        int j = sc.nextInt();  
        int q = 1<<j;
        int result = n | q;
        System.out.println("Result after setting the bit: ");
        System.out.println(result);
    }
    public static void clearb(int n, Scanner sc){
        System.out.println("Enter the position to clear at that place:");
        int l = sc.nextInt();  
        int o = ~(1<<l);
        int result = n & o;
        System.out.println("Result after clearing the bit: ");
        System.out.println(result);    
    }
    public static void updateb(int n, Scanner sc){
        System.out.println("Enter the position to update at that place:");
        int k = sc.nextInt();
        System.out.println("Enter new bit (0 or 1):");
        int newBit = sc.nextInt();
        if(newBit == 0){
            int u = ~(1<<k);
            int result = n & u;
            System.out.println("Result after Update the bit: ");
            System.out.println(result);
        }
        else{
            int v = 1<<k;
            int result = n | v;
            System.out.println("Result after Update the bit: ");
            System.out.println(result);
        }   
    }
    public static void clearlastb(int n, Scanner sc){
        System.out.println("Enter the position to clear number of last digits at that place:");
        int g = sc.nextInt();
        int h = (~0)<<g;
        int result = n & h;
        System.out.println("Result after clearing the last bits: ");
        System.out.println(result);  
    }
    public static void clearRange(int n, Scanner sc){
        System.out.println("Enter the range to clear number from that place:");
        System.out.println("Enter i:");
        int i = sc.nextInt();
        System.out.println("Enter j:");
        int j = sc.nextInt();
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int mask = a | b;
        int result = n & mask;
        System.out.println("Result after clearing the range of bits: ");
        System.out.println(result);  
    }
    public static void powerOfTwo(int n, Scanner sc){
        if((n & (n-1)) == 0){
            System.out.println(n+" is a power of two.");
        } else {
            System.out.println(n+" is not a power of two.");
        }
    }
    public static void changetoOne(int n, Scanner sc){
        int count = 0;
        while(n > 0){
            if((n & 1) != 0){
                count++;
            }
            n = n >> 1;
        }
        System.out.println("Number of bits to be changed to 1: "+count);
    }
    public static void fastExpo(int n,Scanner sc){
        int ans = 1;
        System.out.println("Enter the power:");
        int m = sc.nextInt();
        while(m > 0){
            if((m & 1) != 0){
                ans = ans * n;
            }
            n = n * n;
            m = m >> 1;
        }
        System.out.println("Answer is: "+ans);
    }
}
