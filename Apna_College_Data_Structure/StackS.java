import java.util.*;
public class StackS{
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String str = "Hello, World!";
        for(char ch : str.toCharArray()){
            stack.push(String.valueOf(ch));
        }
        StringBuilder reversedStr = new StringBuilder();
        while(!stack.isEmpty()){
            reversedStr.append(stack.pop());
        }
        System.out.println(reversedStr.toString());

    }
}