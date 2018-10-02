/**
 * Author: Benny Fung
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjMatrix implements Graph
{
	/**
	 * Initialize data variables
	 */
	private int[][] edges;
	
	/**
	 * Initialize constructor
	 * @param size
	 */
	public GraphAdjMatrix(int size) 
	{
		edges = new int[size][size];
	}

	/**
	 * Add edges to the given parameters
	 */
	@Override
	public void addEdge(int v1, int v2)
	{
		if (v1< 0 || v1> edges.length && v2 < 0 || v2 > edges.length) 
		{
			throw new IndexOutOfBoundsException("error");
		}
		edges[v1][v2] = 1;
		edges[v2][v1] = 1;
	}
	
	/**
	 * Returns number of edges pointing out from vertex v.
	 * @param v
	 * @return
	 */
	public int outDegree(int v)
	{
		int degree = 0;
		for(int i = 0; i < edges.length; i++)
		{
			if(edges[i][v] >= 0)
			{
				degree++;
			}
		}
		return degree;
	}
	
	/**
	 * Returns the first occurrence of element that does not contain adjacency.
	 * @param edges
	 * @return
	 */
	public int findZero(int[] edges)
	{
		for(int i = 0; i < edges.length; i++)
		{
			if (edges[i]==0)
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns number of edges pointing to vertex v.
	 * @param v
	 * @return
	 */
	public int inDegree(int v)
	{
		int degree = 0;
		for(int i = 0; i < edges.length; i++)
		{
			if(edges[i][v] != 0)
			{
				degree++;
			}
		}
		return degree;
	}
	
		
	/**
	 * Returns neighbors
	 * @param v
	 * @return
	 */
	private LinkedList<Integer> getNeighbors(int v)
	{
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for(int i = 0; i < edges.length; i++)
		{
			if(edges[v][i] == 1)
			{
				linkedList.add(new Integer(i));
			}
		}

		return linkedList;
	}
	
	
	@Override
	public void topologicalSort()
	{
		boolean[] visited = new boolean[edges.length];
		for(int i = 0; i <visited.length; i++)
		{
			if(!visited[i])
			{
				dfs(i, visited);
			}
		}
	}
	
	/**
	 * Topological sort by depth-first search
	 * @param vertex
	 * @param visited
	 */
	private void dfs(int vertex, boolean[] visited)
	{
		Stack<Integer> s = new Stack<Integer>();
		visited[vertex] = true;
		s.push(new Integer(vertex));
		while(!s.empty())
		{
			int u = s.pop();
			System.out.println(u);
			Iterator<Integer> it = getNeighbors(u).iterator();
			while(it.hasNext())
			{
				int v = it.next();
				if(!visited[v])
				{
					visited[v] = true;
					s.push(new Integer(v));
				}
			}
		}
	}

	/**
	 * Checks for neighbors of vertex, and creates array of out degrees.
	 */
	@Override
	public int[] neighbors(int vertex)
	{
		int size = 0;
		int[] temp = new int[edges.length];
		
		for(int i = 0; i < edges.length; i++)
		{
			if(edges[vertex][i] == 1)
			{
				temp[size++] = i;
			}
		}

		int[] arr = new int[size];
		for(int i = 0; i< arr.length; i++)
		{
			arr[i] = temp[i];
		}
		return arr;
	}
}
