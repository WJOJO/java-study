package general.leetcode.stack.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @author javon
 * @param <E>
 *
 */
public class Q20_ValidParentheses {
	/**
	 * map和stack组合使用
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		Map<Character,Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)){
				stack.push(c);
			}else if(map.values().contains(c)){
				if(stack.isEmpty()) return false;
				if(map.get(stack.pop()) != c) return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s = "()[]{}";
		Q20_ValidParentheses question20 = new Q20_ValidParentheses();
		boolean valid = question20.isValid(s);
		System.out.println(valid);
	}
}
