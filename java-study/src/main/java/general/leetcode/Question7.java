package general.leetcode;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @author javon
 *
 */
public class Question7 {

	public int reverse(int x) {
		boolean isPositive = x >= 0;
		int result = 0;
		x = Math.abs(x);
		while(x > 0){
			int rem = x % 10;
			x /= 10;
			if((Integer.MAX_VALUE - rem) / 10 < result && isPositive){
				return 0;
			}
			if(! isPositive && (result > (rem + Integer.MIN_VALUE)/-10) ){
				return 0;
			}
			result *= 10;
			result += rem;
		}
		return isPositive ? result: -result;
	}
	
	public static void main(String[] args) {
		Question7 question7 = new Question7();
		int reverse = question7.reverse(-123);
		System.out.println(reverse);
	}
}
