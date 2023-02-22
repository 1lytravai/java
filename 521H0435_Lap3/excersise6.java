import java.util.*;
public class excersise6{

    //Find and return the minimum element of array
    public static int findMinimum(int[] arr, int n){
        int minimum = arr[0];
        for (int i = 1; i < n; i++){
            if (minimum > arr[i]){
                minimum = arr[i];
            }
        }
        return minimum;
    }

    //Compute and return the sum of all elements in an array
    public static int sumOfArray(int[] arr, int n){
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += arr[i];
        }

        return sum;
    }

    //Count how many even numbers are there in an array
    public static int countEvenNumber(int[] arr, int n){
        int count = 0;
        for (int i = 0; i < n; i++){
            if(arr[i] % 2 == 0){
                count += 1;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n]; 

        for(int i = 0; i < n; i++){
            System.out.print("Enter value " + (i+1) +": ");
            arr[i] = sc.nextInt();
        }  

        System.out.println("Minimum in array: " + findMinimum(arr, n));
        System.out.println("Sum of all elements: " + sumOfArray(arr, n));
        System.out.println("There are "+ countEvenNumber(arr, n) +" even number in array");
    }
}