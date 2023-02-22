public class Test {
    public static void main(String[] args){
        MyLinkedList <Integer > list = new MyLinkedList <Integer >();
        list.addFirst(0);
        Node <Integer> currence = list.getHead();
        list.addAfter(currence, 1);
        list.addLast(3);
        list.addLast(5);
        list.print();
        list.removeCurr(currence);
        list.print();
    }
}
