import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    //1,2,3,4 nums
    //1,1,2,6 left  arr
    //24,12,8,6 right
    public static int[] productOfArray(int[] nums){
        int[] arr = new int[nums.length];
        int left =1,right=1;
        for(int i=0;i< nums.length;i++){
            arr[i] = left;
            left *= nums[i];
        }
        for(int i= nums.length-1;i>=0;i--){
            arr[i] = right * arr[i];
            right *= nums[i];
        }
        return arr;
    }

    public static void main(String args[]){
        int[] arr = new int[]{1,2,3,4};
        arr = productOfArray(arr);
//        for(int i:arr){
//            System.out.println(i);
//        }
        System.out.println(Arrays.toString(arr));
    }
}
