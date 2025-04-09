public class PracticeProblem {

	public static int[] bubbleSort(double[] nums) {
		int swaps = 0;
		int steps = 0;
		boolean swapped;
		for(int i = 0; i < nums.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < nums.length - 1 - i; j++) {
				steps++;
				if (nums[j] > nums[j + 1]) {
					double temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					swaps += 3;
					swapped = true;
				}
			}
			if (!swapped) break;
		}
		return new int[]{swaps, steps};
		
	}

	public static int[] selectionSort(double[] nums) {
		int swaps = 0;
		int steps = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			int smallIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				steps++;
				if (nums[j] < nums[smallIndex]) {
					smallIndex = j;
					swaps++;
					
				}
			}
				double temp = nums[i];
				nums[i] = nums[smallIndex];
				nums[smallIndex] = temp;
				swaps += 3;
			}
		

		return new int[]{swaps, steps};
	}

	public static int[] insertionSort(double[] nums) {
		int swaps = 0;
		int steps = 0;

		for (int i = 1; i < nums.length; i++) {
			double key = nums[i];
			swaps++;
			int j = i - 1;
			
			while (j >= 0 && nums[j] > key) {
				steps++;
				nums[j + 1] = nums[j];
				swaps++;
				j--;
				} 

				nums[j + 1] = key;
				swaps++;
			}
			return new int[] {swaps, steps};
		}

	public static String leastSwaps(double[] nums) {
		double[] bubbleSorted = nums.clone();
		double[] selectionSorted = nums.clone();
		double[] insertionSorted = nums.clone();

		int[] bubbleResult = bubbleSort(bubbleSorted);
		int[] selectionResult = selectionSort(selectionSorted);
		int[] insertionResult = insertionSort(insertionSorted);

		int bubbleSwap = bubbleResult[0];
		int selectionSwap = selectionResult[0];
		int insertionSwap = insertionResult[0];

	
		
		if (bubbleSwap <= selectionSwap && bubbleSwap <= insertionSwap) {
			return "Bubble";
		}
		else if (selectionSwap <= bubbleSwap && selectionSwap <= insertionSwap) {
			return "Selection";
		} else {
			return "Insertion";
		}
	}

	public static String leastIterations(double[] nums) {
		double[] bubbleSorted = nums.clone();
		double[] selectionSorted = nums.clone();
		double[] insertionSorted = nums.clone();

		int[] bubbleResult = bubbleSort(bubbleSorted);
		int[] selectionResult = selectionSort(selectionSorted);
		int[] insertionResult = insertionSort(insertionSorted);

		int bubbleIteration = bubbleResult[1];
		int selectionIteration = selectionResult[1];
		int insertionIteration = insertionResult[1];

		if (bubbleIteration <= selectionIteration && bubbleIteration <= insertionIteration) {
			return "Bubble";
		} 
		else if (selectionIteration <= bubbleIteration && selectionIteration <= insertionIteration) {
			return "Selection";
		} else {
			return "Insertion";
		}
	}
		
	

	public static void main(String args[]) {
		double[] arr = {3.4, 5.5, 1.2, 4.1, 1.0};
		int[] result = bubbleSort(arr.clone());
		System.out.println(result[0] + result[1]);
		int[] result2 = selectionSort(arr.clone());
		System.out.println(result2[0] + result2[1]);
		int[] result3 = insertionSort(arr.clone());
		System.out.println(result3[0] + result3[1]);

		String result4 = leastSwaps(arr);
		System.out.println(result4);

		String result5 = leastIterations(arr);
		System.out.println(result5);

	}

}
