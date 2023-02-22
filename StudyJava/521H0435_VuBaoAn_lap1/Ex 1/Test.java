public class Test {
    public static void main(String[] args) {
        MyLinkedList <Fraction> list = new MyLinkedList<Fraction>();
        
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(2, 4);
        Fraction c = new Fraction(1, 5);
        Fraction d = new Fraction(2, 9);

        list.addFirst(new Fraction(4, 9));
        Node <Fraction> currentPointer = list.getHead();
        list.addAfter(currentPointer, new Fraction(20,3));
        list.addLast(new Fraction(121,9));
        
        list.print();
        System.out.println(a.equals(b));
        System.out.println(c.equals(d));
        System.out.println(a.toString());
    }
}
