package general.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. ����֮�� ����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c �� ʹ�� a + b + c = 0
 * ���ҳ��������������Ҳ��ظ�����Ԫ�顣
 * 
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 * 
 * @author javon
 *
 */
public class Question15 {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ls = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // ���������ظ��Ĵ�

				int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
				while (l < r) {
					if (nums[l] + nums[r] == sum) {
						ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
						while (l < r && nums[l] == nums[l + 1])
							l++;
						while (l < r && nums[r] == nums[r - 1])
							r--;
						l++;
						r--;
					} else if (nums[l] + nums[r] < sum) {
						while (l < r && nums[l] == nums[l + 1])
							l++; // �����ظ�ֵ
						l++;
					} else {
						while (l < r && nums[r] == nums[r - 1])
							r--;
						r--;
					}
				}
			}
		}
		return ls;
	}

	public static void main(String[] args) {
		int[] arr = { -1, -2, -3, 4, 1, 3, 0, 3, -2, 1, -2, 2, -1, 1, -5, 4, -3 };
		Question15 question15 = new Question15();
		List<List<Integer>> list = question15.threeSum(arr);
		for (List<Integer> list2 : list) {
			for (Integer integer : list2) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}

}
