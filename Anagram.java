public class Anagram {

    public static boolean anag(String s1,String s2){

        if(s1==null && s2 == null)
            return true;
        if(s1==null || s2==null)
            return false;
        if(s1.length()!= s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        int[] array = new int[26];
        for(char ch : s1.toCharArray()){
            array[ch-'a']++;
        }
        for(char ch : s2.toCharArray()){
            array[ch-'a']--;
        }
        for(int i=0;i<26;i++){
            if(array[i]!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(anag("cat","act"));
    }
}
