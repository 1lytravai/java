public class Node <E> {
    //Define your Attributes
    private E data;
    private Node<E> next;

    //Define your constructors
    public Node(){
        data = null;
        next = null;
    }

    public Node(E data){
        this(data, null);
    }

    public Node(E data, Node<E> next){
        this.data = data;
        this.next = next;
    }
    //Define your methods
    public Node <E> getNext(){
        return next;
    }

    public E getData(){
        return data;
    }

    public void setNext(Node <E> n){
        next = n;
    }
}
