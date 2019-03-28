package general.leetcode.stack.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. ��Ч������
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
 * ��Ч�ַ��������㣺
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
 * @author javon
 * @param <E>
 *
 */
public class Q20_ValidParentheses {
	/**
	 * map��stack���ʹ��
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
