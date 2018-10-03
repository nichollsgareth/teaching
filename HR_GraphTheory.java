import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node 
{
	public char label;
	public boolean visited=false;
	public Node(char l)
	{
		this.label=l;
	}
}

class Graph
{
	public Node rootNode;
	public ArrayList nodes=new ArrayList();
	public int[][] adjMatrix;//Edges will be represented as adjacency Matrix
	int size;	
	
	public void setRootNode(Node n)
	{
		this.rootNode=n;
	}
	
	public Node getRootNode()
	{
		return this.rootNode;
	}	
	
	public void addNode(Node n)
	{
		nodes.add(n);
	}
	
	//This method will be called to make connect two nodes
	public void connectNode(Node start,Node end)
	{
		if(adjMatrix==null)
		{
			size=nodes.size();
			adjMatrix=new int[size][size];
		}

		int startIndex=nodes.indexOf(start);
		int endIndex=nodes.indexOf(end);
		adjMatrix[startIndex][endIndex]=1;
		adjMatrix[endIndex][startIndex]=1;
	}	
	
	private Node getUnvisitedChildNode(Node n)
	{
		
		int index=nodes.indexOf(n);
		int j=0;
		while(j<size)
		{
			if(adjMatrix[index][j]==1 && ((Node)nodes.get(j)).visited==false)
			{
				return (Node)nodes.get(j);
			}
			j++;
		}
		return null;
	}
	
	//BFS traversal of a tree is performed by the bfs() function
	public void bfs()
	{
		
		//BFS uses Queue data structure
		Queue q=new LinkedList();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited=true;
		while(!q.isEmpty())
		{
			Node n=(Node)q.remove();
			Node child=null;
			while((child=getUnvisitedChildNode(n))!=null)
			{
				child.visited=true;
				printNode(child);
				q.add(child);
			}
		}
		//Clear visited property of nodes
		clearNodes();
	}
	
	//BFS traversal of a tree is performed by the bfs() function
	public int bfs(Node start, Node destination)
	{
		
		//BFS uses Queue data structure
		Queue q=new LinkedList();
		q.add(start);
		printNode(start);
		start.visited=true;
		boolean found = false;
		int steps = 0;
		while(!q.isEmpty())
		{
			Node n=(Node)q.remove();
			Node child=null;
			while((child=getUnvisitedChildNode(n))!=null)
			{
				child.visited=true;
				printNode(child);
				q.add(child);
				if (child.equals(destination)) {
					System.out.println("reached node");
					found = true;
					break;
				}
			}
			steps++;
			if (found) {
				break;
			}
		}
		//Clear visited property of nodes
		clearNodes();
		return steps;
	}
	
	//BFS traversal of a tree is performed by the bfs() function
	public int getDirectionCount(Node start, Node destination)
	{
		//BFS uses Queue data structure
		Queue q=new LinkedList();
		q.add(start);
		start.visited=true;
		boolean found = false;
		int steps = 0;
		while(!q.isEmpty())
		{
			Node n=(Node)q.remove();
			Node child=null;
			while((child=getUnvisitedChildNode(n))!=null)
			{
				child.visited=true;
				q.add(child);
				if (child.equals(destination)) {
					found = true;
					break;
				}
			}
			steps++;
			if (found) {
				break;
			}
		}
		//Clear visited property of nodes
		clearNodes();
		if (found == false) {
			return -1;
		}
		else {
			return (steps * 6);
		}
	}
	
	//BFS traversal of a tree is performed by the bfs() function
	public int getCutCount(Node start)
	{
		
		int count  = 0;
		//BFS uses Queue data structure
		Queue q=new LinkedList();
		q.add(start);
		start.visited=true;
		boolean found = false;
		int steps = 0;
		while(!q.isEmpty())
		{
			Node n=(Node)q.remove();
			Node child=null;
			int childrenCount = 0;
			while((child=getUnvisitedChildNode(n))!=null)
			{
				child.visited=true;
				q.add(child);
				childrenCount++;
			}
			if (!(childrenCount % 2 == 0)) {
				count++;
			}
		}
		//Clear visited property of nodes
		clearNodes();
		
		return count -1;
}	
	
	//DFS traversal of a tree is performed by the dfs() function
	public void dfs()
	{
		//DFS uses Stack data structure
		Stack s=new Stack();
		s.push(this.rootNode);
		rootNode.visited=true;
		printNode(rootNode);
		while(!s.isEmpty())
		{
			Node n=(Node)s.peek();
			Node child=getUnvisitedChildNode(n);
			if(child!=null)
			{
				child.visited=true;
				printNode(child);
				s.push(child);
			}
			else
			{
				s.pop();
			}
		}
		//Clear visited property of nodes
		clearNodes();
	}	
	
	//Utility methods for clearing visited property of node
	private void clearNodes()
	{
		int i=0;
		while(i<size)
		{
			Node n=(Node)nodes.get(i);
			n.visited=false;
			i++;
		}
	}
	
	//Utility methods for printing the node's label
	private void printNode(Node n)
	{
		System.out.print(n.label+" ");
	}	
}

public class HR_GraphTheory {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	System.out.println("Set up nodes");
    	Node n1 = new Node('A');
    	Node n2 = new Node('B');
    	Node n3 = new Node('C');
    	Node n4 = new Node('D');
    	Node n5 = new Node('E');
    	Node n6 = new Node('F');
    	
    	//Setup the graph
    	Graph graph = new Graph();
    	graph.addNode(n1);
    	graph.setRootNode(n1);
    	graph.addNode(n2);
    	graph.addNode(n3);
    	graph.addNode(n4);
    	graph.addNode(n5);
    	graph.addNode(n6);
    	
    	//Connect the nodes
    	graph.connectNode(n1, n2);
    	graph.connectNode(n1, n3);
    	graph.connectNode(n1, n4);
    	graph.connectNode(n2, n5);
    	graph.connectNode(n2, n6);
    	graph.connectNode(n3, n6);
    	
    	int steps = graph.bfs(n1, n5);
    	System.out.println(steps);
    }
  
}