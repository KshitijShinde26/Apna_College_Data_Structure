public class Uppercase {
    public static void main(String[] args) {
        String str = "kshitij";
        String upperStr = upcase(str);
        System.out.println(upperStr);         
    }
    public static String upcase(String str){
       StringBuilder sb = new StringBuilder("");
       char ch= Character.toUpperCase(str.charAt(0));
       sb.append(ch);
       for(int i=1;i<str.length();i++){
           char c = str.charAt(i);
           if(str.charAt(i)==' ' && i<str.length()-1){
               sb.append(c);
               i++;
               sb.append(Character.toUpperCase(str.charAt(i)));
           }
           else{
               sb.append(c);
           }
       }
       return sb.toString();
    }
}
