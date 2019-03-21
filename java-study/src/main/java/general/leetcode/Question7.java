package general.leetcode;

/**
 * 7. ������ת
 * ����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��
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
