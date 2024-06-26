package google.TreesAndGraphs;
import java.util.*;
/*
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.



Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Explanation: One way to make 3 moves is as follows:
1. Remove stone [2,2] because it shares the same row as [2,0].
2. Remove stone [2,0] because it shares the same column as [0,0].
3. Remove stone [0,2] because it shares the same row as [0,0].
Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
Example 3:

Input: stones = [[0,0]]
Output: 0
Explanation: [0,0] is the only stone on the plane, so you cannot remove it.


Constraints:

1 <= stones.length <= 1000
0 <= xi, yi <= 104
No two stones are at the same coordinate point.
 */
public class MostStonesRemovedwithSameRoworColumn {

    static int k = 10001;
    public static int removeStones(int[][] stones) {
        HashMap <Integer, Integer> marked = new HashMap<>();
        int countInc =0;
        int[] parent = new int[2*k+1];
        int[] rank = new int[2*k+1];
        for(int i=0;i<2*k+1;i++){
            parent[i] = i;
            rank[i] =1;
        }
        for(int i=0;i<stones.length;i++){
            int x = stones[i][0];
            int y = stones[i][1]+k;

            if(!marked.containsKey(x))
                countInc++;
            if(!marked.containsKey(y))
                countInc++;

            marked.put(x, 1);
            marked.put(y, 1);
        }
        for(int i=0;i<stones.length;i++){
            int x = stones[i][0];
            int y = stones[i][1]+k;
            //System.out.println(x+":"+y + ":->"+ stones[i][1] +":"+k);
            countInc -= performUnion(rank,parent,x,y);
        }
        return stones.length - countInc;
    }

    public static int performUnion(int[] rank,int[] parent,int x,int y){


        int xRoot = find(parent,x);
        int yRoot = find(parent,y);
        if (xRoot == yRoot) {
            return 0;
        }
        if(rank[xRoot] > rank[yRoot]){
            parent[yRoot] = xRoot;
        }

        else if(rank[yRoot] > rank[xRoot]) {
            parent[xRoot] = yRoot;
        }
        else{
            parent[yRoot] = xRoot;
            rank[xRoot] += rank[yRoot];
        }


        return 1;
    }

    public static int find(int[] parent,int x){

        if(parent[x] == x)
            return parent[x];
        return parent[x] = find(parent,parent[x]);
    }

    public static void main(String[] args) {
        int[][] stones1 = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int[][] stones2 = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        int[][] stones3 = {{0, 0}};

        int result1 = removeStones(stones1);
        int result2 = removeStones(stones2);
        int result3 = removeStones(stones3);

        System.out.println("Output 1: " + result1); // Output: 5
        System.out.println("Output 2: " + result2); // Output: 3
        System.out.println("Output 3: " + result3); // Output: 0
    }
}
/*
Approach 3: Optimized Depth-First Search (DFS)
Time complexity: O(K)O(K)O(K)

Building the graph will need O(N)O(N)O(N). During the DFS traversal, each stone only is visited once. This is because we mark each stone(from 0 to 2 * K + 1) as visited as soon as we see it, and then we only visit stones that are not marked as visited. In addition, when we iterate over the edge list of each stone, we look at each edge once thus it will cost O(E)O(E)O(E). The total cost will be O(N+K)O(N + K)O(N+K) which can be written as O(K)O(K)O(K) as we know N≤KN \leq KN≤K.

Space complexity: O(K)O(K)O(K)

Building the adjacency list will take O(N)O(N)O(N) space. To keep track of visited vertices, an array of size O(K)O(K)O(K), is required. Also, the run-time stack for DFS will use O(K)O(K)O(K) space.
public int removeStones(int[][] stones) {
        int k =1001;
        List<Integer>[] adj = new ArrayList[2*k+1];
        for(int i=0;i<2*k+1;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] stone: stones){
            int x = stone[0];
            int y = 1000+ stone[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        int count=0;
        boolean[] visited = new boolean[2*k+1];
        for(int[] stone : stones){
            if(!visited[stone[0]]){
                count++;
                dfs(visited,adj,stone[0]);
            }
        }
        return stones.length-count;
    }

     public void dfs(boolean[] visited, List<Integer>[] adj,int x){
        visited[x]=true;
        for(Integer k : adj[x]){
            if( !visited[k] && !adj[k].isEmpty()){
                dfs(visited,adj,k);
            }
        }
    }


    union Find
     public int removeStones(int[][] stones) {
        int[] parent= new int[stones.length];
        int[] rank = new int[stones.length];
        for(int i=0;i<stones.length;i++){
            parent[i]=i;
            rank[i] =i;
        }
        int count = stones.length;
        for(int i=0;i<stones.length;i++){
             for(int j=1;j<stones.length;j++){
                 if(isSameRowOrColoum(stones[i],stones[j])){
                     count -= performUnion(i,j,parent,rank);
                 }
             }
        }
        return stones.length-count;
    }

   public int performUnion(int i,int j,int[] parent,int[] rank){
       int xRoot = find(parent,i);
       int yRoot = find(parent,j);
       if(xRoot==yRoot)
           return 0;
       if(rank[xRoot]> rank[yRoot]){
           parent[yRoot] = xRoot;

       }else if(rank[xRoot]< rank[yRoot]){
            parent[xRoot] = yRoot;
       }else{
            parent[yRoot] = xRoot;
           rank[xRoot] += rank[yRoot];
       }
       return 1;
   }

    public int find(int[] parent,int i){
        if(parent[i]==i)
            return parent[i];
        return find(parent,parent[i]);
    }

    public boolean isSameRowOrColoum(int[] stone1,int[] stone2){
        if(stone1[0]==stone2[0] || stone1[1]==stone2[1])
            return true;
        return false;
    }

    Here NNN is the Number of stones.

Time complexity: O(N2⋅α(N))O( N^2 \cdot \alpha(N))O(N
2
 ⋅α(N))

The amortized time complexity for each union-find operation is O(α(N))O(\alpha(N))O(α(N)), where α\alphaα is The Inverse Ackermann Function, this is because we have used union by size as well as path compression in the DSU implementation.

Initializing the rep and size will take O(N)O(N)O(N) time. We then iterate over all the O(N2)O(N^2)O(N
2
 ) pairs and for each pair, the performUnion function will take O(α(n))O(\alpha(n))O(α(n)) time, hence the total time complexity is equal to O(N2⋅α(n))O( N^2 \cdot \alpha(n))O(N
2
 ⋅α(n)).

Space complexity: O(N)O(N)O(N)

Storing the representative/immediate-parents and sizes of NNN stones takes O(N)O(N)O(N) space.
 */