package general.leetcode.array.practice;

/**
 * 1. ����֮��
 * ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ��
 * �� ���� ���������������ǵ������±ꡣ
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ��
 * @author javon
 *
 */
public class Question1 {
	
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			for (int j = i+1; j < nums.length; j++) {
				if(nums[j] == diff)
					return new int[]{i, j};
			}
		}
		return new int[]{};
    }
	
	public static void main(String[] args) {
		int[] nums = {0,4,0,3};
		Question1 question1 = new Question1();
		int[] twoSum = question1.twoSum(nums, 0);
		System.out.println(twoSum);
	}

}
