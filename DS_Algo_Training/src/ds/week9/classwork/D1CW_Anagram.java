package ds.week9.classwork;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class D1CW_Anagram {
	
	@Test
	public void example1() {
		String s1 = "babu";
		String s2 = "abbua";
		boolean pal = isAnagram(s1,s2);
		System.out.println(pal);
	}

	private boolean isAnagram(String s1, String s2) {
		
		if(s1.length() != s2.length())
			return false;
		
		int length = s1.length();
		
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < length; i++) {
			map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i), 0)+1);
			map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i), 0)+1);
		}
		
		return map1.equals(map2);
	}

}
