package general.leetcode.stack.practice;

import java.util.Stack;
import java.util.StringJoiner;

/**
 * 71. 简化路径
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；
 * 此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。
 * 更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 
 * 使用栈的特性，拼接返回值时可以使用stringjoiner
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
