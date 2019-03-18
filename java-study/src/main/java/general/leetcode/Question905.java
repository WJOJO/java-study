package general.leetcode;

import java.util.stream.IntStream;

/**
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的
 * 所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
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
