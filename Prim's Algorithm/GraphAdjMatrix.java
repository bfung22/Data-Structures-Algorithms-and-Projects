/**
 * Practice Assignment 09
 * Derived Prim's implementation of Minimum Spanning Tree
 * @author BennyFung
 *
 */
public class GraphAdjMatrix implements Graph
{
	private int[][] edges;
	
	/**
	 * Initializes constructor
	 * @param size
	 */
	public GraphAdjMatrix(int size)
	{
		edges = new int[size][size];
	}
	
	public void topologicalSort()
	{
		//from P8
	}

	@Override
	/**
	 * Adds edge between two vertices with weight value
	 */
	public void addEdge(int v1, int v2, int weight)
	{
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
	}
	
	@Override
	public void addEdge(int v1, int v2) 
	{
		edges[v1][v2] = 1;
		edges[v2][v1] = 1;
	}

	@Override
	/**
	 * Returns edge given vertices as parameters
	 */
	public int getEdge(int v1, int v2)
	{
		return edges[v1][v2];
	}

	@Override
	/**
	 * Creates the minimum spanning tree
	 * and returns sum of the weights of only the
	 * edges that are in the MST.
	**/
	public int createSpanningTree()
	{	
		int[]path = new int[edges.length];
		int[]cost = new int[edges.length];
		boolean[] known = new boolean[edges.length];
		int weight = 0;
		
		for (int i = 0; i < edges.length; i++)
		{
			//T[v].cost = infinity 
			//T[v].known = false
			//T[v].path = -1 
			cost[i] = Integer.MAX_VALUE;
			known[i] = false; 
			path[i] = -1; 
		}
		
		//T[initial vertex].cost = 0 
		cost[0] = 0;
		for (int v = 0; v < edges.length; v++)
		{
			//v = Minimum Unknown Vertex(T) 
			int index = getMin(cost, known);
			//T[v].known = true
			known[index] = true;
			
			for (int j = 0; j < edges.length; j++)
			{
				if (edges[index][j] != 0 && known[j] == false) 
				{ //if (!T[u].known && T[u].cost >edge cost(u,v)) 
					if(cost[j] > edges[index][j])
					{	
						//T[u].path = v
						//T[u].cost = edge cost(u,v)
						path[j] = index;
						cost[j] = edges[index][j];
					}
				}
			}
		}
		
		for (int edge = 1; edge < edges.length; edge++)
		{
			weight += edges[edge][path[edge]];
		}
		
		return weight;
	}
	/**
	 * Helper method that finds the minimum cost of an index
	 * @param cost
	 * @param known
	 * @return
	 */
	private int getMin(int[] cost, boolean[] known)
	{
		int min = Integer.MAX_VALUE;
		int pos = -1;
		for (int i = 0; i < edges.length; i++)
		{
			if (known[i] == false && cost[i] < min)
			{
				pos = i;
				min = cost[i];
			}
		}
		return pos;
	}
}