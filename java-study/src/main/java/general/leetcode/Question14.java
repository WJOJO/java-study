package general.leetcode;

/** 
 * 14. �����ǰ׺
 * ��дһ�������������ַ��������е������ǰ׺��
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 * @author javon
 *
 */
public class Question14 {
	/**
	 * �ж�charֵ��ͬ  ʹ��^
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		if(strs.length < 1) return "";
		int length = strs[0].length();
		char[] s = strs[0].toCharArray();
		int p;
        for (int i = 0; i < length; i++) {
			for (int j = 1; j < strs.length; j++) {
				if(strs[j].length() <= i){
					return new String(s, 0, i);
				}
				p = s[i] ^ strs[j].charAt(i);
				if(p != 0) return new String(s, 0, i);
			}
		}
        return strs[0];
    }
	
	public static void main(String[] args) {
		Question14 question14 = new Question14();
		String[] strs = {"dog","racecar","car"};
		String longestCommonPrefix = question14.longestCommonPrefix(strs);
		System.out.println(longestCommonPrefix);
	}
	
}
