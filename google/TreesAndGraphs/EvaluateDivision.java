package google.TreesAndGraphs;

import java.util.*;

/*
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.



Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]


Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
       Map<String,Map<String,Double>> graph = new HashMap<>();
       int i=0;
        for(List<String> equation : equations){
            String u = equation.get(0);
            String v = equation.get(1);
            graph.computeIfAbsent(u,k->new HashMap<>());
            graph.computeIfAbsent(v,k->new HashMap<>());
            graph.get(u).put(v,values[i]);
            graph.get(v).put(u,1/values[i]);
            i++;
        }
        i=0;
        double[] result = new double[queries.size()];
        for(List<String>query: queries){
            String u = query.get(0);
            String v = query.get(1);
            if(!graph.containsKey(u)|| !graph.containsKey(v)){
                result[i++]=-1.0;
            } else if (u.equalsIgnoreCase(v)) {
                result[i++]=1.0;
            }else {
                result[i++] = dfs(graph,u,v,new HashSet<>(),1.0);
            }

        }
        return result ;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String u, String v, HashSet<String> visited, double product) {
        if(!visited.contains(u)){
            visited.add(u);
            if(graph.get(u).containsKey(v))
                return product * graph.get(u).get(v);
            for(Map.Entry<String,Double> child: graph.get(u).entrySet()){
                String key = child.getKey();
                double value = child.getValue();
                double result = dfs(graph,key,v,visited,product*value);
                if(result!=-1)
                    return result;
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();

        List<List<String>> equations1 = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
        double[] results1 = solution.calcEquation(equations1, values1, queries1);

        for (double result : results1) {
            System.out.print(result + " ");
        }
        System.out.println(); // Output: [6.0, 0.5, -1.0, 1.0, -1.0]

        List<List<String>> equations2 = List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd"));
        double[] values2 = {1.5, 2.5, 5.0};
        List<List<String>> queries2 = List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"), List.of("cd", "bc"));
        double[] results2 = solution.calcEquation(equations2, values2, queries2);

        for (double result : results2) {
            System.out.print(result + " ");
        }
        System.out.println(); // Output: [3.75, 0.4, 5.0, 0.2]

        List<List<String>> equations3 = List.of(List.of("a", "b"));
        double[] values3 = {0.5};
        List<List<String>> queries3 = List.of(List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x", "y"));
        double[] results3 = solution.calcEquation(equations3, values3, queries3);

        for (double result : results3) {
            System.out.print(result + " ");
        }
        System.out.println(); // Output: [0.5, 2.0, -1.0, -1.0]
    }
}
