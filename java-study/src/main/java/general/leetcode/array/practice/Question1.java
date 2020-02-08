package general.leetcode.array.practice;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的
 * 那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
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
