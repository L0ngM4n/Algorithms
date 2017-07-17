package recursion;

public class ArraySym {
	public static Long sum(int[] arr, int index) {
		
		if (index < 0 || index >= arr.length) {
			return 0L;
		}
		
		long result = arr[index] + sum(arr, index + 1);
		
		return result;
	}
}


