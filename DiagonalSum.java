public class DiagonalSum {
    public static void main(String[] args){
        int[][] matrix ={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        printSum(matrix);
    }
    public static void printSum(int[][] matrix){
        int sum_primary= 0;
        int sum_secondary= 0;
        int n = matrix.length;
        for(int i=0;i<n;i++){
            //primary diagonal
            sum_primary += matrix[i][i];
            //secondary diagonal
            if(i != n - 1 - i){
                sum_secondary += matrix[i][n - 1 - i];
            }
        }
        System.out.println("Primary Diagonal Sum: " + sum_primary);
        System.out.println("Secondary Diagonal Sum: " + sum_secondary);
        System.out.println("Total Diagonal Sum: " + (sum_primary + sum_secondary));
    }
}
