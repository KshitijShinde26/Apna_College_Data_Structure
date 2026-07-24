public class StringCompression {
    public static void main(String[] args) {
        String str = "aaabbccccd";
        String compressedStr = compressString(str);
        System.out.println(compressedStr); // Output: a3b2c4d1
    }
    public static String compressString(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i - 1));
                compressed.append(count);
                count = 1;
            }
        }
        
        compressed.append(str.charAt(str.length() - 1));
        compressed.append(count);
        return compressed.toString();
    }
}
