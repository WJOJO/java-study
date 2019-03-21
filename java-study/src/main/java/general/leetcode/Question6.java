package general.leetcode;

/**
 * 6. Z ���α任
 * ��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�
 * ���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�
 * @author javon
 *
 */
public class Question6 {
	
	public String convert(String s, int numRows) {
		int length = s.length();
		if(length <= numRows || numRows < 2) return s;
		int i = length / (numRows-1) + 1;
		int j = numRows;
		
		//ʹ�ö�ά�������±�
		int[][] ints = new int[i][j];
		
		for (int m = 0; m < i; m+=2) {
			for (int n = 0; n < j; n++) {
				ints[m][n] = m * (j-1) + n;
				if(m + 1 < i){
					ints[m+1][n] = (m+2)*(j-1)-n;
				}
			}
		}
		//��ά���鰴�ж�ȡ�������ַ���
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
