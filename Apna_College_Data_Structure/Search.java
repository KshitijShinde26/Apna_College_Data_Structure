public class Search {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};
        int target = 7;
        for (int num  =0;num < arr.length; num++) {
            if (arr[num] == target) {
                System.out.println("Found target: " + num);
                break;
            }
            else{
                System.out.println(-1);
                break;
            }
        }
    }
}
