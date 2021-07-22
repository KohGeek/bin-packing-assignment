import java.util.Scanner;

public class Ff 
{
	// Returns number of bins required using first fit
		static int firstFit(int weight[], int n, int c)
		{
			// Initialize result (Count of bins)
			int res = 0;

			// Create an array to store remaining space in bins
			// there can be at most n bins
			int bin_rem[] = new int[n];
			
			// Place items one by one
			for (int i = 0; i < n; i++)
			{
				// Find the first bin that can accommodate
				// weight[i]
				int j;
				for (j = 0; j < res; j++)
				{
					if (bin_rem[j] >= weight[i])
					{
						bin_rem[j] = bin_rem[j] - weight[i];
						break;
					}
				}
				// If no bin could accommodate weight[i]
				if (j == res)
				{
					bin_rem[res] = c - weight[i];
					res++;
				}
										
			}
			return res;
		}
		
	
		// Driver program
		public static void main(String[] args)
		{
			Scanner scan = new Scanner (System.in);
			System.out.print("How many trucks?: ");
			int a = scan.nextInt();
			int weight[] = new int[a];
			for(int i = 0; i < a; i++)
			{
				System.out.print("Their each size: ");
				weight[i] = scan.nextInt();
			}
				
			System.out.print("How many items for each container?: ");
			int c = scan.nextInt();
			int n = weight.length;
			System.out.print("Number of bins required in First Fit : "
							+ firstFit(weight, n, c));
			System.out.println();
			
			
			
		}

}
