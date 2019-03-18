package general.leetcode;

/**
 * 34.�����������в���Ԫ�صĵ�һ�������һ��λ��
 * ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 * ����㷨ʱ�临�Ӷȱ����� O(log n) ����
 * ��������в�����Ŀ��ֵ������ [-1, -1]��
 * ʾ�� 1:
 * ����: nums = [5,7,7,8,8,10], target = 8
 * ���: [3,4]
 * ʾ�� 2:
 * ����: nums = [5,7,7,8,8,10], target = 6
 * ���: [-1,-1]
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
		//���ֲ��ҵ�һ��
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
		//���ֲ������һ��
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
