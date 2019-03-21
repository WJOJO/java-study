package general.leetcode;

/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 
 * @author javon
 *
 */
public class Question8 {
	
	public int myAtoi(String str) {
		if(str == null)	return 0;
		str = str.trim();
		if("".equals(str) || "0".equals(str) || "+".equals(str) || "-".equals(str)) return 0;
		boolean isPositive;
		if(str.charAt(0)==(int)'+')
			{isPositive = true; str = str.substring(1);}
		else if(str.charAt(0) <= (int)'9' 
				&& str.charAt(0) >= (int)'0')
			isPositive = true;
		else if(str.charAt(0)==(int)'-')
			{isPositive = false; str = str.substring(1);}
		else
			return 0;
		
		while(str.startsWith("0")){
			str = str.substring(1);
		}
		if("".equals(str)) return 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <='9')	sb.append(str.charAt(i));
			else	break;
		}
		
		str = sb.toString();
		if("".equals(str)) return 0;
		if(str.length() < 10) return isPositive ? Integer.valueOf(str):-Integer.valueOf(str);
		else if(str.length() > 10) return isPositive ? Integer.MAX_VALUE:Integer.MIN_VALUE;
		else{
			int rem = Integer.parseInt(str.substring(str.length()-1));
			int result = Integer.parseInt(str.substring(0, str.length()-1));
			if((Integer.MAX_VALUE - rem) / 10 < result && isPositive){
				return Integer.MAX_VALUE;
			}
			if(! isPositive ){
				if((result > (rem + Integer.MIN_VALUE)/-10))
					return Integer.MIN_VALUE;
				else 
					return Integer.parseInt("-" +str);
			}
			return Integer.valueOf(str);
		}
    }
	
	public static void main(String[] args) {
		Question8 question8 = new Question8();
		System.out.println(Integer.MIN_VALUE);
		int myAtoi = question8.myAtoi("-2147483648");
		System.out.println(myAtoi);
	}

}
