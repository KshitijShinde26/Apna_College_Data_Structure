import java.util.*;
public class StackR {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for(int i=1;i<4;i++){
            s1.push(i);
        }
        int r;
        for (int j = 0;j<3;j++) {
            r = s1.pop();
            s2.push(r);
        }
        System.out.println(s2);
    }
}
