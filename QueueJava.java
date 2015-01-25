//This file contains implementation of Queue and its functions

package stackAndQueues;
//Node of a queue
class Node{
	int number;
	Node next;
	public Node(int number){
		this.number = number;
		next = null;
	}
}

//Queue and its implementation
class Queue{
	Node front;
	Node back;
	public Queue(){}
	public Queue(Node node){
		front = back = node;
	}
	//add element to the queue
	public void enqueue(Node node){
		if(front!=null&&back!=null){
			back.next = node;
			back = node;
		}else
			front = back = node;
	}
	//return the first element from the queue
	public Node dequeue(){
		Node temp = null;
		if(front!=null&&back!=null&&!front.equals(back)){
			temp = front;
			front = front.next;
		}else{
			temp = front;
			front = back = null;
		}
		return temp;
	}
	//print the elements in the queue
	public void printQueue(){
		Node temp = front;
		System.out.print("Queue: ");
		while(temp!=null){
			System.out.print(temp.number+" ");
			temp = temp.next;
		}
	}
	//return the first element in the queue
	public Node peekQueue(){
		return front;
	}
}

public class QueueJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue();
		queue.enqueue(new Node(1));
		queue.enqueue(new Node(2));
		queue.enqueue(new Node(3));
		Node tempNode;
		tempNode = queue.dequeue();
		if(tempNode!=null)
			System.out.println("DeQueued: "+tempNode.number);
		tempNode = queue.peekQueue();
		if(tempNode!=null)
			System.out.println("First node in queue: "+tempNode.number);
		queue.printQueue();
	}

}
