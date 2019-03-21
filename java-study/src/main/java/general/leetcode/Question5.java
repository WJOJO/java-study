package general.leetcode;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @author javon
 *
 */
public class Question5 {

	
	/**
	 * 循环每一个基点进行回文数判断
	 * 总时间复杂度O(n^2)
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

	
	/**
	 * Manacher算法
	 * @param s
	 * @return
	 */
	public String manacher(String s){
		String t = "$#";
        for (int i = 0; i < s.length(); ++i) {
            t += s.charAt(i);
            t += "#";
        }
        t += "@";

        // Process t
        int[] p = new int[t.length()];;
        int mx = 0, id = 0, resLen = 0, resCenter = 0;
        for (int i = 1; i < t.length()-1; ++i) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (((i - p[i])>=0) && ((i + p[i])<t.length()-1) && (t.charAt(i + p[i]) == t.charAt(i - p[i])))
                ++p[i];
            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if (resLen < p[i]) {
                resLen = p[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter - resLen) / 2, (resCenter - resLen) / 2 + resLen-1);

	}
	
	
	public static void main(String[] args) {
		Question5 question5 = new Question5();
		String longestPalindrome = question5.manacher("babad");
		System.out.println(longestPalindrome);
	}
}
