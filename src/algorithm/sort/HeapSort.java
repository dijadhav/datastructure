package algorithm.sort;

/**
 * The code is for heap sort algorithm
 * https://www.geeksforgeeks.org/heap-sort/?ref=lbp
 * 
 * @author dijadhav
 *
 */
public class HeapSort {
	public static void main(String[] args) {
		int[] arr = { 4, 1, 3, 9, 7 };
		heapSort(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * 
	 * @param arr
	 * @param n
	 */
	private static void heapSort(int arr[], int n) {
		buildHeap(arr, n);
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	/**
	 * Heapify the array
	 */
	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < n && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
	}

	private static void buildHeap(int arr[], int n) {
		for (int i = (n - 1) / 2; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}
}
