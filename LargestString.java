public class LargestString {
    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "mango"};
        String largest = strings[0];
        for (int i = 1; i < strings.length; i++) {  
            if (strings[i].compareTo(largest) > 0) {
                largest = strings[i];
            }
        }
        System.out.println("The largest string is: " + largest); // Output: The largest string is: mango
    }
}
