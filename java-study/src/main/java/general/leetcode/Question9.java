package general.leetcode;

/**
 * 9. ������	
 * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
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