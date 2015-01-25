//This file has double linked list implementation with its functions

package linkedlist;

//Node for a double linked list
class NodeDouble{
	String name;
	int number;
	NodeDouble next;
	NodeDouble previous;
	public NodeDouble(String name, int number){
		this.name = name;
		this.number = number;
		next = null;
		previous = null;
	}
}
//Double linked list and its implementation methods
class DoubleLinkedList{
	NodeDouble head;
	public DoubleLinkedList(){}
	public DoubleLinkedList(NodeDouble head){
		this.head = head;
	}
	//return NodeDouble created using the name and number attributes
	public NodeDouble createDoubleNode(String name, int number){
		return new NodeDouble(name,number);
	}
	//this methods adds the node at beginning of double linked list
	public void addFront(NodeDouble node, DoubleLinkedList doubleLinkedList){
		NodeDouble temp = doubleLinkedList.head;
		node.next = temp;
		if(temp!=null)
			temp.previous = node;
		doubleLinkedList.head = node;
	}
	//this methods adds the node at the end of double linked list
	public void addLast(NodeDouble node, DoubleLinkedList doubleLinkedList){
		NodeDouble temp = doubleLinkedList.head;
		if(temp!=null){
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = node;
			node.previous = temp;
		}else
			addFront(node, doubleLinkedList);
	}
	//this methods removed the node from beginning of double linked list
	public void removeFront(DoubleLinkedList doubleLinkedList){
		NodeDouble temp = doubleLinkedList.head;
		if(temp!=null){
			if(temp.next!=null){
				doubleLinkedList.head = temp.next;
				temp.next.previous = null;
				temp.next = null;
			}else{
				doubleLinkedList.head = null;
			}
		}
	}
	//this methods removes the node from end of double linked list
	public void removeLast(DoubleLinkedList doubleLinkedList){
		NodeDouble temp = doubleLinkedList.head;
		if(temp!=null){
			if(temp.next!=null){
				NodeDouble lastBeforeNode = null;
				for(;temp.next!=null;temp=temp.next){
					lastBeforeNode = temp;
				}
				lastBeforeNode.next = null;
			}else
				temp = null;
		}
	}
}

public class DoubleLinkedListJava {
	public static void main(String[] args) {
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		NodeDouble node = doubleLinkedList.createDoubleNode("five", 5);
		doubleLinkedList.addFront(node, doubleLinkedList);
		node = doubleLinkedList.createDoubleNode("four", 4);
		doubleLinkedList.addFront(node, doubleLinkedList);
		node = doubleLinkedList.createDoubleNode("six", 6);
		doubleLinkedList.addLast(node, doubleLinkedList);
		doubleLinkedList.removeFront(doubleLinkedList);
		doubleLinkedList.removeLast(doubleLinkedList);
		printReverseLinkedList(doubleLinkedList);
	}
	//print the data in the linked list
	private static void printReverseLinkedList(DoubleLinkedList doubleLinkedList){
		if(doubleLinkedList.head!=null){
			NodeDouble temp=null;
			for(temp=doubleLinkedList.head;temp.next!=null;temp=temp.next){}
			while(temp.previous!=null){
				System.out.println("Name: "+temp.name+" Number:"+temp.number);
				temp = temp.previous;
			}
			System.out.println("Name: "+temp.name+" Number:"+temp.number);
		}else
			System.out.println("Empty list");
	}
}
