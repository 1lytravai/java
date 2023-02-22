public class Test {
    public static void main(String[] args){
        
        MyLinkedList <Integer > list = new MyLinkedList <Integer >();
        list.addFirst(0);
        Node <Integer> currence = list.getHead();
        list.addAfter(currence,1);
        list.addLast(2);
        list.addLast(5);
        list.addLast(7);
        list.print();

        list.removeCurr(currence);
        list.print();

        list.removeFirst();
        list.print();

        list.removeAfter(list.getHead());
        list.print();

        list.removeLast();
        list.print();

        System.out.println("size: "+list.size());
        System.out.println("contains 2:"+list.contains(2));
        System.out.println("isEmpty:"+list.isEmpty());
        System.out.println("First: "+list.getFirst());
        System.out.println("sum: "+list.sum());
        System.out.println("Count even: "+ list.CountEven());
        list.addSortedList(7);
        list.addSortedList(1);
        list.print();
    }
}
