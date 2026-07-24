public class Subset {
    public void generateset(String str,String ans,int i){
        //base case
        if (i == str.length()) {
            if(ans.length()==0){
                System.out.println("null");
            }
            System.out.println(ans);
            return;
        }
        //recursion case
        //choice is yes
        generateset(str,ans+str.charAt(i),i+1);
        //choice is no
        generateset(str, ans, i+1);
    }
    public static void main(String[] args){
        String str = "abc";
        Subset s = new Subset();
        s.generateset(str,"",0);
    }
}
