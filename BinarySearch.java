public class BinarySearch {

    public static boolean searchElement(int[] arr, int target){

        int left = 0;
        int right = arr.length;
        while(left< right){
            int mid = left +(right-left)/2;
            if(arr[mid]==target)
                return true;
            if(arr[mid]<target)
                left = mid+1;
            else
                right = mid;
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(searchElement(new int[]{1,2,3,4,5},11));
    }
}
