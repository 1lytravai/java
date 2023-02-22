
public class exercise7 {
    static int minimum(int[] x, int mini, int n) {
        if (n == -1) {
            return mini;
        } else {
            if (x[n] < mini) {
                return minimum(x, x[n], n - 1);
            } else {
                return minimum(x, mini, n - 1);
            }
        }
    }

    static int sum(int[] x, int sum, int n) {
        if (n == 0) {
            return sum + x[0];
        } else {
            return sum(x, sum + x[n], n - 1);
        }
    }

    static int counEven(int[] x, int n, int count) {
        if (n == -1) {
            return count;
        } else {
            if (x[n] % 2 == 0) {
                return counEven(x, n - 1, count + 1);
            } else {
                return counEven(x, n - 1, count);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 16, 2, 4, 5, 9, 7, 2, 1 };

        int x = minimum(arr, arr[arr.length - 1], arr.length - 1);
        System.out.println("Minimum in array: " + x);
        x = sum(arr, 0, arr.length - 1);
        System.out.println("Sum of array: " + x);
        x = counEven(arr, (arr.length - 1), 0);
        System.out.print("Count even: " + x);
    }
}