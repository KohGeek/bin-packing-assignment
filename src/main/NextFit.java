package main;

import java.util.Scanner;

public class NextFit 
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
	    System.out.print("Enter the capacity of the bin : ");
	    int c = sc.nextInt();
	    
	    System.out.print("Enter the numbers of the bin : ");
	    int m = sc.nextInt();
	    
	    System.out.print("Enter the number of the objects: ");
	    int numOfobject = sc.nextInt();
	    
	    int[] n = new int [numOfobject];
	    
	    for (int i =0; i < numOfobject; i++)
	    {
	    	System.out.print("Object" + (i+1) +" || ");
		    //int num = GetSize();
		    
		    
		    n [i] = sc.nextInt();
		    
	    }
	    
	    System.out.println("Number of bins required in Next Fit : " + nextFit(c,n,numOfobject));

	}
	
	/*public static int GetSize()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the object : ");
	    int s = sc.nextInt();
	    
	    return s;
	    
	}*/
	
	public static int nextFit(int c, int n[],int numOfobject )
	{
		int currentBin = 0;
		int remBin = c;
		
		for (int i = 0; i < numOfobject; i++)
		{
			if(n[i] > remBin)
			{
				currentBin++;
				remBin = c - n[i];
			}
			else 
			{
				remBin -= n[i];
			}
			
	
			
		}
		
		return currentBin;
		
			
	}

}
