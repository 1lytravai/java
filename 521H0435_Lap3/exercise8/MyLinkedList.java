import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numNode;

    public MyLinkedList() {
        head = null;
        numNode = 0;
    }

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        numNode++;
    }

    public void addAfter(Node<E> curr, E item) {       
        if (curr == null) {
            addFirst(item);
        } else {
            Node<E> newNode = new Node<E>(item, curr.getNext());
            curr.setNext(newNode);
        }
        numNode++;
    }

    public void addLast(E item) {
        if (head == null) {
            addFirst(item);
        } else {
            Node<E> tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            addAfter(tmp, item);
            //numNode++;
        }

    }

    public E removeFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("No exit Element!");

        } else {
            Node<E> tmp = head;
            head = head.getNext();
            numNode--;
            return tmp.getData();
        }
    }

    public E removeCurr(Node<E> curr) throws NoSuchElementException, NullPointerException {
        if (head == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");
        } else {
            Node<E> backNode = null;
            Node<E> delNode = head;
            boolean found = false;
            if (curr == null) {

                throw new NullPointerException("element null");
            }
            while (delNode.getNext() != null) {
                if (delNode.equals(curr)) {
                    found = true;
                    break;
                }
                backNode = delNode;
                delNode = delNode.getNext();
            }
            if (found) {
                if (backNode == null) {
                    head = delNode.getNext();
                } else {
                    backNode = delNode.getNext();
                }
                numNode--;

                return delNode.getData();

            } else {
                throw new NoSuchElementException("No exit element");
            }

        }
    }

    public E removeAfter(Node<E> curr) throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");

        } else {
            Node<E> tmp = curr.getNext();
            if (tmp != null) {
                curr.setNext(tmp.getNext());
                numNode--;
                return tmp.getData();

            } else {
                throw new NoSuchElementException("No Next node to remove");
            }

        }
    }

    public E removeLast() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");

        } else {
            Node<E> preNode = null;
            Node<E> delNode = head;
            while (delNode.getNext() != null) {
                preNode = delNode;
                delNode = delNode.getNext();
            }
            preNode.setNext(delNode.getNext());
            delNode.setNext(null);
            numNode--;
            return delNode.getData();
        }
    }

    public int size() {
        return numNode;
    }

    public boolean contains(E item) {
        Node<E> tmp = head;
        while (tmp != null) {
            if (tmp.getData().equals(item)) {
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    public void print() {
        if (head != null) {
            Node<E> tmp = head;
            System.out.print("List: " + tmp.getData());
            tmp = tmp.getNext();
            while (tmp != null) {
                System.out.print(" -> " + tmp.getData());
                tmp = tmp.getNext();
            }
            System.out.println();
        } else {
            System.out.println("List is empty!");
        }
    }

    public boolean isEmpty() {
        if (numNode == 0)
            return true;
        return false;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");

        } else {
            return head.getData();
        }

    }

    @Override
    public Node<E> getHead() {

        return head;
    }

    public void addSortedList(E item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
            boolean check = true;
            int t1 = (int) item;
            Node<E> step = head;
            Node<E> curr = null;
            while (step != null) {
                int t2 = (int) step.getData();

                if (t2 < t1) {
                    if (curr == null) {
                        addFirst(item);
                    } else {
                        addAfter(curr, item);
                    }
                    check = false;
                    break;
                }
                curr = step;
                step = step.getNext();

            }
            if (check) {
                addLast(item);
            }
        }
    }

    public int CountEven() {
        Node<E> curr = head;
        int count = 0;
        while (curr != null) {
            int t1 = (int) curr.getData();
            if (t1 % 2 == 0) {
                count++;
            }
            curr = curr.getNext();
        }
        return count;
    }

    public int sum() {
        Node<E> curr = head;
        int sum = 0;
        while (curr != null) {
            int t1 = (int) curr.getData();

            sum += t1;
            curr = curr.getNext();
        }

        return sum;
    }
}
