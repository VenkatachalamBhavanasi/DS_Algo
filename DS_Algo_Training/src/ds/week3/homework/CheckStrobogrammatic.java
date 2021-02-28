package ds.week3.homework;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Write a function to determine if a number is strobogrammatic. The number is represented as a string.
For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/
public class CheckStrobogrammatic {

	@Test
	public void example1() {
		String input = "69";
		Assert.assertEquals(true, isStrobogrammatic(input));
	}

	@Test
	public void example2() {
		String input = "818";
		Assert.assertEquals(true, isStrobogrammatic(input));
	}

	@Test
	public void example3() {
		String input = "80";
		Assert.assertEquals(false, isStrobogrammatic(input));
	}

	@Test
	public void example4() {
		String input = "23";
		Assert.assertEquals(false, isStrobogrammatic(input));
	}

	@Test
	public void example5() {
		String input = "1";
		Assert.assertEquals(true, isStrobogrammatic(input));
	}

	private boolean isStrobogrammatic(String input) {
		Map<Character, Character> map=new HashMap<Character,Character>(){
			{
				put('0', '0');
				put('1', '1');
				put('6','9');
				put('8','8');
				put('9','6');
			}
		};
		
		String output="";
		for (int i = input.length()-1; i >=0 ; i--) {
			if(!map.containsKey(input.charAt(i)))
				return false;
			output+=map.get(input.charAt(i));
		}
		return output.equals(input);
	}
}
