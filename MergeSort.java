import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
    	long start = System.currentTimeMillis(); 
		int A[] = new int[1000];
		populateArray(A);
		//populateSortedDescArray(A);
		//populateSortedAscArray(A);
		System.out.println("Before Sorting: ");
		printArray(A);
		// sort the array
		mergeSort(A);
		System.out.println("\nAfter Sorting: ");
		printArray(A); 
		
        long end = System.currentTimeMillis(); 
        System.out.println("Execution time takes:" + 
                                    (end - start) + "ms"); 
    	//Test
		/*for (int i = 10000; i>0; i--) {
			System.out.println(i);
		}*/
    }
    
    public static void printArray(int[] B) {
		System.out.println(Arrays.toString(B));
	}

	public static void populateArray(int[] B) {
		for (int i = 0; i < B.length; i++) {
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
   
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            // split array into two halves
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);
            
            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);
            
            // merge the sorted halves into a sorted whole
            merge(array, left, right);
        }
    }
    
    // Returns the first half of the given array.
    public static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }
    
    // Returns the second half of the given array.
    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }
    
    public static void merge(int[] result, 
                             int[] left, int[] right) {
        int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array
        
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && 
                    left[i1] <= right[i2])) {
                result[i] = left[i1];    // take from left
                i1++;
            } else {
                result[i] = right[i2];   // take from right
                i2++;
            }
        }
    }
 }