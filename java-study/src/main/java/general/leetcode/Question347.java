package general.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * @author javon
 *
 */
public class Question347 {

	public List<Integer> topKFrequent(int[] nums, int k) {
		Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		};
		MyMap map = new MyMap();
        for (int i = 0; i < nums.length; i++) {
			map.put(nums[i]);
		}
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(comparator);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        
        while (iterator.hasNext()) {
			Map.Entry<java.lang.Integer,java.lang.Integer> entry =  iterator.next();
			queue.offer(entry);
		}
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
			list.add(queue.poll().getKey());
		}
        return list;
	}
	
	
	private class MyMap extends HashMap<Integer, Integer>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Integer put(Integer key) {
			if(this.containsKey(key)){
				return super.put(key, this.get(key) + 1 );
			}else{
				return super.put(key, 1);
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,2,3,4,5,6,7,8,3,4,5,6,7,8,5,6,7,8};
		int k = 3;
		Question347 question347 = new Question347();
		List<Integer> list = question347.topKFrequent(array, k);
		list.stream().forEach(System.out::print);
	}
	
}
