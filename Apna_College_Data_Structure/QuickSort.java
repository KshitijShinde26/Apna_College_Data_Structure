public class QuickSort {
    public static void main(String[] args){
        int arr[] = {6,3,9,8,2,5};
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void quickSort(int arr[], int low,int high){
        if(low >= high){
            return;
        }
        int pidx = partition(arr, low, high);
        quickSort(arr,low,pidx-1);
        quickSort(arr,pidx+1,high);
    }

    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low - 1;

        for(int j=low;j<high;j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}   