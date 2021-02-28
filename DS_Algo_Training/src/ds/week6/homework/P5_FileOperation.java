package ds.week6.homework;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
Return the minimum number of operations needed to go back to the main folder after the change folder operations.
The operations are described below:
"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
"./" : Remain in the same folder.
"x/" : Move to the child folder named x (This folder is guaranteed to always exist).

Example 1:
Input: logs = ["d1/","d2/","../","d21/","./"]
Output: 2
Explanation: Use this change folder operation "../" 2 times and go back to the main folder.

Example 2:
Input: logs = ["d1/","../","../","../"]
Output: 0
*/

//Pseudo code
/*
 * if the current element is ../
 	* if stack is empty, just continue the loop
 	* if not empty remove last element from the stack
 * if the current element is other than ./ -> push the element to stack
 * after the iteration, return stack size
 * 
 * Space: O[N]
 * Time: O[N]
 */
public class P5_FileOperation {

	@Test
	public void example1() {
		String[] logs = { "d1/", "d2/", "../", "d21/", "./" };
		Assert.assertEquals(2, fileOperation(logs));
	}

	@Test
	public void example2() {
		String[] logs = { "d1/", "../", "./" };
		Assert.assertEquals(0, fileOperation(logs));
	}

	@Test
	public void example3() {
		String[] logs = { "./", "../", "./" };
		Assert.assertEquals(0, fileOperation(logs));
	}

	private int fileOperation(String[] logs) {
		Stack<String> stack=new Stack<>();
		
		for(String str:logs) {
			if(str=="../") {
				if(!stack.isEmpty())
					stack.pop();
			} else if(!str.equals("./"))
				stack.push(str);
		}
		
		return stack.size();
	}
}
