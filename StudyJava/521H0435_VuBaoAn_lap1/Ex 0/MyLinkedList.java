import java.util.*;

public class MyLinkedList <E> implements ListInterface<E> {
    private Node<E> head;
    private int numNode;
    public MyLinkedList(){
        this.head = null;
        this.numNode = 0;
    }

    public void addFirst(E item){
        head = new Node<E>(item, head);
        numNode++;
    }

    public void addAfter(Node<E> curr, E item){
        if(curr == null) {
            addFirst(item);
        }
        else{
            Node<E> newNode = new Node<E>(item, curr.getNext());
            curr.setNext(newNode);
        }
        numNode++;
    }

    public void addLast(E item) {
        if(head==null) {
            addFirst(item);
        }
        else {
            Node<E> tmp = head;
            while(tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            Node<E> newNode = new Node<E>(item, null);
            tmp.setNext(newNode);
            numNode++;
        }
    }

    public E removeFirst() throws NoSuchElementException {
        if(head == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");
        }
        else {
            Node<E> tmp = head;
            head = head.getNext();
            numNode--;
            return tmp.getData();
        }
    }

    public E removeAfter(Node<E> curr) throws NoSuchElementException {
        if(curr == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");
        }
        Node<E> delNode = curr.getNext();
        if(delNode==null) 
            throw new NoSuchElementException("No next node to remove");
        
        curr.setNext(delNode.getNext());
        numNode--;
        return delNode.getData();     
    }
    

    public E removeLast() throws NoSuchElementException{
        if(head==null){
            throw new NoSuchElementException("Can't remove element from an empty list");
        }
        else {
            Node<E> preNode = null;
            Node<E> delNode = head;
            while(delNode.getNext()!=null){
                preNode = delNode;
                delNode = delNode.getNext();
            }
            preNode.setNext(null);
            //delNode.setNext(null);
            numNode--;
            return delNode.getData();
        }
    }

    public void print(){
        if(head != null) {
            Node<E> tmp = head;
            System.out.print("List: "+ tmp.getData());
            tmp = tmp.getNext();
            while( tmp!=null) {
                System.out.print(" -> "+tmp.getData());
                tmp  =tmp.getNext();
            }
            System.out.println();
        }
        else{
            System.out.println("List is empty!");
        }
    }

    public boolean isEmpty(){
        if(numNode==0) return true;
        return false;
    }

    public Node<E> gethead() throws NoSuchElementException {
        if(head==null) 
            throw new NoSuchElementException("Can't get element from an empty list");
        return head;
    }
    public E getFirst() throws NoSuchElementException {
        if(head==null) 
            throw new NoSuchElementException("Can't get element from an empty list");
        return head.getData();
    }

    public int size(){
        return numNode;
    }

    public boolean contains(E item){
        Node<E> tmp = head;
        while(tmp != null)
        {
            if(tmp.getData().equals(item))
                return true;
            tmp.getNext();
        }
        return false;
    }
}
