import java.util.*;
public class ChocolaProblem {
    public static void main(String[] args) {
        Integer cver[] = {2,1,3,1,4};
        Integer chor[] = {4,1,2};
        Arrays.sort(cver,Collections.reverseOrder());
        Arrays.sort(chor,Collections.reverseOrder());
        int h=0,v=0;
        int hp=1,vp=1; // initialize segment counts to 1 instead of 0
        int cost=0;
        while(h<chor.length && v<cver.length){
            if(cver[v]<=chor[h]){
                cost+=(chor[h]*vp);
                hp++;
                h++;
            }
            else{
                cost+=(cver[v]*hp);
                vp++;
                v++;
            }
        }
        while(h<chor.length){
            cost+=(chor[h]*vp);
            hp++;
            h++;
        }
        while(v<cver.length){
            cost+=(cver[v]*hp);
            vp++;
            v++;
        }
        System.out.println(cost);
    }
}
