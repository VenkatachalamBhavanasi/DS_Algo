package ds.week1.homework;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
Find occurrence of each character

Input: String input="welcome to automation"
Output:
w=1, e=2, l=1, c=1, o=4, m=2, t=3, a=2, u=1, i=1, n=1,  =2
 */
public class CharOccurrences {
	/*
	 * 1) Did i understand the problem? 
	 *    Parameters
	 *      -> What is the input for this problem? 
	 *      -> What will be the output for this problem? 
	 *      -> is there any constraints? 
	 *      -> Do i have all informants to go the next step? 
	 *      -> How big is the test data?
	 *      
	 * 2) Test data set
	 *    -> Minimum of 3 data sets
	 *    -> Positive, Negative and Edge case scenario
	 *    -> Validate the test data with interviewer
	 *    
	 * 3) Do i know to solve it?
	 * 
	 * 4) Ask for hint if don't know to solve? 
	 * 
	 * 5) Do i know any alternate solution?
	 *    -> No, Solve with the known solution
	 *    
	 * 6) If alternate solution found -> Find the O notation 
	 *     -> Explain either or the best one depends on time
	 *     -> Approach 01 : Starts with worst(Brute force)
	 *     -> Approach 02: Write the options and benefits of it 
	 *     -> Always start from worst to best
	 *     
	 * 7) Proceed with pseudocode 
	 * 
	 * 8) Implement code in editor
	 * 
	 * 9) Test against data set
	 * 
	 * 10) Debug if it fails    
	 */
	
	@Test
	public void example1() {
		String input="Welcome to automation";
		System.out.println(returnEachOccurrences(input));
	}
	
	@Test
	public void example2() {
		String input="word";
		System.out.println(returnEachOccurrences(input));
	}
	
	@Test
	public void example3() {
		String input="Automation";
		System.out.println(returnEachOccurrences(input));
	}
	
	@Test
	public void example4() {
		String input="";
		System.out.println(returnEachOccurrences(input));
	}
	
	public Map<Character, Integer> returnEachOccurrences(String input) {
		Map<Character, Integer> output=new HashMap<>();
		char[] arr=input.toCharArray();
		
		for(char ch:arr)
			output.put(ch, output.getOrDefault(ch, 0)+1);
		
		return output;
	}
	
}
