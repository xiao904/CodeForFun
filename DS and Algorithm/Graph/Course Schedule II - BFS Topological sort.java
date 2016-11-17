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
/*
L ¡û Empty list that will contain the sorted elements
S ¡û Set of all nodes with no incoming edges
while S is non-empty do
    remove a node n from S
    add n to tail of L
    for each node m with an edge e from n to m do
        remove edge e from the graph
        if m has no other incoming edges then
            insert m into S
if graph has edges then
    return error (graph has at least one cycle)
else 
    return L (a topologically sorted order)
	*/
    public int[] canFinish(int numCourses, int[][] prerequisites) {
	      //Initial graph
	      List<Integer>[] graph = new ArrayList[numCourses];
		
		  //incomingNodes counting
		  int[] incomingNodes = new int[numCourses];
		  //Queue of nodes without incomingNodes
		  Queue<Integer> queue = new LinkedList<Integer>();
		  //build the graph
		  for(int m = 0; m < numCourses; m++)
		     graph[m] = new ArrayList<Integer>();
		  for(int n = 0; n < prerequisites.length; n++){
		     graph[prerequisites[n][1]].add(prerequisites[n][0]);
			 incomingNodes[prerequisites[n][0]]++;
		  }
		  for(int l = 0; l < incomingNodes.length; l++){
		      if(incomingNodes[l] == 0) queue.offer(l);
          }		  
          int[] res = new int[numCourses];
          int i = 0;
          int edgelength = prerequisites.length;		  
		  //BFS
		  while(!queue.isEmpty()){
		       int cur = queue.poll();
			   res[i++] = cur;
			   for(int j : graph[cur]){
			        edgelength--;
                    if(--incomingNodes[j] == 0)
					   queue.offer(j);			   
			   }
			   
		  }
		  //determin if all courses are taken
		  //and there is no cycle
		  if(edgelength == 0)
		      return res;
		  else return new int[]{};
		  
		  
		  
	}
	
	
}	