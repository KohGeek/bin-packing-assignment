 package NextFit;

import java.util.Scanner;

public class NextFit 
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
	    System.out.print("Enter the capacity of the bin : "); 
	    int c = sc.nextInt();
	    
	    /*System.out.print("Enter the numbers of the bin : ");
	    int m = sc.nextInt();*/
	    
	    System.out.print("Enter the number of the objects: ");
	    int numOfobject = sc.nextInt();
	    
	    
	    int[] n = new int [numOfobject]; // Initialize array n with numOfobject 
	    
	    
	    for (int i =0; i < numOfobject ; i++) 
	    {
	    	System.out.print("Object " + (i+1) +" || "); // Input size of each object
	    	n [i] = sc.nextInt(); 
	    	
	    	if (n[i] > c)	// If size of particular object exceed the capacity of bin
		    {
		    	System.out.println("--Error : Size of Object " + (i+1) + " exceed the capacity of the bin !!!--");
		    	i--;
		    	
		    }
	    	
	    }
		
	    
	     System.out.println("Number of bins required in Next Fit : " + nextFit(c,n,numOfobject)); 
	    
	    /* for (int i  = 0; i < nextFit(c,n,numOfobject); i++ )
		{
	    	
			System.out.println("Bin" + i+1 + " || " + n[i]);
		} */
	   

	}
	
	public static int nextFit(int c, int n[],int numOfobject )
	{
		int currentBin = 1; //Initialize currentBin required to 1
		int remBin = c; //Initialize remBin to the capacity of bin
		
		for (int i = 0; i < numOfobject; i++) 
		{
			if(n[i] > remBin) //If size of object exceed the remBin 
			{
				currentBin++; //Use the new bin 
				remBin = c - n[i]; //Update remBin by (capacity of current bin - size of object)
				
			}
			else 
			{
				remBin -= n[i]; //Update remBin by (remaining capacity of bin - size of object)
			}
			
		}
		
		
		return currentBin; //total number of bins required
		
			
	}
	
}

