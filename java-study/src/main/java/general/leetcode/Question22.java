package general.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. ��������
 * ���� n �����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
 * @author javon
 *
 */
public class Question22 {
	//���ݷ�
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        //������δ�ﵽ���ֵ
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        //�������������ڵ���������
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}
