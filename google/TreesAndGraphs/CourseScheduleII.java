package google.TreesAndGraphs;

import java.util.*;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 */
public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] topology = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count=0;
        for(int[] courses: prerequisites){
            List<Integer> courseList = graph.getOrDefault(courses[1],new ArrayList<>());
            courseList.add(courses[0]);
            graph.put(courses[1],courseList);
            topology[courses[0]]++;
        }
      for(int i=0;i<numCourses;i++){
          if(topology[i]==0){
              count++;
              queue.offer(i);
          }
      }
      int[] result= new int[numCourses];
      int i=0;
      while (!queue.isEmpty()){
          result[i] = queue.poll();
          if(graph.containsKey(result[i])){
              for(Integer nextCourse : graph.get(result[i])){
                  topology[nextCourse]--;
                  if(topology[nextCourse]==0){
                      count++;
                      queue.offer(nextCourse);
                  }
              }
          }
          i++;
      }
      if(count== numCourses)
          return result;
      return new int[]{0};

    }

    public static void main(String[] args) {
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        int[] result1 = findOrder(numCourses1, prerequisites1);
        System.out.println(Arrays.toString(result1)); // Output: [0, 1]

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result2 = findOrder(numCourses2, prerequisites2);
        System.out.println(Arrays.toString(result2)); // Output: [0, 1, 2, 3] or [0, 2, 1, 3]
    }
}
