import java.util.*;
public class TestStack {
	public static void main(String[] args) {
		MyStack<Fraction> st1 = new MyStack<Fraction>();
		st1.push(new Fraction(2,3));
		st1.push(new Fraction(6,7));
		st1.push(new Fraction(2,9));
		st1.push(new Fraction(22,13));
		st1.push(new Fraction(42,23));
		st1.print();
	}
}