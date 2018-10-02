/**
 * Practice Assignment 05
 * @author Benny Fung
 */
public class BSTree
{
	private BSTNode root;
	
	public BSTree()
	{
		this.root = null;
	}
	
	/**
	 * Inserts value into tree if empty
	 * @param value
	 */
	public void insert(String value) 
	{
		if(root != null)
		{
			insert(value, root);
		}
		else
		{
			root = insert(value, root);
		}
	}
	
	/**
	 * @param value
	 * @param node
	 * @return
	 */
	private BSTNode insert(String value, BSTNode node)
	{
		if(node == null)
		{
			return new BSTNode(value);
		}
		
		if(value.compareTo(node.data) < 0)
		{
			node.left = insert(value, node.left);
			return node;
		}
		
		else
		{
			node.right = insert(value, node.right);
			return node;
		}
	}

	/**
	 * Returns true if parameter value is found in tree
	 * @param value
	 * @return
	 */
	public boolean find(String value) 
	{
		return find(value, root);
	}
	
	/**
	 * @param value
	 * @param node
	 * @return
	 */
	private boolean find(String value, BSTNode node)
	{
		if(node == null)
		{
			return false;
		}
		
		if(value.compareTo(node.data) == 0)
		{
			return true;
		}
		
		else if(value.compareTo(node.data) < 0)
		{
			return find(value, node.left);
		}
		
		else
		{
			return find(value, node.right);
		}
	}

	/**
	 * Deletes value from tree
	 * @param value
	 */
	public void delete(String value) 
	{
		root = delete(root, value);
	}
	
	/**
	 * Helper method for delete() method that finds smallest value (or child) of tree
	 * @param node
	 * @return
	 */
	private String removeSmallest(BSTNode node)
	{
		if(node.left.left == null)
		{
			String smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		return removeSmallest(node.left);
	}
	
	/**
	 * Deletes specific value from tree
	 * @param node
	 * @param value
	 * @return
	 */
	public BSTNode delete(BSTNode node, String value)
	{
		if(node == null)
		{
			return null;
		}
		
		if(value.compareTo(node.data) == 0)
		{
			if(node.left == null)
			{
				return node.right;
			}
			
			else if(node.right == null)
			{
				return node.left;
			}
			
			else
			{
				if(node.right.left == null)
				{
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				}
				else
				{
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		}
		else if(value.compareTo(node.data) < 0)
		{
			node.left = delete(node.left, value);
		}
		else
		{
			node.right = delete(node.right, value);
			return node;
		}
		return node;
	}
	
	/**
	 * Returns data (without leading whitespaces) of the tree starting from left child, to root, and to right child.
	 * @return
	 */
	public String toStringInOrder()
	{
		return toStringInOrder(root).trim();
	}
	
	private String toStringInOrder(BSTNode node)
	{
		String order = "";
		if(node != null)
		{
			order = order + toStringInOrder(node.left) + node.data + " " + toStringInOrder(node.right);
		}
		return order;
	}
	
	/**
	 * Returns data (without leading whitespaces) of the tree starting from root, to left child, and to right child
	 * @return
	 */
	public String toStringPreOrder()
	{
		return toStringPreOrder(root).trim();
	}
	
	private String toStringPreOrder(BSTNode node)
	{	
		String preOrder = "";
		if(node != null)
		{
			preOrder = preOrder + node.data + " " + toStringPreOrder(node.left) + toStringPreOrder(node.right);
		}
		return preOrder;
	}
}