public class FindMinInRoatedArray {

    public static int findMinElement(int[] nums){
        if(nums.length==0|| nums[0]< nums[nums.length-1])
            return nums[0];
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid+1]< nums[mid])
                return nums[mid+1];
            else if(nums[mid-1]> nums[mid])
                return nums[mid];
               else if(nums[mid]>nums[0])
                    left = mid +1;
                else
                    right = mid -1;

        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(findMinElement(nums));
        nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(findMinElement(nums));

        nums = new int[]{4,5,6,7,-4,0,1,2};
        System.out.println(findMinElement(nums));
    }
}
