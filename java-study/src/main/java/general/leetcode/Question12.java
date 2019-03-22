package general.leetcode;

/**
 * 12. 整数转罗马数字
 * 
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * @author javon
 *
 */
public class Question12 {
	
	/**
	 * 基于枚举的写法
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		RomanRadix[] values = RomanRadix.values();
		for (int i = 0; i < values.length; i++) {
			int quotient = num / values[i].getValue();
			num = num % values[i].getValue();
			for (int j = 0; j < quotient; j++) {
				sb.append(values[i].name());
			}
		}
		return sb.toString();
    }
	
}


enum RomanRadix{
	M(1000),
	CM(900),
	D(500),
	CD(400),
	C(100),
	XC(90),
	L(50),
	XL(40),
	X(10),
	IX(9),
	V(5),
	IV(4),
	I(1);
	
	private int value;
	private RomanRadix(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
