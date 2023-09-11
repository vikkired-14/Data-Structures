public class ValidPalindrome {

    public static boolean isValidPalindrome(String str){
        int i=0;
        int j = str.length()-1;
        while(i<j){
            Character start = str.charAt(i);
            Character end = str.charAt(j);
            if(!Character.isAlphabetic(start)){
                i++;
                continue;
            }
            if(!Character.isAlphabetic(end)){
                j--;
                continue;
            }
            if(Character.toLowerCase(start)!=Character.toLowerCase(end))
                return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(isValidPalindrome("A man, a plan, a canal: Panama"));
    }
}
