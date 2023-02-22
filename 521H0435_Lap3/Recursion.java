import java.util.*;
import java.util.Scanner;

class Recursion {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    public static int ex2b(int x, int n) {
        if (n == 0) {
            return 0;
        }
        return x + ex2b(x, n - 1);
    }

    public static int countNumber(int x) {
        if (x == 0) {
            return 0;
        }
        return 1 + countNumber(x / 10);
    }

    public static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            a = a - b;
        } else {
            b = b - a;
        }
        return gcd(a, b);
    }

    // public static void main(String[] args) {
    //     System.out.println(factorial(5));
    //     System.out.println(ex1b(2, 2));
    //     System.out.println(countNumber(124));
    //     System.out.println(gcd(252, 105));

    // }

    // Ex3
    // d bat dau la 2
    public static boolean isPrime(int n, int d) {
        if (n < 2)
            return false;
        if (n % d == 0)
            return (n == 2) ? true : false;
        if (d > ((double) (n) / 2))
            return true;
        return isPrime(d + 1, n);
    }

    public static void main(String[] args) {
        System.out.println(factorial(2));
        System.out.println(ex2b(2, 2));
        System.out.println(countNumber(124));
        System.out.println(gcd(252, 105));
        System.out.println(isPrime(1, 0));
    }
}
    

