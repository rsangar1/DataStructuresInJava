//This file has implementation of stack and more functions.

import java.util.ArrayList;

//Node of a stack
class Node{
	int number;
	Node next;
	public Node(int number){
		this.number = number;
		next = null;
	}
}

//Stack and its functions
class Stack{
	Node top;
	public Stack(){}
	public Stack(Node top){
		this.top = top;
	}
	//add a node to top of the stack
	public void push(Node node){
		if(top!=null){
			node.next = top;
			top = node;
		}else
			top = node;
	}
	//removes top element of stack and returns it
	public Node pop(){
		Node temp = top;
		if(top!=null){
			top = top.next;
		}
		return temp;
	}
	//return the top element of stack
	public Node peekStack(){
		return top;
	}
	//this method return size of the stack
	public int size(){
		int size = 0;
		for(Node temp=top;temp!=null;temp=temp.next){
			size++;
		}
		return size;
	}
	//pushes the element to its sorted position in the stack
	public void sortedPush(Node node){
		if(top == null){
			push(node);
		}
		else if(node!=null && node.number>top.number){
			push(node);
		}
		else{
			Node temp = top;
			while(temp!=null && temp.next!=null){
				if(node.number<temp.number){
					temp = temp.next;
				}else
					break;
			}
			node.next = temp.next;
			temp.next = node;
		}
	}

	/*Write a program to sort a stack in ascending order. You should not make any assumptions 
	 * about how the stack is implemented. The following are the only functions that should be
	 * used to write this program: push | pop | peek | isEmpty.*/
	public Stack sort(){
		Stack stack = new Stack();
		while(top!=null){
			stack.sortedPush(new Node(pop().number));
		}
		return stack;
	}
	
	//redefined method of sort
	public Stack sortRedefined(){
		Stack stack = new Stack();
		while(size()>0){
			Node temp = pop();
			while(stack.size()>0 && stack.peekStack().number > temp.number){
				push(new Node(stack.pop().number));
			}
			stack.push(new Node(temp.number));
		}
		return stack;
	}
	//this method print the elements of stack.
	public void printStack(){
		Node temp;
		temp = top;
		System.out.print("STACK: ");
		while(temp!=null){
			System.out.print(temp.number+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}

/* Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, 
 * in real life, we would likely start a new stack when the previous stack exceeds some threshold. 
 * Implement a data structure SetOfStacks that mimics this. 
 * SetOfStacks should be composed of several stacks, and should create a new stack once the previous
 * one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a 
 * single stack (that is, pop() should return the same values as it would if there were just a single stack).*/
class SetofStacks{
	int capacity;
	ArrayList<Stack> stacks;
	public SetofStacks(int capacity){
		stacks = new ArrayList<Stack>();
		this.capacity = capacity;
	}
	public void push(Node node){
		Stack stack = getCurrentStack();
		if(stack==null){
			stack = new Stack(node);
			stacks.add(stack);
		}
		else if(stack.size()==capacity){
			Stack newStack = new Stack();
			newStack.push(node);
			stacks.add(newStack);
		}else
			stack.push(node);
	}
	public Node pop(){
		Stack stack = getCurrentStack();
		System.out.println("size of current stack:"+stack.size());
		System.out.println("No of stacks before popping"+stacks.size());
		Node node = null;
		if(stack!=null){
			node = stack.pop();
			if(stack.size() == 0){
				stacks.remove(stacks.size()-1);
			}
		}
		System.out.println("No of stacks after popping"+stacks.size());
		return node;
	}
	public Node popAt(int index){
		Stack stack = stacks.get(index);
		Node node = null;
		if(stack!=null){
			node = stack.pop();
			if(stack.size() == 0){
				stacks.remove(stacks.size()-1);
			}
		}
		return node;
	}
	public Stack getCurrentStack() {
		if(stacks.isEmpty()){
			return null;
		}else
			return stacks.get(stacks.size()-1);
	}
}


//Implement a MyQueue class which implements a queue using two stacks.
class MyQueue{
	Stack stack1;
	Stack stack2;
	public MyQueue(){
		stack1 = new Stack();
		stack2 = new Stack();
		//stack2.top = stack1.top;
	}
	public void enqueue(Node node){
		stack1.push(node);
	}
	public Node dequeue(){
		Node node = null;
		if(stack2.top==null){
			while(stack1.size()>0){
				stack2.push(stack1.pop());
			}
		}
		node = stack2.pop();
		return node;
	}
	public Node peek(){
		Node node = null;
		if(stack2.top==null){
			while(stack1.size()>0){
				stack2.push(stack1.pop());
			}
		}
		node = stack2.peekStack();
		return node;
	}
}



public class StackJava {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(new Node(1));
		stack.push(new Node(2));
		stack.push(new Node(9));
		stack.push(new Node(7));
		stack.push(new Node(3));
		stack.push(new Node(5));
		Node tempNode;
		//System.out.println("Pooped "+stack.pop().number);
		//System.out.println("Pooped "+stack.pop().number);
		//System.out.println("Pooped "+stack.pop().number);
		stack.printStack();
		tempNode = stack.peekStack();
		if(tempNode!=null)
			System.out.println("Top of stack: "+stack.peekStack().number);
		else
			System.out.println("Empty stack");
		System.out.println("size of stack:"+stack.size());
		Stack sortedStack = stack.sortRedefined();
		System.out.println("After sorting");
		sortedStack.printStack();
		
		SetofStacks stacks = new SetofStacks(2);
		stacks.push(new Node(1));
		stacks.push(new Node(2));
		stacks.push(new Node(3));
		stacks.push(new Node(4));
		stacks.push(new Node(5));
		System.out.println("Popped "+stacks.pop().number);
		System.out.println("Popped "+stacks.pop().number);
		System.out.println("Popped "+stacks.popAt(0).number);
		MyQueue myQueue = new MyQueue();
		myQueue.enqueue(new Node(1));
		myQueue.enqueue(new Node(2));
		myQueue.enqueue(new Node(3));
		myQueue.enqueue(new Node(4));
		System.out.println("Removed from queue:"+myQueue.dequeue().number);
		System.out.println("Removed from queue:"+myQueue.dequeue().number);
		System.out.println("Peeked from queue:"+myQueue.peek().number);
	}
}
