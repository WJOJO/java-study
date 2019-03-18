package general.leetcode;

/**
 * 34.在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @author javon
 *
 */
public class Question34 {

	public int[] searchRange(int[] nums, int target) {
		int first = -1;
		int end = -1;
		if(nums == null||
				nums.length == 0 || 
				nums[0] > target || 
				nums[nums.length - 1] < target){
			return new int[]{first, end};
		}
		
		if(nums[0] == target){
			first = 0;
		}
		if(nums[nums.length - 1] == target){
			end = nums.length - 1;
		}
		
		if(first != -1 && end != -1){
			return new int[]{first, end};
		}
		//二分查找第一个
		int b1 = 0, p1 = nums.length - 1, b2 = 0, p2 = nums.length - 1;
		int mid = 0;
		while(b1 < p1 ){
			 mid = (b1 + p1) >> 1;
			if(nums[mid] < target){
				b1 = mid + 1;
			}else{
				p1 = mid;
			}
		}
		if(nums[b1] == target){
			first = b1;
		}
		//二分查找最后一个
		while(b2 < p2 - 1){
			mid = (b2 + p2) >> 1;
			if(nums[mid] > target){
				p2 = mid - 1;
			}else{
				b2 = mid;
			}
		}
		if(nums[p2] == target){
			end = p2;
		}else if(nums[b2] == target){
			end = b2;
		}
		return new int[]{first, end};
    }
	
	
	
	
	@SuppressWarnings("unused")
	private int getFirst(int[] nums, int target){
		int start = 0, end = nums.length - 1;
		while(start < end){
			int mid = (start + end) >> 1;
			if(nums[mid] < target){
				start = mid + 1;
			}else{
				end = mid;
			}
		}
		if(nums[start] == target){
			return start;
		}
		return -1;
	}
	
	@SuppressWarnings("unused")
	private int getLast(int[] nums, int target){
		int start = 0, end = nums.length - 1;
		while(start < end){
			int mid = (start + end) >> 1;
			if(nums[mid] > target){
				end = mid - 1;
			}else{
				start = mid;
			}
		}
		if(nums[end] == target){
			return end;
		}else if(nums[start] == target){
			return start;
		}else{
			return -1;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,5,5,5,5,7};
		Question34 question34 = new Question34();
		int[] searchRange = question34.searchRange(nums, 5);
		for (int i : searchRange) {
			System.out.println(i);
		}
	}
	
}
