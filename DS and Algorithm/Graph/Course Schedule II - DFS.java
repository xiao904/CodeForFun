/*There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
*/

public class Solution {
    public int[] canFinish(int numCourses, int[][] prerequisites) {
	      List<Integer>[] graph = new ArrayList[numCourses];
		  //check if there is a circle
		  boolean[] visited = new boolean[numCourses];
		  //avoid the duplicate search
		  boolean[] onpath = new boolean[numCourses];
		  Stack<Integer> result = new Stack<Integer>();
		  //build the graph
		  for(int m = 0; m < numCourses; m++)
		     graph[m] = new ArrayList<Integer>();
		  for(int n = 0; n < prerequisites.length; n++)
		     graph[prerequisites[n][1]].add(prerequisites[n][0]);
		  //dfs search
		  for(int i = 0;i < numCourses; i++){
		     if(!dfs(graph, visited, onpath, i, result))
			     return new int[]{};
		  }
		  int[] array = new int[numCourses];
		  int j = 0;
		  while(!result.isEmpty()){
		     array[j++] = result.pop();
		  }
		  return array;
	}
	
	boolean dfs(List<Integer>[] graph, boolean[] visited, boolean[] onpath, int i, Stack<Integer> result){
	   if(onpath[i]) return true;
	   if(visited[i]) return false;
	   visited[i] = true;
	   for(int j = 0; j < graph[i].size(); j++){
	      if(!dfs(graph, visited, onpath, graph[i].get(j))){
	          return false;	  
		  }
	   }
	   result.push(i);
	   visited[i] = false;
	   onpath[i] = true;
	   return true;
	}
}	