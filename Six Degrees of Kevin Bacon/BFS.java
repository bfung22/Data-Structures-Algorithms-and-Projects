import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Class that contains methods to find shortest path between two actors.
 * @author Benny Fung
 *
 */
public class BFS
{
	/**
	 * Instantiates boolean array and calls the breadthFirst method.
	 * @param adj
	 * @param actor1
	 * @param actor2
	 */
	public void search(AdjacencyList adj, String actor1, String actor2)
	{
		boolean[] visited = new boolean[adj.numOfElements()];
		breadthFirst(adj, adj.getIndex(actor1), adj.getIndex(actor2), visited);
	}
	
	/**
	 * Modified breadth first search that finds the shortest path between two actors.
	 * @param adj
	 * @param actor1Index
	 * @param actor2Index
	 * @param visited
	 */
	private void breadthFirst(AdjacencyList adj, int actor1Index, int actor2Index, boolean[] visited)
	{	
		Queue<Integer> queue = new LinkedList<Integer>();
		Map<Integer, Integer> path = new HashMap<>();
		String actor1Name = adj.getName(actor1Index);
		String actor2Name = adj.getName(actor2Index);

		if(adj.containsNeighborOfIndex(actor1Index, actor2Index)) //if actor1 already shares a movie with actor2
		{
			System.out.println("Path between " + actor1Name + " and " + actor2Name + ": ");
			System.out.println(actor1Name + " --> " + actor2Name);
			return;
		}
		
		queue.add(actor1Index);
		visited[actor1Index] = true;
		while(!queue.isEmpty())
		{
			int index = queue.poll();
			Iterator<Integer> it = adj.getNeighbors(index).iterator(); //get all the neighboring vertices from the value dequeued
			while(it.hasNext())
			{
				int current = it.next();
				if(!visited[current])
				{
					visited[current] = true;
					queue.add(current);
					path.put(current, index); //stores the "neighbor" index with the index that was dequeued. This is to keep track of the path
				}
				if(current == actor2Index)
				{
					String result = "";
					int temp = current;
					while(path.get(temp) != null) //backtracks through map until it reaches the root actor that was previously dequeued
					{
						result = " --> " + adj.getName(temp) + result;
						temp = path.get(temp);
					}
					System.out.println("Path between " + actor1Name + " and " + actor2Name + ": ");
					System.out.println(actor1Name + result);
					return;
				}
			}
		}
		System.out.println("No path could be found.");
	}
}
