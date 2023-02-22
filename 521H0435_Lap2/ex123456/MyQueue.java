import java.util.*;
public class MyQueue<E> implements QueueInterface<E>{
    private Node<E> front;
    private Node<E> rear;
    private int numNode;

    public MyQueue(){
        this.front = null;
        this.rear = null;
        this.numNode = 0;
    }

    public void enQueue(E item) {
        Node<E> data = new Node<E>(item);
        if(this.numNode==0){
            front = data;
            rear = data;
        } else {
            rear.setNext(data);
            rear = rear.getNext();
        }
        this.numNode++;
    }

    public E deQueue(){
        if(this.numNode==0) throw new EmptyStackException();
        Node<E> newFront = this.front;
        this.front = this.front.getNext();
        this.numNode--;
        return newFront.getData();
    }

    public  int size() {
        return this.numNode;
    }

    public boolean contains(E item){
        Node<E> tmp = front;
        while(tmp!=null){
            if(tmp.getData().equals(item)){
                return true;
            }
            tmp.getNext();
        }
        return false;
    }

    public void print() {
        Node<E> tmp = this.front;
        System.out.print("Queue:");
        while(tmp!= null) {
            System.out.print(" -> " + tmp.getData());
            tmp = tmp.getNext();
        }
    }

    public boolean isEmpty(){
        if(this.front==null){
            return true;
        }
        return false;
    }

    public E getFront(){
        return this.front.getData();
    }
    
}
