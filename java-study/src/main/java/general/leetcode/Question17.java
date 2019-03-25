package general.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 17. �绰�������ĸ���
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 * @author javon
 *
 */
public class Question17 {
	public List<String> letterCombinations(String digits) {
        //�п�
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

	//1 -> n�ĵݹ�
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
