package general.leetcode;

import java.util.Arrays;

/**
 * 16. ��ӽ�������֮��
 * ����һ������ n ������������ nums �� һ��Ŀ��ֵ target��
 * �ҳ� nums �е�����������ʹ�����ǵĺ��� target ��ӽ���
 * �������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
 * @author javon
 *
 */
public class Question16 {
	private int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
        	int m = i + 1;
        	int n = nums.length - 1;
			while(m < n){
				int sum = nums[i] + nums[m] + nums[n];
				if(sum < target)
					m++;
				else if(sum > target)
					n--;
				else
					return target;
				if(Math.abs(diff) > Math.abs(sum - target))
					diff = sum - target;
			}
		}
        return diff + target;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		int target = 1;
		Question16 question16 = new Question16();
		int threeSumClosest = question16.threeSumClosest(nums, target);
		System.out.println(threeSumClosest);
	}
}
