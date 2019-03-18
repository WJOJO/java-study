package general.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * ���ƴ������
 * 
 * ���ǵ�ͯ����������СŮ���������ڣ���֪��СŮ���ж��ٸ�������ҳ�һ����ʹ�����л��ƴ��һ�������εķ�����
 * �����۶ϻ�񣬿��԰ѻ����������������ÿ�����Ҫ�õ���
 * ����ΪСŮ��ӵ�л�����Ŀ��ÿ��������䳤�ȱ�ʾ�������Ϊ�Ƿ��������еĻ��ƴ�������Ρ�
 * @author javon
 *
 */
public class Question473 {
	
    public boolean makesquare(int[] nums) {
    	
        if(nums.length ==0 ) return false;
        int sum = IntStream.of(nums).boxed().reduce(0, (x,y) -> x + y);
        if((sum & 3) != 0) return false;
        Arrays.parallelSort(nums);
        return dfs(nums,1,nums.length,nums[nums.length - 1],0,0,0,sum/4);
    }

    private boolean dfs(int[] nums, int i, int length, int i1, int i2, int i3, int i4, int sideLength) {
        if(i==length){
            if(i1==sideLength && i2==sideLength && i3==sideLength && i4==sideLength ) return true;
            else return false;
        }
        if(i1>sideLength || i2>sideLength || i3>sideLength || i4>sideLength ) return false;
        return dfs(nums,i+1,length,i1+nums[nums.length - i - 1],i2,i3,i4,sideLength)||
        dfs(nums,i+1,length,i1,i2+nums[nums.length - i - 1],i3,i4,sideLength)||
        dfs(nums,i+1,length,i1,i2,i3+nums[nums.length - i - 1],i4,sideLength)||
        dfs(nums,i+1,length,i1,i2,i3,i4+nums[nums.length - i - 1],sideLength);
    }
}
