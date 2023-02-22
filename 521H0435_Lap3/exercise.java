public class exercise {
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    public static int exercise4a(int n) {
        if (n == 0) {
            return 0;
        }
        return 2 * n + 1 + exercise4a(n - 1);
    }

    public static int exercise4b(int n) {
        if (n == 0) {
            return 0;
        }
        return factorial(n) + exercise4b(n - 1);
    }

    public static int exercise4c(int n) {
        if (n == 0) {
            return 1;
        }
        return factorial(n) * exercise4c(n - 1);
    }

    public static int ex5(int a, int base) {
        if (base == 8) {
            if (a < 10)
                return a;
        }
        if (a < 2)
            return a;
        return (a % base + 10 * ex5(a / base, base));

    }

    public static void main(String[] args) {
        System.out.println(exercise4a(5));
        System.out.println(exercise4b(5));
        System.out.println(exercise4c(5));
        System.out.println(ex5(8, 2));
        System.out.println(ex5(8, 8));
    }
}