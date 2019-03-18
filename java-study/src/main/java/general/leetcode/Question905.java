package general.leetcode;

import java.util.stream.IntStream;

/**
 * 905. ����ż��������
 * ����һ���Ǹ��������� A������һ���� A ������ż��Ԫ����ɵ����飬����� A ��
 * ��������Ԫ�ء�
 * ����Է���������������κ�������Ϊ�𰸡�
 * @author javon
 *
 */
public class Question905 {
	
	
	public int[] sortArrayByParity(int[] A) {
		int m=0, n = A.length - 1;
		int tmp = 0;
        while(m < n){
        	if((A[m] & 1) == 0) 
        		m ++;
        	else{
        		tmp = A[m];
        		A[m] = A[n];
        		A[n] = tmp;
        		n --;
        	}
        }
        return A;
    }

	
	public static void main(String[] args) {
		Question905 question905 = new Question905();
		int[] A = {1,2,3,4,5,6,7,8,9};
		int[] sortArrayByParity = question905.sortArrayByParity(A);
		IntStream.of(sortArrayByParity).boxed().forEach(System.out::print);
	}
	
}
