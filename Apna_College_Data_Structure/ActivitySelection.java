public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        System.out.println("Maximum number of activities: " + maxActivities(start, end, n));
    }

    static int maxActivities(int[] start, int[] end, int n) {
        int count = 0;
        int lastEndTime = -1;

        for (int i = 0; i < n; i++) {
            if (start[i] >= lastEndTime) {
                count++;
                lastEndTime = end[i];
            }
        }
        return count;
    }
    
} 