public class GridWays {
    public static int countWays(int i,int j,int n,int m){
        if(i==n-1 && j==m-1){// last cell condition 
            return 1;
        }
        else if (i>=n || j>=m){//boundary condition
            return 0;
        }
        int w1 = countWays(i+1,j,n,m);
        int w2 = countWays(i,j+1,n,m);
        return w1+w2;
    }
   public static void main(String[] args) {
        int n=4;
        int m=4;
        System.out.println(countWays(0,0,n,m));
   } 
}
//Time Complexity: O(2^(n+m))
//Space Complexity: O(n+m) (due to recursion stack)
