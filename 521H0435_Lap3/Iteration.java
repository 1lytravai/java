import java.util.*;
import java.util.Scanner;

public class Iteration {
    // a
    public int calculationFactorial(int n) {
        if (n == 0)
            return 1;
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    // b
    public int calculationExp(int x, int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }

    // c
    public int countDigit(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }
        return count;
    }

    // d
    public boolean isPrime(int n) {
        if (n <= 2)
            return (n == 2) ? true : false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // e
    public int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Iteration test = new Iteration();
        System.out.println(test.calculationExp(2, 4));
        System.out.println(test.calculationFactorial(5));
        System.out.println(test.countDigit(1025));
        System.out.println(test.isPrime(4));
        System.out.println(test.isPrime(5));
        System.out.println(test.gcd(10, 45));
        System.out.println(test.gcd(45, 30));
    }
}
