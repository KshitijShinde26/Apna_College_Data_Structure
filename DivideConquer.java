public class DivideConquer {
    public static void main(String[] args){
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;//output:4
        int result = search(arr,target,0,arr.length-1);
        System.out.println(result);
    }
    public static int search(int[] arr,int target,int s,int e){
        int mid = s + (e - s)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[s]<=arr[mid]){
            if(target>=arr[s] && target<=arr[mid]){
                return search(arr,target,s,mid-1);
            } else {
                return search(arr,target,mid+1,e);
            }
        } else {
            if(target>=arr[mid] && target<=arr[e]){
                return search(arr,target,mid+1,e);
            } else {
                return search(arr,target,s,mid-1);
            }
        }
    }
}
