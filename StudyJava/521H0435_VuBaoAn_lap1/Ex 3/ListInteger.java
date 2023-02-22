import java.util.*;

public class ListInteger <E> implements ListInterface<E> {
    private Node<E> head;
    private int numNode;
    public ListInteger(){
        this.head = null;
        this.numNode = 0;
    }

    @Override
    public void addFirst(E item){
        head = new Node<E>(item, head);
        numNode++;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public int countEvenItem(){
        int count=0;
        Node<E> temp = head;
        while( temp!= null) {
            if((int)(temp.getData())%2==0)
                count++;
            temp =temp.getNext();
        }
        return count;
    }

    @Override
    public boolean checkPrime(int n){
        if(n<2) return false;
        int count =0;
        for(int i=2; i<n; i++){
            if(n%i==0) count++;
        }
        if(count==0) return true;
        return false;
    }

    @Override
    public int countPrimeItem(){
        int count =0;
        Node<E> temp = head;
        while(temp != null) {
            if( checkPrime((int)(temp.getData()))== true) 
                count ++;
            temp = temp.getNext();
        }
        return count;
    }

    @Override
    public void addX(E x) throws NoSuchElementException{
        if(head == null){
            throw new NoSuchElementException("Can't find even element");
        }
        else{
            Node <E> temp = head;
            while(temp!=null){
                if((int)temp.getData() % 2 == 0 ){
                    break;
                }
                else{
                    temp=temp.getNext();
                }
            }
            if(temp==null){
                throw new NoSuchElementException("Can't find even element");
            }
            Node <E> newNode = new Node <E> (x,temp.getNext());
            temp.setNext(newNode);
            numNode++;
        }
    }

    @Override
    public int findMax() throws NoSuchElementException{
        if(head == null){
            throw new NoSuchElementException("Can't find max element from an empty list");
        }
        else{
            Node <E> temp = head;
            int max = (int)temp.getData();
            while(temp!=null){
                if((int)temp.getData() > max ){
                    max = (int)temp.getData();
                }
                else{
                    temp=temp.getNext();
                }
            }
            return max;
        }
    }

    @Override
    public void reverse() throws NoSuchElementException{
        if(head == null){
            throw new NoSuchElementException("Can't reverse an empty list");
        }
        else{
            Node <E> next = null;
            Node <E> curr = head;
            Node <E> prev = null;

            while(curr != null){
                next = curr.getNext();
                curr.setNext(prev);
                prev = curr;
                curr = next;
            }

            head = prev;
        }
    }

    @Override
    public void bubbleSort() throws NoSuchElementException{
        if(head == null){
            throw new NoSuchElementException("Can't sort an empty list");
        }
        else{
            boolean waschanged;
            do{
                Node <E> curr = head;
                Node <E> prev = null;
                Node <E> next = head.getNext();
                waschanged = false;
                while (next != null){
                    if ((int)curr.getData()>(int)next.getData()){
                        waschanged = true;
                        if(prev != null){
                            Node <E> sign = next.getNext();
                            prev.setNext(next);
                            next.setNext(curr);
                            curr.setNext(sign);
                        }
                        else{
                            Node <E> sign = next.getNext();
                            head=next;
                            next.setNext(curr);
                            curr.setNext(sign);
                        }
                        prev = next;
                        next = curr.getNext();
                    }
                    else{
                        prev = curr;
                        curr = next;
                        next = next.getNext();
                    }
                }
            }while(waschanged);
        }
    }
}
