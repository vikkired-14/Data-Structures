public class SearchInSortedArray {

    public static int getTargetIndex(int[] arr,int tar){
        int left =0;
        int right = arr.length-1;
        while(left<=right) {
            int mid = left + (right - left) / 2;
            if(arr[mid]==tar)
                return mid;
            else if(arr[left]<=arr[mid]){
            if (arr[left] <= tar && arr[mid] > tar) {
                right = mid - 1;
            }else
                left = mid +1;
        }else{
                if(arr[mid]<tar && arr[right]>=tar)
                    left = mid +1;
                else
                    right = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        int[] arr = new int[]{4,5,6,7,0,1,2};
        System.out.println(getTargetIndex(arr,0));
//       assert getTargetIndex(arr,0) == 4 ;
        System.out.println(getTargetIndex(arr,3));
//        assert getTargetIndex(arr,3) == -12 ;
    }
}
