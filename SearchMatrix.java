public class SearchMatrix {
    public static void main(String[] args){
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60},
            {70, 80, 90, 100}
        };
        int target = 15;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == target){
                    System.out.println("Target " + target + " found at position: (" + i + ", " + j + ")");
                }
                else{
                    System.out.println("Not Found ");
                }
            }
            System.out.println();
        }
    }
}
