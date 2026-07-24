import java.util.Arrays;

public class TwiceAppearance {
    public static boolean twiceAppearance(int[] arr) {
        if (arr == null || arr.length <= 1) return false;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        boolean result = twiceAppearance(arr);
        System.out.println(result);
    }
}