package google;
/*
You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.

A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels. More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.

Return the number of weak characters.



Example 1:

Input: properties = [[5,5],[6,3],[3,6]]
Output: 0
Explanation: No character has strictly greater attack and defense than the other.
Example 2:

Input: properties = [[2,2],[3,3]]
Output: 1
Explanation: The first character is weak because the second character has a strictly greater attack and defense.
Example 3:

Input: properties = [[1,5],[10,4],[4,3]]
Output: 1
Explanation: The third character is weak because the second character has a strictly greater attack and defense.
 */
public class TheNumberOfWeakCharactersInTheGame {

    public int numberOfWeakCharacters(int[][] properties) {

        int maxAttack =0;
        for(int[] propertie :properties ){
            maxAttack = Math.max(maxAttack,propertie[0]);
        }
        int[] maxDefense = new int[maxAttack+2];
        for(int[] propertie:properties){
            maxDefense[propertie[0]]= Math.max(propertie[1],maxDefense[propertie[0]]);
        }

        for(int i=maxAttack-1;i>=0;i--){
            maxDefense[i] = Math.max(maxDefense[i],maxDefense[i+1]);
        }

        int weakChar =0;
        for(int[] propertie : properties){
            int attack = propertie[0];
            int defense = propertie[1];
            if(defense<maxDefense[attack+1]){
                weakChar++;
            }
        }
        return weakChar;
    }
}
