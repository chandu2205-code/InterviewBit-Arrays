package arrays;
// Java program to calculate the maximum 
// absolute difference of an array.
public class MaximumAbsoluteDifference {

	private static int maxDistance(int[] array) {

		int min = array[0];
		int max = array[0];
		int minidx = 1;
		int maxidx = 1;
		int maxSum = 0;
		for (int i = 1; i < array.length; i++) {

			if (array[i] < min && (Math.abs(max - array[i]) + Math.abs(i + 1 - maxidx)) > maxSum) {
				// To check whether previous min can contribute to max sum
				if ((min - array[i]) > (i + 1 - minidx)) {
					min = array[i];
					minidx = i + 1;
				}
				maxSum = (Math.abs(max - array[i]) + Math.abs(i + 1 - maxidx));
			} else if (array[i] > max && (Math.abs(min - array[i]) + Math.abs(i + 1 - minidx)) > maxSum) {
				// To check whether previous max can contribute to max sum
				if ((array[i] - max) > (i + 1 - maxidx)) {
					max = array[i];
					maxidx = i + 1;
				}
				maxSum = (Math.abs(min - array[i]) + Math.abs(i + 1 - minidx));
			} else if ((Math.abs(min - array[i]) + Math.abs(i + 1 - minidx)) > maxSum) {
				maxSum = Math.abs(min - array[i]) + Math.abs(i + 1 - minidx);
			} else if (Math.abs(max - array[i] + Math.abs(i + 1 - maxidx)) > maxSum) {
				maxSum = Math.abs(max - array[i]) + Math.abs(i + 1 - maxidx);
			}

		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] array = { -70, -64, -6, -56, 64, 61, -57, 16, 48, -98 };
		System.out.println(maxDistance(array));
	}

}
