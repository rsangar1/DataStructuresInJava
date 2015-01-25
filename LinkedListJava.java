//This file contains linked list implementation and some of the functions. Please check the comments to understand better.

package cci.linkedlist;

import cci.linkedlist.LinkedList;
import cci.linkedlist.Node;

//Node or element of linked list with two data variables, one string variable and one int variable
class Node{
	int number;
	Node next;
	public Node(int number){
		this.number = number;
		next = null;
	}
}
// Linked list and its implementation methods
class LinkedList {
	Node head;
	public LinkedList(){}
	public LinkedList(Node head){
		this.head = head;
	}
	//create a node
	public Node createNode(int number){
		return new Node(number);
	}
	//add a node to the end of linked list
	public void addNodeLast(Node node, LinkedList linkedList){
		Node temp;
		temp = linkedList.head;
		if(temp!=null){
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = node;
		}else
			addNodeFirst(node, linkedList);
	}
	//add node at beginning of linked list
	public void addNodeFirst(Node node, LinkedList linkedList){
		Node temp = linkedList.head;
		node.next = temp;
		linkedList.head = node;
	}
	//add a node at a given position. Assuming position is valid.
	//if size of list is less than given position, then node is added at last.
	public void addNodeAtPosition(int position, Node node, LinkedList linkedList){
		int size = 1;
		Node temp = null;
		for(temp = linkedList.head;temp.next!=null;temp=temp.next){
			size++;
		}
		if(position == 1){
			addNodeFirst(node, linkedList);
		}else if(position > size){
			addNodeLast(node, linkedList);
		}else{
			Node nextTemp;
			temp = linkedList.head;
			for(int i=1;i<position-1;i++){
				temp = temp.next;
			}
			nextTemp = temp.next;
			temp.next = node;
			node.next = nextTemp;
		}
	}
	//remove first node of list
	public void removeFront(LinkedList linkedList){
		//Node temp;
		//temp = ll.head;
		if(linkedList!=null){
			if(linkedList.head.next!=null)
				linkedList.head = linkedList.head.next;
			else
				linkedList.head = null;
		}
		//linkedList.head = linkedList.head.next;
		//temp = null;
	}
	//remove last node in the list
	public void removeLast(LinkedList linkedList){
		Node temp = linkedList.head;
		Node lastBeforeNode = null;
		if(temp!=null){
			if(temp.next!=null){
				for(temp=linkedList.head;temp.next!=null;temp=temp.next){
					lastBeforeNode = temp;
				}
				lastBeforeNode.next = null;
			}else
				temp = null;
		}
	}
	//remove the node present at given position in the list.
	//if given position is more than size of list, last element is removed
	public void removeNodeAtPosition(int position, LinkedList linkedList){
		Node temp = null;
		
		int size = 1;
		for(temp = linkedList.head;temp.next!=null;temp=temp.next){
			size++;
		}
		if(position == 1){
			removeFront(linkedList);
		}else if(position>size){
			removeLast(linkedList);
		}else{
			Node tempPrevious = null;
			temp = linkedList.head;
			for(int i=1;i<position;i++){
				tempPrevious = temp;
				temp = temp.next;
				
			}
			tempPrevious.next = temp.next;
			//temp = null;
		}
	}
	//reverse the nodes in linkedlist
	public void reverseLinkedList(LinkedList linkedList){
		Node temp1 = linkedList.head;
		Node temp2 = null;
		Node result = null;
		while(temp1!=null){
			temp2 = temp1.next;
			temp1.next = result;
			result = temp1;
			temp1 = temp2;
		}
		//linkedList.head.next = null;
		linkedList.head = result;
	}
	//this method return size of the linked list
	public int size(LinkedList linkedList){
		int size = 0;
		if(linkedList.head!=null){
			size = 1;
			for(Node temp=linkedList.head;temp.next!=null;temp=temp.next){
				size++;
			}
		}
		return size;
	}
	//method to delete entire linked list
	public void deleteLinkedList(LinkedList linkedList){
		linkedList.head = null;
		System.out.println("list deleted");
	}
	//code to remove duplicates from an unsorted linked list.
	public void removeDuplicateNodes(LinkedList linkedList){
		Node temp1 = linkedList.head;
		Node runner = null;
		Node previousNode = null;
		boolean repeated;
		int size = linkedList.size(linkedList);
		if(temp1==null)
			return;
		else if(size<2)
			return;
		else{
			for(temp1=linkedList.head;temp1.next!=null;temp1=temp1.next){
				repeated = false;
				for(runner = linkedList.head;runner!=temp1;runner=runner.next){
					if(temp1.number==runner.number){
						repeated = true;
						break;
					}
				}
				if(repeated){
					previousNode.next = temp1.next;
					continue;
				}
				previousNode = temp1;
			}
			for(runner = linkedList.head;runner!=temp1;runner=runner.next){
				if(temp1.number==runner.number){
					previousNode.next=temp1.next;
					break;
				}
			}
		}	
		/*Node previousNode = null;
		int size = linkedList.size(linkedList);
		if(temp1==null)
			return;
		else if(size<2)
			return;
		else{
			LinkedList tempList = new LinkedList();
			for(temp1=linkedList.head;temp1.next.next!=null;temp1=temp1.next){
				for(temp2=temp1.next;temp2.next!=null;temp2=temp2.next){
					if(temp1.number == temp2.number)
						continue;
					else{
						Node node = temp2;
						tempList.addNodeLast(temp2, tempList);
						temp2 = node;
					}
				}
			}
			tempList.addNodeFirst(linkedList.head, tempList);
			linkedList = tempList;
		}*/
		
	}
	//Implement an algorithm to find the nth to last element of a singly linked list
	public Node nthToLastNode(int n,LinkedList linkedList){
		int size = linkedList.size(linkedList);
		Node node = linkedList.head;
		if(node!=null&&size>=n){
			for(int i=0;i<size-n;i++){
				node = node.next;
			}
			//return node;
		}else
			node = null;
		return node;
	}
	//Implement an algorithm to delete a node in the middle of a single linked list, 
	//given only access to that node.
	public boolean removeNode(Node node){
		if(node==null||node.next==null)
			return false;
		Node next = node.next;
		node.number = next.number;
		node.next = next.next;
		return true;
	}
	//method to print data in given linked list
	public void printLinkedList(LinkedList linkedList) {
		Node temp;
		if(linkedList.head!=null){
			for(temp=linkedList.head;temp!=null;temp=temp.next){
				System.out.println("Number:"+temp.number);
			}
			//System.out.println("Number:"+temp.number);
		} else
			System.out.println("List is empty");
	}
}

public class LinkedListJava{
	public static void main(String ar[]){
		Node head = new Node(5);
		LinkedList linkedList = new LinkedList(head);
		Node newNode = new Node(6);
		linkedList.addNodeLast(newNode, linkedList);
		newNode = new Node(4);
		linkedList.addNodeFirst(newNode, linkedList);
		newNode = new Node(3);
		linkedList.addNodeFirst(newNode, linkedList);
		newNode = new Node(8);
		linkedList.addNodeLast(newNode, linkedList);
		linkedList.addNodeAtPosition(5, new Node(5), linkedList);
		linkedList.addNodeAtPosition(7, new Node(6), linkedList);
		linkedList.addNodeAtPosition(10, new Node(10), linkedList);
		linkedList.addNodeLast(new Node(4), linkedList);
		linkedList.removeFront(linkedList);
		//ll.removeLast(ll);
		linkedList.removeNodeAtPosition(1, linkedList);
		linkedList.removeLast(linkedList);
		linkedList.printLinkedList(linkedList);
		
		//cci 2.2 and 2.3
		/*System.out.println("After removing duplicates:");
		linkedList.removeDuplicateNodes(linkedList);
		linkedList.printLinkedList(linkedList);
		System.out.println("Size of Linked list:"+linkedList.size(linkedList));
		System.out.println("4th node from last:"+linkedList.nthToLastNode(4, linkedList).number);
		linkedList.removeNode(linkedList.nthToLastNode(3, linkedList));
		linkedList.printLinkedList(linkedList);*/
		
		
		LinkedList list1 = new LinkedList();
		list1.addNodeLast(new Node(3), list1);
		list1.addNodeLast(new Node(1), list1);
		list1.addNodeLast(new Node(5), list1);
		System.out.println("List1:");
		list1.printLinkedList(list1);
		LinkedList list2 = new LinkedList();
		list2.addNodeLast(new Node(5), list2);
		list2.addNodeLast(new Node(9), list2);
		list2.addNodeLast(new Node(2), list2);
		System.out.println("List2:");
		list1.printLinkedList(list2);
		LinkedList resultList = addLinkedLists(list1,list2);
		System.out.println("Result:");
		resultList.printLinkedList(resultList);
		
		//cci 2.5
		resultList.addNodeLast(new Node(5), resultList);
		resultList.addNodeLast(new Node(9), resultList);
		Node repeatNode = resultList.nthToLastNode(3, resultList);
		Node temp;
		for(temp=resultList.head;temp.next!=null;temp=temp.next){}
		temp.next = repeatNode;
		repeatNode = findLoopBeginning(resultList);
		//resultList.printLinkedList(resultList);
		System.out.println("Loop is beginning at node"+repeatNode.number);
		//LinkedList list2 = new LinkedList();
		//list2.addNodeFirst(head, list2);
		//printLinkedList(list2);
		//linkedList.reverseLinkedList(linkedList);
		//linkedList.printLinkedList(linkedList);
		//linkedList.deleteLinkedList(linkedList);
		//linkedList.printLinkedList(linkedList);
		//System.out.println("Size of Linked list:"+linkedList.size(linkedList));
		//System.out.println("Size of Linked list:"+linkedList.size(list2));
	}
	
	/*Given a circular linked list, implement an algorithm which returns node at the
	 *  beginning of the loop.
	 *  DEFINITION
	 *  Circular linked list: A (corrupt) linked list in which a node’s next pointer 
	 *  points to an earlier node, so as to make a loop in the linked list.
	 *  EXAMPLE
	 *  input: A -> B -> C -> D -> E -> C [the same C as earlier]
	 *  output: C */
	private static Node findLoopBeginning(LinkedList resultList) {
		Node temp1=resultList.head;//faster
		Node temp2=resultList.head;//slower
		while(temp1.next!=null){
			temp1 = temp1.next.next;
			temp2 = temp2.next;
			if(temp1==temp2)
				break;
		}
		temp1=resultList.head;
		while(temp1!=temp2){
			temp1=temp1.next;
			temp2=temp2.next;
		}
		return temp2;
	}
	
	/*You have two numbers represented by a linked list, where each node contains a 
	 * single digit. The digits are stored in reverse order, such that the 1’s digit
	 * is at the head of the list. Write a function that adds the two numbers and 
	 * returns the sum as a linked list.
	 * EXAMPLE
	 * Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
	 * Output: 8 -> 0 -> 8*/
	private static LinkedList addLinkedLists(LinkedList list1, LinkedList list2) {
		int sum1=0, sum2=0, result=0, i=0;
		for(Node temp1=list1.head;temp1!=null;temp1=temp1.next){
			sum1 += (temp1.number)*power(10,i);
			i++;
		}
		System.out.println(sum1);
		i=0;
		for(Node temp1=list2.head;temp1!=null;temp1=temp1.next){
			sum2 += (temp1.number)*power(10,i);
			i++;
		}
		System.out.println(sum2);
		result = sum1 + sum2;
		LinkedList resultList = new LinkedList();
		while(result!=0){
			resultList.addNodeLast(new Node(result%10), resultList);
			result = result/10;
		}
		return resultList;
	}
	
  //this method return the power
	private static int power(int ten, int i) {
		int power = 1;
		while(i!=0){
			power = power*10;
			i--;
		}
		return power;
	}
}
