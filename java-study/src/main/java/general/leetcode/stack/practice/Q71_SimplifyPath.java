package general.leetcode.stack.practice;

import java.util.Stack;
import java.util.StringJoiner;

/**
 * 71. ��·��
 * �� Unix ������һ���ļ��ľ���·��������Ҫ���������߻��仰˵������ת��Ϊ�淶·����
 * �� Unix �����ļ�ϵͳ�У�һ���㣨.����ʾ��ǰĿ¼����
 * ���⣬������ ��..�� ��ʾ��Ŀ¼�л�����һ����ָ��Ŀ¼����
 * ���߶������Ǹ������·������ɲ��֡�
 * ������Ϣ����ģ�Linux / Unix�еľ���·�� vs ���·��
 * 
 * ʹ��ջ�����ԣ�ƴ�ӷ���ֵʱ����ʹ��stringjoiner
 * 
 * @author javon
 *
 */
public class Q71_SimplifyPath {
	
	public String simplifyPath(String path) {
		path = path.replaceAll("/+", "/");
		if(path.length() <= 1) return "/";
		String[] split = path.split("/");
		Stack<String> stack = new Stack<String>();
		for (int i = 1; i < split.length; i++) {
			if(".".equals(split[i])){
				
			}else if("..".equals(split[i])){
				if(!stack.isEmpty()) stack.pop();
			}else{
				stack.push(split[i]);
			}
		}
		if(stack.isEmpty())	return "/";
		StringJoiner joiner = new StringJoiner("/", "/", "");
		stack.stream().forEach(s -> joiner.add(s));
		return joiner.toString();
    }
	
	public static void main(String[] args) {
		Q71_SimplifyPath q71 = new Q71_SimplifyPath();
		String simplifyPath = q71.simplifyPath("/home/.././a/b/c/");
		System.out.println(simplifyPath);
	}

}
