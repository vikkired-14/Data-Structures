package google;


import java.util.*;

/*
Two strings, X and Y, are considered similar if either they are identical or we can make them equivalent by swapping at most two letters (in distinct positions) within the string X.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list strs of strings where every string in strs is an anagram of every other string in strs. How many groups are there?



Example 1:

Input: strs = ["tars","rats","arts","star"]
Output: 2
Example 2:

Input: strs = ["omv","ovm"]
Output: 1


Constraints:

1 <= strs.length <= 300
1 <= strs[i].length <= 300
strs[i] consists of lowercase letters only.
All words in strs have the same length and are anagrams of each other.
 */
public class SimilarStringGroups {

    //Using UnionFind algo
    static class UnionFind{
        int[] parent;
        int[] rank;
        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i] =i;
                rank[i]=0;
            }
        }
        public int find(int x){
            if(parent[x]!=x)
                return find(parent[x]);
            return parent[x];
        }

        public void union(int x,int y){
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot==yRoot){
                return;
            } else if (rank[xRoot]>rank[yRoot]) {
                parent[yRoot]= xRoot;
            }
            else if (rank[yRoot]>rank[xRoot]) {
                parent[xRoot]= yRoot;
            }else {
                parent[xRoot]= yRoot;
                rank[yRoot]++;
            }
        }
    }
    public static int numSimilarGroups(String[] strs) {
      int n = strs.length;
        UnionFind dsu = new UnionFind(n);
        int count =n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i],strs[j]) && dsu.find(i)!=dsu.find(j)){
                    count--;
                    dsu.union(i,j);
                }
            }
        }
        return count;
    }

    public static  boolean isSimilar(String s1,String s2){
        int diff =0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
            }
        }
        return diff==0 || diff==2;
    }

    //Using BFs we can even achieve this using dfs
    public static int numSimilarGroupsBfs(String[] strs) {
        int n = strs.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i],strs[j])){
                    graph.computeIfAbsent(i,k->new ArrayList<>()).add(j);
                    graph.computeIfAbsent(j,k-> new ArrayList<>()).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                bfs(i,graph,visited);
            }
        }
        return count++;
    }
    public static void bfs(int node,Map<Integer,List<Integer>> graph,boolean[] visited){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            int idx = queue.poll();
            if(graph.containsKey(idx)){
            for (Integer adjNode : graph.get(idx)) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    queue.offer(adjNode);
                }
            }
        }

        }
    }

        public static void main(String[] args){
//        Input: strs = ["tars","rats","arts","star"]
//        Output: 2
//
//        Input: strs = ["omv","ovm"]
//        Output: 1
            System.out.println("*******************UnionFind*************************");
            System.out.println(numSimilarGroups(new String[]{"tars","rats","arts","star"}));
        System.out.println(numSimilarGroups(new String[]{"omv","ovm"}));
            System.out.println("*******************BFS*************************");
            System.out.println(numSimilarGroupsBfs(new String[]{"tars","rats","arts","star"}));
            System.out.println(numSimilarGroupsBfs(new String[]{"omv","ovm"}));


    }
}
/*
Union Find Time and space
Here nnn is the size of strs and m is length of each word in strs.

Time complexity: O(n2⋅m)O(n^2 \cdot m)O(n
2
 ⋅m).

We need O(n2)O(n^2)O(n
2
 ) time to iterate over all the pairs of words that can be formed using strs. We further need O(m)O(m)O(m) time to check whether the chosen two words are similar or not, resulting in O(n2⋅m)O(n^2 \cdot m)O(n
2
 ⋅m) operations to check all the pairs.
For TTT operations, the amortized time complexity of the union-find algorithm (using path compression with union by rank) is O(alpha(T))O(alpha(T))O(alpha(T)). Here, α(T)\alpha(T)α(T) is the inverse Ackermann function that grows so slowly, that it doesn't exceed 444 for all reasonable TTT (approximately T<10600 T < 10^{600}T<10
600
 ). You can read more about the complexity of union-find here. Because the function grows so slowly, we consider it to be O(1)O(1)O(1).
Initializing UnionFind takes O(n)O(n)O(n) time beacuse we are initializing the parent and rank arrays of size n each.
We iterate through every edge and use the find operation to find the component of nodes connected by each edge. It takes O(1)O(1)O(1) per operation and takes O(e)O(e)O(e) time for all the eee edges. As discussed above, we can have a maximum of O(n2)O(n^2)O(n
2
 ) edges in between nnn nodes, so it would take O(n2)O(n^2)O(n
2
 ) time. If nodes from different components are connected by an edge, we also perform union of the nodes, which takes O(1)O(1)O(1) time per operation. In the worst-case scenario, it may be called O(n)O(n)O(n) times to connect all the components to form a connected graph with only one component.
Space complexity: O(n)O(n)O(n).

We are using the parent and rank arrays, both of which require O(n)O(n)O(n) space each.
Breadth First Search
Here nnn is the size of strs and m is length of each word in strs.

Time complexity: O(n2⋅m)O(n^2 \cdot m)O(n
2
 ⋅m).

We need O(n2)O(n^2)O(n
2
 ) time to iterate over all the pairs of words that can be formed using strs. We further need O(m)O(m)O(m) time to check whether the chosen two words are similar or not, resulting in O(n2⋅m)O(n^2 \cdot m)O(n
2
 ⋅m) operations to check all the pairs.
Each queue operation in the BFS algorithm takes O(1)O(1)O(1) time, and a single node can only be pushed once, leading to O(n)O(n)O(n) operations for nnn nodes. As discussed above, we can have up to O(n2)O(n^2)O(n
2
 ) edges between nnn nodes (assume every word is similar to every other word). Because we have undirected edges, each edge can only be iterated twice (by nodes at the end), resulting in O(n2)O(n^2)O(n
2
 ) operations total in the worst-case scenario while visiting all nodes.
Space complexity: O(n2)O(n^2)O(n
2
 ).

As there can be a maximum of O(n2)O(n^2)O(n
2
 ). edges, building the adjacency list takes O(n2)O(n^2)O(n
2
 ). space in the worst case.
The BFS queue takes O(n)O(n)O(n) because each node is added at most once.
The visit array takes O(n)O(n)O(n) space as well.
 */