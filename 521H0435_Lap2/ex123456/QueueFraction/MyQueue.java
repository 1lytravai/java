import java.util.*;

public class MyQueue <E> implements QueueInterface <E>{
    private Node <E> front;
    private Node <E> rear;
    private int numNode;

    public MyQueue(){
        this.front = null;
        numNode = 0;
    }

    @Override
    public void enQueue(E item){
        Node <E> tmp = new Node<E>(item, null);
        if(numNode == 0) {
            front = tmp;
            rear = tmp;
        }
        else{
            rear.setNext(tmp);
            rear = rear.getNext();
        }
        numNode++;
    }

    @Override
    public E deQueue() throws NoSuchElementException {

        if(numNode == 0) throw new NoSuchElementException("Can't dequeue an empty queue");
        else{
            Node<E> tmp = front;
            front = front.getNext();
            numNode--;
            return tmp.getData();
        }
        
    }

    @Override
    public int size(){
        return numNode;
    }

    @Override
    public boolean contains(E item) throws NoSuchElementException{
        if(numNode == 0) throw new NoSuchElementException("Can't get data from empty queue");
        else{
            Node <E> tmp = front;
            while(tmp != null){
                if(tmp.getData().equals(item)){
                    return true;
                }
                tmp = tmp.getNext();
            } 
            return false;
        }
    }

    @Override
    public void print(){
        if(front != null){
            Node <E> tmp = front;
            System.out.print("Queue: " + tmp.getData());
            tmp = tmp.getNext();
            while(tmp != null){
                System.out.print(" -> " + tmp.getData());
                tmp = tmp.getNext();
            }
            System.out.println();
        }
        else
            System.out.println("Queue is empty!");
    }

    @Override
    public boolean isEmpty(){
        if(numNode == 0){
            return true;
        }
        return false;
    }

    @Override
    public E getFront(){
        return front.getData();
    }
}
