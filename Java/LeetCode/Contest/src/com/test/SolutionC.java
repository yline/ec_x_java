package com.test;

import java.util.*;

/**
 * 删除无效的括号： 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。 
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。 
 * 
 * 示例 1: 输入: "()())()" 输出: ["()()()", "(())()"] 
 * 示例 2: 输入: "(a)())()" 输出: ["(a)()()", "(a())()"] 
 * 示例 3: 输入: ")(" 输出: [""]
 * 
 * @author yline
 *
 */
public class SolutionC {
	public static void main(String[] args) {
		String inputA = "()())()";
		delete(inputA);
		
		String inputB = "(a)())()";
		delete(inputB);
		
		String inputC = ")(";
		delete(inputC);
	}
	
	public static void delete(String content) {
		// 不用记录下标，直接算不合法的个数
		
		int illegalNum = illegalNum(content);
		int legalNum = content.length() - illegalNum;
		
//		int legalNum = legalNum(content);
		
		// 计算到所有的可能性
		HashSet<String> cacheSet = new HashSet<String>();
		dfs(cacheSet, new StringBuilder(), content, 0, 0, 0);
		
		// 过滤到，最小的
		List<String> result = new ArrayList<String>();
		for (String string : cacheSet) {
			if (string.length() == legalNum) {
				result.add(string);
			}
		}
		
		System.out.println(Arrays.toString(result.toArray()));
	}
	
	private static void dfs(HashSet<String> result, StringBuilder temp, String content, int index, int leftSize, int rightSize) {
		if (index == content.length()) {
			// 输出结果
			if (leftSize == rightSize) {
				result.add(temp.toString());
			}
			return;
		}
		
		// 当前字符不合法
		if (leftSize < rightSize) {
			return;
		}
		
		char val = content.charAt(index);
		if (val == '(') {	// 左侧内容
			// 不取当前的值
			dfs(result, temp, content, index + 1, leftSize, rightSize);
			
			// 取当前的值
			StringBuilder newTemp = new StringBuilder(temp);
			newTemp.append('(');
			dfs(result, newTemp, content, index + 1, leftSize + 1, rightSize);
		}else if(val == ')'){	// 右侧内容
			// 不取当前的值
			dfs(result, temp, content, index + 1, leftSize, rightSize);
			
			// 取当前的值
			StringBuilder newTemp = new StringBuilder(temp);
			newTemp.append(')');
			dfs(result, newTemp, content, index + 1, leftSize, rightSize + 1);
		}else {
			temp.append(val);
			dfs(result, temp, content, index + 1, leftSize, rightSize);
			temp.deleteCharAt(temp.length() - 1); 
		}
	}
	
	private static int illegalNum(String content) {
		int result = 0;
		
		// 缓存 栈的工具
		int left = 0, right = 0;
		
		for (int i = 0; i < content.length(); i++) {
			if ('(' == content.charAt(i)) {
				left += 1;
			}else if (')' == content.charAt(i)) {
				if (left > right) {	// 与左侧是匹配的
					right += 1;
				}else {
					result += 1;
				}
			}
		}
		
		return result + (left - right);
	}
	
}
