public class StringB {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        String b=sb.toString();//It can be used for only in the way the above variable is created.
        System.out.println(b);
        int a  = 10;
        String s = String.valueOf(a);//It can be used for any datatype.
        System.out.println(s);
    }
}
