import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
            return new ArrayList();
        Map<String, List> map = new HashMap<String, List>();
        int[] arr = new int[26];
        for(String str: strs){
            Arrays.fill(arr,0);

            for(char ch : str.toCharArray()){
                arr[ch-'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<26;i++){
                sb.append('#');
                sb.append(arr[i]);
            }
            System.out.println(sb);
            String key = sb.toString();
            if(!map.containsKey(key)) map.put(key,new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
