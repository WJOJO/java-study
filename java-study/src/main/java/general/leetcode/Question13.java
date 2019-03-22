package general.leetcode;

/**
 * 13. 罗马数字转整数
 * 类似12题
 * @author javon
 *
 */
public class Question13 {
	
	public int romanToInt(String s) {
		int result = 0;
        RomanRadix[] values = RomanRadix.values();
        for (int i = 0; i < values.length; i++) {
			while(s.startsWith(values[i].name())){
				result += values[i].getValue();
				if(s.length() == 1) break;
				s = s.substring(values[i].name().length());
			}
		}
        return result;
    }
	
	
	public static void main(String[] args) {
		Question13 question13 = new Question13();
		int romanToInt = question13.romanToInt("MCMXCIV");
		System.out.println(romanToInt);
	}
}
