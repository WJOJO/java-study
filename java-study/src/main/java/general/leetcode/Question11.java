package general.leetcode;

/**
 * 11. ʢ���ˮ������
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ��
 * �������ڻ� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)��
 * �ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 * 
 * ˵�����㲻����б�������� n ��ֵ����Ϊ 2��
 * @author javon
 *
 */
public class Question11 {

	 /**
	  * ˫ָ�뷨
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		 int i = 0, j = height.length - 1;
		 int maxArea = 0;
		 while (i <= j) {
			 maxArea = Math.max(maxArea, (j-i) * Math.min(height[i], height[j]));
			 if(height[i]<= height[j] ) i++;
			 else j--;
		 }
		 return maxArea;
	 }
	 
	 public static void main(String[] args) {
		int[] arr = {1,8,6,2,5,4,8,3,7};
		Question11 question11 = new Question11();
		int area = question11.maxArea(arr);
		System.out.println(area);
	}
}
