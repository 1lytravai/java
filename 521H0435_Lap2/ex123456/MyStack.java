import java.util.*;
public class MyStack <E> implements StackInterface <E>{
	private Node <E> top;
	private int numNode;
	
	public MyStack() {
		this.numNode = 0;
		this.top = null;
	}
	
	public void push(E item) {
		if(this.top == null) {
			this.top = new Node <E>(item);
			numNode++;
		} else {
			Node <E> tmp = this.top;
			this.top = new Node <E>(item, tmp);
			numNode++;
		}
	}
	
	public E pop() {
		if(top==null) {
			throw new EmptyStackException();
		} 
		Node <E> result = top;
		top = top.getNext();
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
		System.out.print("Stack:");
		Node <E> temp = top;
		while(temp != null){
			System.out.print(" -> " + temp.getData());
			temp = temp.getNext();
		}
	}
	
	public boolean isEmpty() {
		if(this.top == null){
			return true;
		}
		return false;
	}
	
	public E getPeek() {
		if(this.top == null) {
			throw new EmptyStackException();
		} 
		return top.getData();
	}
	public double calculation(MyStack<Double> stack,int n) {
		stack.push( 3.0);
        for(int i=2; i<=n; i++) {
            stack.push(Math.pow(2, n)+ n*n);
        }
        double result=0;
        while(stack.isEmpty()!=true){
            	result+=stack.pop();
        }
        return result;
    }
}