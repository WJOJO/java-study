package general.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 火柴拼正方形
 * 
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。
 * 不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
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
