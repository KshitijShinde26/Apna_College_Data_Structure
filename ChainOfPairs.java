import java.util.*;
public class ChainOfPairs {
    public static void main(String[] args) {
        int[][] pair = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        Arrays.sort(pair, Comparator.comparingInt(a -> a[1]));
        int chainlength =1;
        int pairend = pair[0][1];//last selected pair end means chain end.
        for(int i=1;i<pair.length;i++){
            if(pair[i][0]>pairend){
                chainlength++;
                pairend=pair[i][1];
            }
        }
        System.out.println(chainlength);
    }
}
