package general.leetcode;

/**
 * 10. 正则表达式匹配
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * @author javon
 *
 */
public class Question10 {

	public boolean isMatch(String s, String p) {
		return s.matches(p);
    }
}
