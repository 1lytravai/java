import java.util.*;
public class MyStack <E> implements StackInterface <E>{
	private Node <E> top;
	private int numNode;
	
	public MyStack() {
		this.numNode = 0;
		this.top = null;
	}
	
	public void push(E item) {
		if(top == null) {
			top = new Node <E>(item);
			numNode++;
		} else {
			Node <E> tmp = top;
			top = new Node <E>(item, tmp);
			numNode++;
		}
	}
	
	public E pop() {
		if(top==null) {
			throw new EmptyStackException();
		} 
			Node <E> temp = top.getNext();
			Node <E> result = top;
			top = new Node<E>(temp.getData(), temp.getNext());
			numNode--;
			return result.getData();
		
	}
	
	public int size() {
		return numNode;
	}
	
	public boolean contains(E item) {
		Node <E> temp = top;
		for(int i=0;i<numNode;i++) {
			if(temp.getData().equals(item)){
				return true;
			} else {
				temp =temp.getNext();
			}
		}
		return false;
	}
	
	@Override
	public void print() {
		if(top==null) {
			throw new EmptyStackException();}
		Node <E> temp = top;
		while(temp != null){
			System.out.print(" -> " + temp.getData());
			temp = temp.getNext();
		}
	}
	
	public boolean isEmpty() {
		return (numNode==0);
	}
	
	public E getPeek() {
		if(top==null) {
			throw new EmptyStackException();
		} 
		return top.getData();
	}
	
}