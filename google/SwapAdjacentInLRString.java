package google;
/*
In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.



Example 1:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: true
Explanation: We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
Example 2:

Input: start = "X", end = "L"
Output: false


Constraints:

1 <= start.length <= 104
start.length == end.length
Both start and end will only consist of characters in 'L', 'R', and 'X'.
 */
public class SwapAdjacentInLRString {

    public static boolean canTransform(String start, String end) {

        if(!start.replace("X","").equalsIgnoreCase(end.replace("X","")))
              return false;
        int len = start.length();
        int i=0,j=0;
        while(i<len && j< len){
            char chStart = start.charAt(i);
            char chEnd = end.charAt(j);
           while(i<len && chStart=='X'){
               i++;
           }
           while (j<len && chEnd=='X'){
               j++;
           }
           if(i==len || j == len)
               break;
           //XL -> LX   RX-> XR
           if((chStart!=chEnd)||(chStart=='L' && i<j)||(chEnd=='R' && i>j) ){
               return false;
           }
           i++;j++;
        }
        return true;
    }
    public static void main(String[] args) {
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";

        System.out.println(canTransform(start, end)); // true

        start = "X";
        end = "L";

        System.out.println(canTransform(start, end)); // false
    }
    }
/*
if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }
        int i = 0, j = 0, n = start.length();
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i == n || j == n) {
                break;
            }
            if (start.charAt(i) != end.charAt(j) ||
            (start.charAt(i) == 'L' && i < j) ||
             (start.charAt(i) == 'R' && i > j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
 */