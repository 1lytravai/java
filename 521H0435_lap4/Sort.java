public class Sort {
    public static void printArray(int a[]){
        for(int i=0; i<a.length; i++){
            System.out.print(" "+ a[i]);
        }
        System.out.println();
    }
    public static void insertionSort(int a[]){
        int curr;
        int j;
        for(int i=1; i<a.length; i++){
            curr = a[i];
            j=i-1;
            while(j>=0 && a[j]>curr){
                a[j+1]=a[j];
                j--;
            }
            a[j+1] = curr;
        }
    }
	
    public static void selectionSort(int a[]){
        int min_index;
        for(int i=0; i<a.length-1; i++) {
            min_index = i;
            boolean flag = false;
            for(int j=i+1; j<a.length; j++){ 
                if(a[min_index]>a[j]){
                    min_index =j;
                    flag = true;
                }
            }
            if(flag){
                int tmp = a[i];
                a[i]= a[min_index];
                a[min_index] = tmp;
            }
            System.out.println(a[i]);
            
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
		// Find sizes of two sub-arrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;
		// Create temp arrays
		int L[] = new int [n1];
		int R[] = new int [n2];
		// Copy data to temp arrays
		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}
		/* Merge the temp arrays */
		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;
		// Initial index of merged sub-array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i<n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j<n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	public static void mergeSort(int[] arr, int first , int last)
	{
		if (first < last)
		{
			// Find the middle point
			int middle = (first + last)/2;
			// Sort first and second halves
			mergeSort(arr, first , middle);
			mergeSort(arr, middle + 1, last);
			// Merge the sorted halves
			merge(arr, first , middle , last);
		}
	}
	
	private static int partition(int[] arr, int low, int high)
	{
		int pivot = arr[high];
		// index of smaller element
		int i = (low - 1);
		for (int j = low; j < high; j++) {
		// If current element is smaller than or equal to pivot
			if (arr[j] <= pivot) {
				i++;
				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}

	// The main function that implements quickSort algorithm
	// arr[] --> Array to be sorted ,
	// low --> Starting index ,
	// high --> Ending index
	public static void QuickSort(int[] arr, int low, int high) {
		if (low < high) {
			// pi is partitioning index , arr[pi] is now at right place
			int pi = partition(arr, low, high);
			// Recursively sort elements before partition and after
			QuickSort(arr, low, pi - 1);
			QuickSort(arr, pi + 1, high);
		}
	}

	static void swap(int arr[], int i){
        int k = arr[i];
        arr[i] = arr[i-1];
        arr[i-1] = k;
    }
    
    static void bubbleSort(int arr[]){
        boolean check_swap = true;
        while (check_swap == true){
            check_swap = false;
            for(int i=1; i<arr.length; i++){
                if(arr[i-1]>arr[i]){
                    swap(arr, i);
                    check_swap = true;
                }
            }
        }
    }

    public static void main(String[] args){
        int a[]= {1,3,9,8,5,2,7};
        int b[]={1,7,3,9,10,13,0};
        int c[]={0,10,9,5,7,3};
		int d[]={0,10,33,4,5,6};
		int e[]={0,9,5,8,1};
        System.out.println("Sorted array using insertionSort sort: ");
        insertionSort(a);
        printArray(a);
        System.out.println("Sorted array using selection sort: ");
        selectionSort(b);
        printArray(b);
        System.out.println("Sorted array using Merge sort: ");
        mergeSort(c,0,c.length-1); 
        printArray(c);
        System.out.println("Sorted array using quick sort: ");
		QuickSort(d, 0, d.length-1);
		printArray(d);
		System.out.println("Sorted array using buble sort: ");
		bubbleSort(e);
		printArray(e);
	}
}