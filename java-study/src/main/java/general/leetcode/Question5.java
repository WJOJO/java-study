package general.leetcode;

/**
 * 5. ������Ӵ�
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
 * @author javon
 *
 */
public class Question5 {

	
	/**
	 * ѭ��ÿһ��������л������ж�
	 * ��ʱ�临�Ӷ�O(n^2)
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {	//n
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {//n
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}

	public static void main(String[] args) {
		Question5 question5 = new Question5();
		String longestPalindrome = question5.longestPalindrome("babad");
		System.out.println(longestPalindrome);
	}
}
