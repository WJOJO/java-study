package general.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * @author javon
 *
 */
public class Question22 {
	//回溯法
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

        //左括号未达到最大值
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        //左括号数量大于等于右括号
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}
