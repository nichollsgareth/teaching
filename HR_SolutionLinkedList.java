import java.util.HashSet;
import java.util.Set;

class _Node {
	int data;
	_Node next;
	_Node prev;
}

public class HR_SolutionLinkedList {
	
	void Print(_Node head) {
		
	    _Node currNode = head;
	    while(currNode != null) {
	    	System.out.println(currNode.data);
	    	currNode = currNode.next;
	    }
	}	
	
	_Node Delete(_Node head, int position) {
	    // Complete this method
	    int p = 1;
	    _Node prevNode = null;
	    _Node currNode = head;
	    _Node nextNode = head.next;
	    while (p <= position) {
	        prevNode = currNode;
	        currNode = nextNode;
	        nextNode = nextNode.next;
	        p++;
	    }
	    //If we are essentially deleting the head
	    if (prevNode == null) {
	        currNode.next = null;
	        return nextNode;
	    }
	    else {
	        prevNode.next = nextNode;
	        currNode.next = null;
	    }
	    return head;
	}
	
	_Node RemoveDuplicates(_Node head) {
		  // This is a "method-only" submission. 
		  // You only need to complete this method.
		    
		    Set<Integer> set = new HashSet<Integer>();
		    
		    _Node currentNode = head;

		    _Node listHead = new _Node();
		    listHead.data = head.data;
		    _Node newList = listHead;

		    do {
		        if (currentNode.data > 0) {
		            set.add(currentNode.data);
		        }
		    }while ((currentNode = currentNode.next) != null);

		    for (Integer i: set) {
		        _Node n = new _Node();
		        n.data = i;
		        newList.next = n;
		        newList = n;
		    }
		    
		    return listHead;
		}	
	
	_Node InsertNth(_Node head, int data, int position) {
		   // This is a "method-only" submission. 
		    // You only need to complete this method. 
		    
		    _Node newNode = new _Node();
		    newNode.data = data;
		    //insert at head if position is 0
		    if (position == 0) {
		        newNode.next = head;
		        return newNode;
		    }
		    
		    _Node currNode = head;
		    int p = 0;
		    while (p < position - 1) {
		        currNode = currNode.next;
		        p++;
		    }
		    _Node nextNode = currNode.next;
		    if (nextNode == null) {
		        currNode.next = newNode;
		    }
		    else {
		        newNode.next = nextNode;
		        currNode.next = newNode;
		    }
		    return head;
		}	
	
	_Node Reverse(_Node head) {
	    _Node reversedPart = null;
	    _Node current = head;
	    while (current != null) {
	        _Node next = current.next;
	        current.next = reversedPart;
	        reversedPart = current;
	        current = next;
	    }
	    head = reversedPart;
	    return head;
	}
	
	_Node ReverseDbl(_Node head) {
	    
	    if ((head != null) && (head.next != null)) {
	 
	        //Node reversedPart = null;
	    	_Node current = head;
		    while (current != null) {
		    	_Node next = current.next;
	            //we have reached the end
	            if (next == null) {
	                current.next = current.prev;
	                break;
	            }
		        current.next = current.prev;
	            current.prev = next;
	            current = next;
		    }
		    head = current;
	    }

		return head;
	}	
	
	_Node MergeLists(_Node headA, _Node headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method
	    if (headA == null) return headB;
	    if (headB == null) return headA;
	    
	    if (headA.data < headB.data) {
	        headA.next =  MergeLists(headA.next, headB);
	        return headA;
	    }
	    else {
	        headB.next =  MergeLists(headB.next, headA);
	        return headB;        
	    }
	}
	
	int HasCycle(_Node head) {
	    //Use Flyods algorithm
	    if (head == null) {
	        return 0;
	    }
	    _Node nodeA = head;
	    _Node nodeB = head;
	    
	    boolean isLoop = false;
	    while (((nodeA = nodeA.next) != null) && (nodeB = nodeB.next) !=null) {
	        //System.out.println("In loop " + nodeA + " "+ nodeB);
	        if ((nodeA == null) || (nodeB == null)) {
	            isLoop = false;
	            break;
	        }
	        nodeB = nodeB.next;
	        if (nodeB == null) {
	            isLoop = false;
	            break;
	        }
	        if (nodeA.equals(nodeB)) {
	            isLoop = true;
	            break;
	        }
	    }
	    
	    if (isLoop) {
	        return 1;
	    }
	    else {
	        return 0;
	    }
	}
	
	int FindMergeNode(_Node headA, _Node headB) {
	    // Complete this function
	    // Do not write the main method.
		_Node currentA = headA;
		_Node currentB = headB;
	    
	    //Do till the two nodes are the same
	    while(currentA != currentB){
	        //System.out.println(currentA.data + " compare " + currentB.data);
	        //If you reached the end of one list start at the beginning of the other one
	        //currentA
	        if(currentA.next == null){
	            currentA = headB;
	        }else{
	            currentA = currentA.next;
	        }
	        //currentB
	        if(currentB.next == null){
	            currentB = headA;
	        }else{
	            currentB = currentB.next;
	        }
	    }
	    return currentB.data;
	}	
	
	_Node SortedInsert(_Node head,int data) {
	    //System.out.println("Inserting: " + data);
		_Node currentNode = head;
		_Node newNode = new _Node();
	    newNode.data = data;
	    if ((head.data == 0) && (head.prev == null) && (head.next == null)) {
	        head = newNode;
	        return head;
	    }
        else if(data <= head.data) {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev = newNode;
        }
        else {
            while(true) {
                if (data <= currentNode.data) {
                    //System.out.println("Insert " + data);
                	_Node prevNode = currentNode.prev;
                    
                    newNode.prev = currentNode.prev;
                    newNode.next = currentNode;
                    currentNode.prev = newNode;
                    prevNode.next = newNode;
                    
                    break;
                }
                if (currentNode.next == null) {
                    currentNode.next = newNode;
                    newNode.prev = currentNode;
                    break;
                }
                currentNode = currentNode.next;
            }
        }

	    //traverse back to the head
	    while(currentNode.prev != null) {
	        head = currentNode.prev;
	        currentNode = currentNode.prev;
	    }
	    //printMe(head);
	    return head;
	}	
}
