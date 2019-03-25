package general.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. ����֮��
 * ����һ������ n ������������ nums ��һ��Ŀ��ֵ target���ж� nums ���Ƿ�����ĸ�Ԫ�� a��b��c �� d ��
 * ʹ�� a + b + c + d ��ֵ�� target ��ȣ��ҳ��������������Ҳ��ظ�����Ԫ�顣
 * @author javon
 *
 */
public class Question18 {

	//����֮ǰ����3��֮�ͣ����Ա����˼·����ѭ�� Ȼ��ת��Ϊ3��֮�͵�����
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
        	if(i !=0 && nums[i] == nums[i-1]) continue;
        	int threeTarget = target - nums[i];
        	for (int j = i + 1; j < nums.length - 2; j++) {
				if(nums[j] == nums[j - 1] && j != i + 1) continue;
				int m = j + 1, n = nums.length - 1;
				int twoTarget = threeTarget - nums[j];
				while(m < n){
					//�����ظ���m�±�ֵ
					if(m != j + 1 && nums[m] == nums[m - 1]) {
						m++;
						continue;
					}
					//�����ظ���n�±�ֵ
					if(n < nums.length-2 && nums[n] == nums[n + 1]){
						n--;
						continue;
					}
					if(nums[m] + nums[n] < twoTarget){
						m ++;
					}else if(nums[m] + nums[n] > twoTarget){
						n --;
					}else{
						List<Integer> innerList = new ArrayList<Integer>();
						innerList.add(nums[i]);
						innerList.add(nums[j]);
						innerList.add(nums[m]);
						innerList.add(nums[n]);
						list.add(innerList);
						m++;
						n--;
					}
				}
			}
		}
        return list;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1,-5,-5,-3,2,5,0,4};
		Question18 question18 = new Question18();
		List<List<Integer>> fourSum = question18.fourSum(nums, -7);
		for (List<Integer> list : fourSum) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println();
		}
	}
}
