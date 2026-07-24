public class ArrayBack {
    public static void main(String[] args){
        ArrayBack a= new ArrayBack();
        int[] arr = new int[5];
        a.changeArr(arr,0,1);
        a.printArr(arr);
    }
    public void changeArr(int[] arr,int i ,int val){
        //base case
        if(i==arr.length){
            printArr(arr);
            return;
        }
        //recursion case 
        arr[i]=val;//value assignment
        changeArr(arr, i+1, val+1);//method call
        arr[i]=arr[i]-2;//backtracking step
    }
    public void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
}
