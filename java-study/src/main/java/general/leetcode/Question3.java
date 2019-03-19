package general.leetcode;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author javon
 *
 */
public class Question3 {
	
	public int lengthOfLongestSubstring(String s) {
		String tmp = "";
		int length = 0;
		int j = 0;
		char[] array = s.toCharArray();
		char[] array2 = null;
		for (int i = 0; i < array.length; i++) {
			tmp = new String(array, j, i - j + 1);
			array2 = tmp.toCharArray();
			for (int k = 0; k < array2.length; k++) {
				if(i == array.length - 1){
					length = Math.max(length, array2.length);
				}else if(array2[k] == array[i + 1]){
					length = Math.max(length, array2.length);
					j += k + 1;
					break;
				}
			}
		}
		return length;
    }
	
	
	public static void main(String[] args) {
		Question3 question3 = new Question3();
		int lengthOfLongestSubstring = question3.lengthOfLongestSubstring("dvdfdvfcda");
		System.out.println(lengthOfLongestSubstring);
	}

}
