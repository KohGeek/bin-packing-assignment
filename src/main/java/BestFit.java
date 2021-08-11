package main;

import java.util.Scanner;

//Best fit algorithm.
class BestFit {

//Driver code
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// number of weights
		System.out.print("Enter the number of the weights: ");
		int numOfWeights = sc.nextInt();

		// store capacity of each weight
		int[] weight = new int[numOfWeights];
		for (int i = 0; i < numOfWeights; i++) {
			System.out.print("Enter the capacity of weight" + i + ": ");
			int m = sc.nextInt();
			weight[i] = m;
		}

		// space for each bin
		System.out.print("Enter the capacity of the bin : ");
		int c = sc.nextInt();
		
		
		System.out.print("Number of bins required in Best Fit : " + bestFit(weight, numOfWeights, c));
	}

	static int bestFit(int weight[], int n, int c) {
		// Initialize result (Count of bins)
		int result = 0;

		// Create an array to store
		// remaining space in bins
		// there can be at most n bins
		int[] bin_rem_ = new int[n];

		// Place items one by one
		for (int i = 0; i < n; i++) {

			// find best bin
			int j;

			// Initialize minimum space
			// left and index
			// of best bin
			int min_space = c + 1, best_bin = 0;

			for (j = 0; j < result; j++) {
				if (bin_rem_[j] >= weight[i] && bin_rem_[j] - weight[i] < min_space) {
					best_bin = j;
					min_space = bin_rem_[j] - weight[i];
				}
			}

			// If no bin could accommodate weight[i],
			// create a new bin
			if (min_space == c + 1) {
				bin_rem_[result] = c - weight[i];
				result++;
			}

			// Assign the item to best bin
			else {
				bin_rem_[best_bin] -= weight[i];
			}

		}
		return result;

	}

}
