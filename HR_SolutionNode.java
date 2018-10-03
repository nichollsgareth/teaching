
class _Node {
	int data;
	_Node next;
}

public class HR_SolutionNode {
	
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
}
