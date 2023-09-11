import java.util.*;

public class ThreeSum {
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> getThreeSum(int[] arr){
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1 && arr[i]<=0;i++){
            if(i==0 || arr[i-1]!=arr[i]){
                twoSum(i,arr);
            }
        }
        return  res;
    }

    private static void twoSum(int i, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int j=i+1;j< arr.length;j++){
            int target = 0-arr[i]-arr[j];
            if(set.contains(target)){
                res.add(Arrays.asList(arr[i], arr[j], target));
                while(j+1< arr.length && arr[j]==arr[j+1])
                    j++;

            }
            set.add(arr[j]);
        }

    }

    public static void main(String[] args){
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> aList = getThreeSum(arr);
        for(List<Integer>list : aList){
                System.out.println(list.toString());
        }

    }
}
