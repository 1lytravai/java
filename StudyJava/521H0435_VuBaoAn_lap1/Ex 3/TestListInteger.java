public class TestListInteger {
    public static void main(String[] args){
        ListInteger<Integer> list = new ListInteger<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.print();
        System.out.println("Count even item: "+ list.countEvenItem());
        System.out.println("Count prime item: "+ list.countPrimeItem());
        list.addX(12);
        list.print();
        System.out.println("Max item: "+ list.findMax());
        list.reverse();
        System.out.println("Reverse list:");
        list.print();
        list.bubbleSort();
        System.out.println("Sort list:");
        list.print();
    }
}
