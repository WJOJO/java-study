package general.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @author javon
 *
 */
public class Question17 {
	public List<String> letterCombinations(String digits) {
        //判空
        if (digits.length() < 1) return Collections.emptyList();
        
        List<String> result = new ArrayList<>();
        Character[][] nums = {
                {}, {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};
        List<Character[]> list = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            list.add(nums[Integer.parseInt(c + "")]);
        }
        fun(list, 0, "", result);
        return result;
    }

	//1 -> n的递归
    public void fun(List<Character[]> list, int index, String s, List<String> result) {
        if (index >= list.size()) {
            result.add(s);
            return;
        }
        for (Character c : list.get(index)) {
            fun(list, index + 1, s+c, result);
        }
    }
}
