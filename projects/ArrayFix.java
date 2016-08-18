package projects;
import java.util.Arrays;

/*Problem Statement
Hero has two arrays, A and B, each containing the same number of integers. He wants to 
change A into an array that will resemble B as closely as possible. More precisely, the 
difference between two arrays of equal length is the number of indices where the two arrays 
differ. Hero wants to minimize the distance between the modified array A and the 
original array B. Hero can only modify A by using stickers. He has a collection of stickers. 
Each sticker contains a single integer. Each sticker can be used to cover a single element 
of A. Hero must use each sticker exactly once, and he cannot use multiple stickers on the 
same element of A. You are given the original arrays in the int[]s A and B, and the 
collection of stickers in the int[] F. Return the smallest possible difference 
between A and B after all stickers from F have been used to replace some elements of A.

 */

public class ArrayFix 
{
	public static void minDiff(int[] A, int[] B, int[] F)
	{
		int difference = 0;
		int i;
		int j;
		
		if(F.length == 0)
		{
			System.out.println(Arrays.toString(A));
			System.out.println(Arrays.toString(B));
			difference = A.length;
			System.out.println(difference);
		}
		else
		{
			for(i=0; i < A.length; i++)	//Iterate through array A
			{
				if(A[i] != B[i])	//If elements at same index A & B are not equal, search through				 
				{					//array F for identical stickers in B
					for(j = 0; j < A.length; j++)
					{
						if(F[j] == B[i])//If a sticker in F is identical to B[i], assign it to
						{				//A and replace value F[i] with -1 so it can't be used again
							A[i] = F[j];	
							F[j] = -1;
						}		
					}	
				}
				if(A[i] != B[i])//If element at A & B are still not the same, increment difference
				{
					difference++;
				}
			
			}
			System.out.println(Arrays.toString(A));
			System.out.println(Arrays.toString(B));
			System.out.println(difference);
		}
		
		}
	
	
	
	public static void main(String[] args) 
	{
		int[] A = {7,4,4};
		int[] B = {3,1,2};
		int[] F = {};
		minDiff(A,B,F);
		
		int[] C = {9,9,12};
		int[] D = {3,1,2};
		int[] E = {1,9,1};
		minDiff(C,D,E);

	}
}

/*
 OUTPUT:
 
[7, 4, 4]
[3, 1, 2]
3
[9, 1, 12]
[3, 1, 2]
2

 */
