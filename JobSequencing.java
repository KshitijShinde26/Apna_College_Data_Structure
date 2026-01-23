import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    static class Job{
        int id,deadline,profit;
        public Job(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        int jobsinfo[][] = {{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job> k = new ArrayList<>();
        for(int i =0;i<jobsinfo.length;i++){
            k.add(new Job(i,jobsinfo[i][0],jobsinfo[i][1]));
        }
        Collections.sort(k,(a,b)-> a.profit-b.profit);
        ArrayList<Integer> seq = new ArrayList<>();
        int time =0;
        for(int i =0;i<k.size();i++){
            Job curr = k.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }
        System.out.println("Max jobs = "+seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.println(seq.get(i)+" ");
        }
        System.out.println();
    }
}
