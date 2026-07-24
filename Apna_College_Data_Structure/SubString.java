public class SubString {
    public static void main(String[] args){
        String str = "Hello World!";
        String sub = Sub(str,0,5);
        System.out.println(sub); //Output: Hello
    }
    public static String Sub(String str,int bi,int ei){
        String result = "";
        for(int i = bi;i<ei;i++){
            result += str.charAt(i);
        }
        return result;
    }
}
