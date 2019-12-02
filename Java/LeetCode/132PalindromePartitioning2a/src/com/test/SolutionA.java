package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * 时间复杂度： 1，构建缓存，算n 2，找出最小值，感觉复杂度全部便利了。很高；优化方案：建立一个数组缓存，取最小值
 * 
 * 超时
 * 
 * @author yline
 */
public class SolutionA {
	public int minCut(String s) {
		if (null == s || s.length() == 0) {
			return 0;
		}

		// key为left，value为right的所有集合，单个表示为[left, right]
		Map<Integer, List<Integer>> cacheMap = new HashMap<>();
		buildCache(cacheMap, s);

		int[] minArray = new int[s.length()]; // 最小的片段个数
		for (int i = 0; i < minArray.length; i++) {
			minArray[i] = i + 1;
		}

		findResult(cacheMap, s, minArray, 0, 0);
		return minArray[s.length() - 1] - 1;
	}

	/**
	 * 找出最小的距离
	 * 
	 * @param cacheMap 建立的缓存内容
	 * @param size     当前的片段个数
	 * @param s        字符
	 * @param index    当前下标
	 */
	private void findResult(Map<Integer, List<Integer>> cacheMap, String s, int[] minArray, int size, int index) {
		// 到达终点
		if (index == s.length()) {
			return;
		}

		// 减枝
		if (minArray[index] <= size + 1) {
			return;
		}

		// 更新最小值
		minArray[index] = size + 1;

		List<Integer> nextList = cacheMap.get(index);
		// 不可能出现的情况
		if (null == nextList || nextList.isEmpty()) {
			return;
		}

		for (int i = 0; i < nextList.size(); i++) {
			size++;
			findResult(cacheMap, s, minArray, size, nextList.get(i) + 1);
			size--;
		}
	}

	private void buildCache(Map<Integer, List<Integer>> cacheMap, String s) {
		// 奇数
		for (int i = 0; i < s.length(); i++) {
			int left = i, right = i;

			// 不超过边界，并且一直符合条件才添加
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				addPalindromeRecord(cacheMap, left, right);
				left--;
				right++;
			}
		}

		// 偶数
		for (int i = 0; i < s.length(); i++) {
			int left = i, right = i + 1;

			// 不超过边界，并且一直符合条件才添加
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				addPalindromeRecord(cacheMap, left, right);
				left--;
				right++;
			}
		}
	}

	private void addPalindromeRecord(Map<Integer, List<Integer>> cacheMap, int left, int right) {
		List<Integer> cacheList = cacheMap.get(left);
		if (null == cacheList) {
			List<Integer> dataList = new ArrayList<>();
			dataList.add(right);
			cacheMap.put(left, dataList);
			return;
		}
		cacheList.add(right);
	}
}
