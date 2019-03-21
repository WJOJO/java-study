package general.leetcode;

/**
 * 9. 回文数	
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @author javon
 *
 */
public class Question9 {
	
 	public boolean isPalindrome(int x) {
 		String string = String.valueOf(x);
 		for (int i = 0; i < string.length()/2; i++) {
			if(string.charAt(i) != string.charAt(string.length() - 1 -i))
				return false;
		}
 		return true;
    }
	
}
