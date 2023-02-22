public class Test {
    public static void main(String[] args) {
        MyQueue <Fraction> queue = new MyQueue<Fraction>();
        queue.enQueue(new Fraction(2, 3));
        queue.enQueue(new Fraction(2, 4));
        queue.enQueue(new Fraction(4, 6));
        queue.print();
    }
}
