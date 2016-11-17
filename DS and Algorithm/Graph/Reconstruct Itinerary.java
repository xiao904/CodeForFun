/*Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.*/

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        //build a graph
		//dfs find a route run through all tickets
		//the one without incoming node put to the tail
		//JFK is the head
		//lexical order >> minHeap >>priorityQueue
		Map<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
		LinkedList<String> route = new LinkedList();
		for(String[] ticket : tickets){
		    graph.putIfAbsent(ticket[0], new PriorityQueue<String>());
			graph.get(ticket[0]).add(ticket[1]);
		}
		dfs(graph, "JFK", route);
		return route;
	}
	
	void dfs(Map<String, PriorityQueue<String>> graph, String dep, LinkedList<String> route){
	     while(graph.get(dep) !=null && !graph.get(dep).isEmpty()){
		      dfs(graph, graph.get(dep).poll(), route);
		 }
		 route.addFirst(dep);
	}
}