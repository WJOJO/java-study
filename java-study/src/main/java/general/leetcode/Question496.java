package general.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 *  496.��һ������Ԫ�� I
 *  ��������û���ظ�Ԫ�ص����� nums1 �� nums2 ������nums1 �� nums2 ���Ӽ����ҵ� nums1 ��ÿ��Ԫ���� nums2 �е���һ��������ֵ��
	nums1 ������ x ����һ������Ԫ����ָ x �� nums2 �ж�Ӧλ�õ��ұߵĵ�һ���� x ���Ԫ�ء���������ڣ���Ӧλ�����-1��
 * @author javon
 *
 */
public class Question496 {
	//����˼·ʹ��ջ�����ԣ�����nums2
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();
        
        for(int num : nums2) {
            while(!stack.isEmpty() && stack.peek()<num){
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        for(int i = 0; i < nums1.length; i++) 
        	nums1[i] = hasMap.getOrDefault(nums1[i], -1);
            
        return nums1;
	}
}
