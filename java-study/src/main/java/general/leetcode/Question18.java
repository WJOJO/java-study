package general.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * @author javon
 *
 */
public class Question18 {

	//由于之前做过3数之和，所以本题的思路考虑循环 然后转换为3数之和的问题
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
					//跳过重复的m下标值
					if(m != j + 1 && nums[m] == nums[m - 1]) {
						m++;
						continue;
					}
					//跳过重复的n下标值
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
