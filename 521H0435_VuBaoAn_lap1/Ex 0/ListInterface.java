import java.util.*;
public interface ListInterface <E> {
    public void addFirst(E item);
    public void addAfter(Node<E> curr, E item);
    public void addLast(E item);

    public E removeFirst() throws NoSuchElementException;
    public E removeAfter(Node<E> curr) throws NoSuchElementException;
    public E removeLast() throws NoSuchElementException;

    public int size();
    public boolean contains(E item);
    public void print();
    public boolean isEmpty();

    public Node<E> gethead() throws NoSuchElementException;
    public E getFirst();
}