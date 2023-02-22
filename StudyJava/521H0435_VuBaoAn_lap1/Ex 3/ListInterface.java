import java.util.NoSuchElementException;

public interface ListInterface <E> {
    public void addFirst(E item);
    public void addAfter(Node<E> curr, E item);
    public void addLast(E item);
    public void print();

    public int countEvenItem();
    public boolean checkPrime(int n);
    public int countPrimeItem();

    public void addX(E x) throws NoSuchElementException;
    public int findMax() throws NoSuchElementException;

    public void reverse() throws NoSuchElementException;
    public void bubbleSort() throws NoSuchElementException;
}