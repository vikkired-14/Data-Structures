package google;
/*
Given a rows x cols screen and a sentence represented as a list of strings, return the number of times the given sentence can be fitted on the screen.

The order of words in the sentence must remain unchanged, and a word cannot be split into two lines. A single space must separate two consecutive words in a line.



Example 1:

Input: sentence = ["hello","world"], rows = 2, cols = 8
Output: 1
Explanation:
hello---
world---
The character '-' signifies an empty space on the screen.
Example 2:

Input: sentence = ["a", "bcd", "e"], rows = 3, cols = 6
Output: 2
Explanation:
a-bcd-
e-a---
bcd-e-
The character '-' signifies an empty space on the screen.
Example 3:

Input: sentence = ["i","had","apple","pie"], rows = 4, cols = 5
Output: 1
Explanation:
i-had
apple
pie-i
had--
The character '-' signifies an empty space on the screen.


Constraints:

1 <= sentence.length <= 100
1 <= sentence[i].length <= 10
sentence[i] consists of lowercase English letters.
1 <= rows, cols <= 2 * 104
 */
public class SentenceScreenFitting {
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder strb = new StringBuilder();
        for(String str : sentence){
            strb.append(str).append(" ");
        }
        String fullString = strb.toString();
        int strLen = fullString.length();
        int cursor =0;
        for(int i=0;i<rows;i++){
            cursor += cols;
            if(fullString.charAt(cursor%strLen)==' '){
                cursor++;
            }else{
                while(cursor>0 && fullString.charAt(cursor%strLen)!=' '){
                    cursor--;
                }
                ++cursor;
            }
        }
     return cursor/strLen;
    }

    public static void main(String[] args){
//        Input: sentence = ["hello","world"], rows = 2, cols = 8
//        Output: 1

        String[] input = new String[]{"hello","world"};
        System.out.println(wordsTyping(input,2,8));//1
//        Input: sentence = ["a", "bcd", "e"], rows = 3, cols = 6
//        Output: 2
        input = new String[]{"a", "bcd", "e"};
        System.out.println(wordsTyping(input,3,6));
    }
/*
public int wordsTyping(String[] sentence, int rows, int cols) {
   StringBuilder sb = new StringBuilder();
   for(String str: sentence){
    sb.append(str).append(" ");
   }
   String fullString = sb.toString();
   int len = fullString.length();
   int start =0;
   for(int i=0;i<rows;i++){
     start += cols;
     if(fullString.charAt(start%len)==' '){
        start++;
     }else{
        while(start>0 && fullString.charAt((start-1)%len)!=' ' )
         start--;
     }
   }
  return start/len;
}
 */
}
