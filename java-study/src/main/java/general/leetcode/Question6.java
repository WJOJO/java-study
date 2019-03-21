package general.leetcode;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * @author javon
 *
 */
public class Question6 {
	
	public String convert(String s, int numRows) {
		int length = s.length();
		if(length <= numRows || numRows < 2) return s;
		int i = length / (numRows-1) + 1;
		int j = numRows;
		
		//使用二维数组存放下标
		int[][] ints = new int[i][j];
		
		for (int m = 0; m < i; m+=2) {
			for (int n = 0; n < j; n++) {
				ints[m][n] = m * (j-1) + n;
				if(m + 1 < i){
					ints[m+1][n] = (m+2)*(j-1)-n;
				}
			}
		}
		//二维数组按列读取，生成字符串
		char[] result = new char[length];
		int seq = 0;
		for (int n = 0; n < j; n++) {
			for (int m = 0; m < i; m++) {
				if(ints[m][n] > length - 1 || (m>1&&n==0&&(m&1)==0) || (m>0&&n==j-1&&(m&1)==1))
					continue;
				result[seq++] = s.charAt(ints[m][n]);
			}
		}
		return new String(result);
    }
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		Question6 question6 = new Question6();
		String convert = question6.convert(s, 3);
		System.out.println(convert);
	}

}
