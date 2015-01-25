//This file has circular linked list implementation and its functions.

package linkedlist;

//Class for circular node
class NodeCircular{
	String name;
	int number;
	NodeCircular next;
	NodeCircular previous;
	public NodeCircular(String name, int number){
		this.name = name;
		this.number = number;
		this.next = null;
		this.previous = null;
	}
}

//Class of circular linked list and its functions
class CircularLinkedList{
	NodeCircular head;
	public CircularLinkedList() {
		// TODO Auto-generated constructor stub
	}
	public CircularLinkedList(NodeCircular head){
		this.head = head;
	}
	public NodeCircular createCircularNode(String name, int number){
		return new NodeCircular(name, number);
	}
	//add the circular node at front of the list
	public void addFront(NodeCircular circularNode, CircularLinkedList circularLinkedList){
		if(circularLinkedList.head == null){
			circularNode.next = circularNode;
			circularNode.previous = circularNode;
			circularLinkedList.head = circularNode;
		}else{
			NodeCircular tail = circularLinkedList.head;
			while(tail.next!=circularLinkedList.head){
				tail = tail.next;
			} 
			circularNode.next = circularLinkedList.head;
			circularLinkedList.head.previous = circularNode;
			circularLinkedList.head = circularNode;
			tail.next = circularNode;
			circularNode.previous = tail;
		}
	}
	//add the circular node at back of the list
	public void addBack(NodeCircular circularNode, CircularLinkedList circularLinkedList){
		if(circularLinkedList.head == null){
			addFront(circularNode, circularLinkedList);
		}else{
			NodeCircular tail = circularLinkedList.head;
			while(tail.next!=circularLinkedList.head){
				tail = tail.next;
			}
			tail.next = circularNode;
			circularNode.previous = tail;
			circularNode.next = circularLinkedList.head;
			circularLinkedList.head.previous = circularNode;
		}
	}
	//remove the circular node from front of the list
	public void removeFront(CircularLinkedList circularLinkedList){
		if(circularLinkedList.head!=null){
			NodeCircular tail = circularLinkedList.head;
			while(tail.next!=circularLinkedList.head){
				tail = tail.next;
			}
			//NodeCircular temp = circularLinkedList.head;
			circularLinkedList.head = circularLinkedList.head.next;
			tail.next = circularLinkedList.head;
			circularLinkedList.head.previous = tail;
			//temp = null;
		}
	}
	//remove the circular node from back of the list
	public void removeBack(CircularLinkedList circularLinkedList){
		if(circularLinkedList.head!=null){
			NodeCircular tail = circularLinkedList.head;
			NodeCircular tailBeforeNode = null;
			while(tail.next!=circularLinkedList.head){
				tailBeforeNode = tail;
				tail = tail.next;
			}
			tailBeforeNode.next = circularLinkedList.head;
			circularLinkedList.head.previous = tailBeforeNode;
			tail = null;
		}
	}
	//this method return the size of the circular linked list
	public int sizeOfCircularLinkedList(CircularLinkedList circularLinkedList){
		int size;
		NodeCircular temp = circularLinkedList.head;
		if(temp==null){
			size = 0;
		}else{
			size = 1;	//for the head node
			while(temp.next!=circularLinkedList.head){
				temp = temp.next;
				size++;	//for remaining nodes
			}
		}
		return size;
	}
}
public class CircularLinkedListJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList circularLinkedList = new CircularLinkedList();
		NodeCircular circularNode = circularLinkedList.createCircularNode("five", 5);
		circularLinkedList.addFront(circularNode, circularLinkedList);
		circularNode = circularLinkedList.createCircularNode("four", 4);
		circularLinkedList.addFront(circularNode, circularLinkedList);
		circularNode = circularLinkedList.createCircularNode("three", 3);
		circularLinkedList.addFront(circularNode, circularLinkedList);
		//System.out.println(circularLinkedList.sizeOfCircularLinkedList(circularLinkedList));
		circularNode = circularLinkedList.createCircularNode("six", 6);
		circularLinkedList.addBack(circularNode, circularLinkedList);
		//System.out.println(circularLinkedList.sizeOfCircularLinkedList(circularLinkedList));
		circularNode = circularLinkedList.createCircularNode("seven", 7);
		circularLinkedList.addBack(circularNode, circularLinkedList);
		circularLinkedList.removeFront(circularLinkedList);
		circularLinkedList.removeBack(circularLinkedList);
		printCircularLinkedList(circularLinkedList);
		System.out.println("Size of linked list:"+circularLinkedList.sizeOfCircularLinkedList(circularLinkedList));
	}
	//this method print the elements in the circular linked list
	private static void printCircularLinkedList(CircularLinkedList circularLinkedList){
		NodeCircular temp = circularLinkedList.head;
		if(temp!=null){
			while(temp.next!=circularLinkedList.head){
				System.out.println("Name:"+temp.name+" Number:"+temp.number);
				temp = temp.next;
			}
			System.out.println("Name:"+temp.name+" Number:"+temp.number);
		}else
			System.out.println("Empty list");
	}
}
