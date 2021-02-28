package ds.week4.classwork;

import org.junit.Test;

public class D2CW_GenerateBrackets {
	
	@Test
	public void example1() {
		int numbers = 4;
		// (()), ()() 
		
		// Brackets should be in even number 
		
		// number 6
		// ()()(), ((()))), ()(()), (())(), (()())
		generateBrackets(numbers);
	}
	
	@Test
	public void example2() {
		int numbers = 6;
		generateBrackets(numbers);
	}
	
	@Test
	public void example3() {
		int numbers = 5;
		generateBrackets(numbers);
	}

	// Intialize your starting position of the recursion 
	private void generateBrackets(int numbers) {
		if(numbers % 2 == 1 || numbers < 1)
			throw new RuntimeException("This is odd or invalid bracket count");
		
		recursive(numbers/2,0,0,"");
	}
	// O(n) => 
	private void recursive(int numbers, int left, int right, String brackets) {
		if(left == numbers && right == numbers) {
			System.out.println(brackets);
			return;
		}
			
		if(left < numbers)
			recursive(numbers,left+1,right,brackets + "(");
		if(right < left)
			recursive(numbers,left,right+1,brackets + ")");

	}
}
