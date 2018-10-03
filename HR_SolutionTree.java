import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TNode {
	int data;
	TNode left;
	TNode right;
}

public class HR_SolutionTree {

	
	TNode findNode(TNode root, int value) {
	  if (root == null) {
		    return null;
		  }

		  if (root.data == value) {
		    return root;
		  }

		  TNode found = null;
		  if (root.left != null) {
		    found = findNode(root.left, value);
		    if (found != null) {
		      return found;
		    }
		  }

		  if (root.right != null) {
		    found = findNode(root.right, value);
		    if (found != null) {
		      return found;
		    }
		  }
		  return null;
	}
	
	void Preorder(TNode root) {
		System.out.print(root.data + " ");
		if (root.left != null) {
			Preorder(root.left);
		}
		if (root.right != null) {
			Preorder(root.right);
		}
	}	
	
	void Postorder(TNode root) {
		
		if (root.left != null) {
			Preorder(root.left);
		}
		if (root.right != null) {
			Preorder(root.right);
		}
		System.out.print(root.data + " ");
	}
	
	void Postorder(TNode root, ArrayList<Integer> array) {
		
		if (root.left != null) {
			Postorder(root.left, array);
		}
		if (root.right != null) {
			Postorder(root.right, array);
		}
		//System.out.print(root.data + " ");
		array.add(root.data);
	}	
	
	void Inorder(TNode root) {
		if (root.left != null) {
			Inorder(root.left);
		}
		System.out.print(root.data + " ");
		if (root.right != null) {
			Inorder(root.right);
		}
	}
	
	void Inorder(TNode root, ArrayList<Integer> array) {
		if (root.left != null) {
			Inorder(root.left, array);
		}
		//System.out.print(root.data + " ");
		array.add(root.data);
		if (root.right != null) {
			Inorder(root.right, array);
		}
	}	
	
	int height(TNode root)
	{
		if(root==null)return 0;
		return (1+ Math.max(height(root.left),height(root.right)));
	}	
	
	private void keepLeft(TNode root) {
		if(root==null)return;
		
		keepLeft(root.left);
		System.out.print(root.data + " ");
	}
	
	private void keepRight(TNode root) {
		if(root==null)return;
        
        System.out.print(root.data + " ");
		keepRight(root.right);
	}	
	
	void top_view(TNode root)
	{
		if(root==null)return;
		keepLeft(root.left);
		System.out.print(root.data + " ");
		keepRight(root.right);
	}
	
	void LevelOrder(TNode root)
	{
		//Create empty queue and pust root node to it.
		Queue<TNode> queue = new LinkedList<TNode>();
		queue.add(root);
		//Do the following when queue is not empty
		while(!(queue.isEmpty())) {
			//Pop a node from queue and print it
			TNode temp = queue.poll();
			System.out.print(temp.data + " ");
			//Push left child of popped node to queue if not null
			if (temp.left != null) {
				queue.add(temp.left);
			}
			//Push right child of popped node to queue if not null
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	TNode InsertPreorder(TNode root,int value)
    {
        if (root==null){ 
        	TNode node=new TNode(); 
            node.data=value; 
            return node;
        }

        if (root.data > value) {
            
                root.left = InsertPreorder(root.left, value);
        }
        else  {
            
                root.right = InsertPreorder(root.right, value);
        }

        return root;
       
    }
	
	TNode lca(TNode root,int v1,int v2)
	{
	    ArrayList<Integer> inorder = new ArrayList<Integer>();
	    ArrayList<Integer> postorder = new ArrayList<Integer>();
	    Inorder(root, inorder);
	    Postorder(root, postorder);
	    
	    int start = inorder.indexOf(v1);
	    int end = inorder.indexOf(v2);
    
        List<Integer> subArray = null;
        if (start+1 == end) {
            subArray = inorder.subList(start, end);
        }
        else if (start < end) {
            subArray = inorder.subList(start + 1, end);
        }
        else {
            subArray = inorder.subList(end + 1, start);
        }
	    
	    //List<Integer> subArray = inorder.subList(inorder.indexOf(v1) + 1, inorder.indexOf(v2));
	    
        int highest = 0;
	    for (int i: subArray) {
            int pos = postorder.indexOf(i);
            if (pos > highest) {
                highest = pos;
            }
	    }
        TNode result = findNode(root, postorder.get(highest));
        
        //System.out.println(result.data);
	    
	    return result;      
	}	

}
