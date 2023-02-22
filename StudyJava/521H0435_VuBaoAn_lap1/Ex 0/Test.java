public class Test {
    public static void main(String[] args){
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);
        list.addFirst(1);
        list.print();
        
        System.out.print("Data head: "+list.getFirst());
    }
}
