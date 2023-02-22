class BinaryHeapTest {
	
	public static void descendingHeapSort(int[] arr){
		MaxHeap tempHeap = new MaxHeap(arr.length+1);
		int[] sortedArray = new int[arr.length];
		for(int a : arr) {
			tempHeap.insert(a);
		}
		for(int i = 0; i < arr.length;i++) {
			sortedArray[i] = tempHeap.extractMax();
			System.out.print(sortedArray[i]+" ");
		}
		System.out.println("");
	}
	public static void ascendingHeapSort(int[] arr){
		MinHeap tempHeap = new MinHeap(arr.length+1);
		int[] sortedArray = new int[arr.length];
		for(int a : arr) {
			tempHeap.insert(a);
		}
		for(int i = 0; i < arr.length;i++) {
			sortedArray[i] = tempHeap.extractMin();
			System.out.print(sortedArray[i]+" ");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		// Exercise 1: Test max heap //
		MaxHeap maxHeap = new MaxHeap(10);
		maxHeap.insert(5);
		maxHeap.insert(7);
		maxHeap.insert(1);
		maxHeap.insert(6);
		maxHeap.insert(3);
		maxHeap.insert(4);
		maxHeap.insert(8);
		maxHeap.insert(10);
		maxHeap.print();
		System.out.println("Max value: " + maxHeap.extractMax());
		
		// Descending Heap Sort //
		int[] arr = {4,9,2,7,5,1,6,10,3,8};
		System.out.print("Descending Sorted array: ");
		descendingHeapSort(arr);
		
		// Ascending Heap Sort //
		System.out.print("Ascending Sorted array: ");
		ascendingHeapSort(arr);
		System.out.println();
		// Exercise 2: Test min heap //
		MinHeap minHeap = new MinHeap(7);
		minHeap.insert(1);
		minHeap.insert(2);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(7);
		minHeap.insert(4);
		minHeap.print();
		System.out.println("Min value: " + minHeap.extractMin());
		
		// Exercise 3 //
		int[] ex3 = {15,23,18,63,21,35,36,21,66,12,42,35,75,23,64,78,39};
		System.out.print("Descending Sorted array: ");
		descendingHeapSort(ex3);
		System.out.print("Ascending Sorted array: ");
		ascendingHeapSort(ex3);
	}
}