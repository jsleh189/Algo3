import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		long start = System.currentTimeMillis(); 
		int A[] = new int[1000000];
		//populateArray(A);
		populateSortedDescArray(A);
		//populateSortedAscArray(A);
		
		System.out.println("Before Insertion Sorting: ");
		printArray(A);
		// sort the array
		insertionSort(A);
		System.out.println("\nAfter Insertion Sorting: ");
		printArray(A);
		
        long end = System.currentTimeMillis(); 
        System.out.println("Execution time takes " + 
                                    (end - start) + "ms"); 
	}

	/**
	 * This method will sort the integer array using insertion sort in java algorithm
	 * 
	 * @param arr
	 */
	private static void insertionSort(int[] arr) {
		int comparisons =0;
		for (int i = 1; i < arr.length; i++) {
			int valueToSort = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1] > valueToSort) {
				arr[j] = arr[j - 1];
				j--;
				comparisons++;
			}
			arr[j] = valueToSort;
		}
		System.out.println("Comparisons:" + comparisons);
	}

	public static void printArray(int[] B) {
		System.out.println(Arrays.toString(B));
	}

	public static void populateArray(int[] B) {
		for (int i = 0; i < B.length; i++) {
			//Random random =new Random();
			//B[i] = ((int)(Math.random() * 100000)) % 1000;
			//B[i] = (int) random.nextInt(900) + 100;
			B[i] = (int) (Math.random() * 5000);
		}
	}
	public static void populateSortedAscArray(int[] B) {
		for (int i = 0; i < B.length; i++) {
			B[i] = i;
		}
	} 
	public static void populateSortedDescArray(int[] B) {
		int num = B.length;
		for (int i = 0; i < B.length; i++) {
			B[i] = num--;
		}
	}
}