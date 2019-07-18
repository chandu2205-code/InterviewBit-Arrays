package arrays;

import java.util.ArrayList;

public class SpiralOrderMatrixII {

	public static void main(String[] args) {
		System.out.println(generateMatrix(3));
	}

	public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {

		int[][] array = new int[A][A];
		int count = 1;
		int minRow = 0;
		int maxRow = A - 1;
		int minCol = 0;
		int maxCol = A - 1;

		while (minRow <= maxRow && minCol <= maxCol) {

			int j = minCol;

			while (j <= maxCol) {

				array[minRow][j++] = count++;
			}

			minRow++;

			int k = minRow;

			if (minRow <= maxRow) {
				while (k <= maxRow) {
					array[k++][maxCol] = count++;
				}
			}

			maxCol--;

			int l = maxCol;

			if (maxCol >= minCol) {
				while (l >= minCol) {
					array[maxRow][l--] = count++;
				}
			}

			maxRow--;

			int m = maxRow;

			if (maxRow >= minRow) {
				while (m >= minRow) {
					array[m--][minCol] = count++;
				}
			}
			minCol++;

		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i < array.length; i++) {

			ArrayList<Integer> list1 = new ArrayList<>();
			for (int j = 0; j < array.length; j++) {
				list1.add(array[i][j]);
			}
			list.add(list1);
		}
		return list;
	}
}
