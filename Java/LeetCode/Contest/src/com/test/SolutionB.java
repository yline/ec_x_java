package com.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 数组，和 = 0
 * 
 * 有的话，返回位置
 * 
 * 
 * @author yline
 *
 */
public class SolutionB {
	public static void main(String[] args) {
		int[] numA = new int[]{-1, -3, -5, 3, 2, -2};
		int[] result = test(numA);
		System.out.println("result = " + Arrays.toString(result));
	}

	/**
	 * 时间复杂度：O(n*n)
	 * 空间复杂度：O(1)
	 * 
	 * @param numArray
	 * @return
	 */
	private static int[] test(int[] numArray) {
		// 入口检查
		if (null == numArray || numArray.length < 3) {
			return null;
		}

		Arrays.sort(numArray); // 排序

		int cIndex = 0;
		for (int i = 0; i < numArray.length; i++) {
			cIndex = i;

			// 两个下标，左右往中间移动
			int leftIndex = cIndex == 0 ? 1 : 0;
			int rightIndex = cIndex == numArray.length - 1 ? numArray.length - 1 : numArray.length - 2;

			final int value = -numArray[cIndex];	// 目标值
			
			while (leftIndex < rightIndex) {
				int temp = numArray[leftIndex] + numArray[rightIndex];	// 当前值

				if (temp == value) {
					return new int[] { numArray[leftIndex], numArray[rightIndex], numArray[cIndex] };
				}

				if (temp > value) { // 右边的值大了，右边下标移动
					rightIndex -= 1;
					if (rightIndex == cIndex) {
						rightIndex -= 1;
					}
				} else { // 左边的值大了，左边下标移动
					leftIndex += 1;
					if (leftIndex == cIndex) {
						leftIndex += 1;
					}
				}
			}
		}
		
		return null;
	}

	public static int shortest(String a, String b) {
		boolean[] existArray = new boolean[256]; // 是否存在
		Arrays.fill(existArray, false);

		int[] signArray = new int[256]; // 存在的个数
		Arrays.fill(signArray, 0);

		// 将 b 制作成一个标志样
		int num = 0;
		for (int i = 0; i < b.length(); i++) {
			int index = b.charAt(i); // - 'a';

			if (!existArray[index]) {
				num += 1;
			}
			existArray[index] = true;
			signArray[index] -= 1;
		}

		// 找到出发点
		int aIndex = 0;
		while (num > 0) {
			// a 遍历到结束，依旧num 没有满足，则退出
			if (aIndex == a.length()) {
				return 0;
			}

			int index = a.charAt(aIndex); // - 'a';
			aIndex += 1;

			// 不存在，则过掉
			if (!existArray[index]) {
				continue;
			}

			signArray[index] += 1; // 个数增加
			if (signArray[index] == 0) {
				num -= 1;
			}
		}

		// 初始状态，并且开始移动
		boolean isMatch = true;
		int aleft = 0, aRight = aIndex;
		int min_result = aRight;

		while (aRight < a.length()) {
			// 当前状态是满足的，则移动左边，直到不满足
			if (isMatch) {
				int index = a.charAt(aleft); // - 'a';

				if (!existArray[index]) {
					aleft += 1;
					continue;
				}

				if (signArray[index] == 0) { // 最后一个了，删除这个就不满足
					min_result = Math.min(min_result, aRight - aleft);
					isMatch = false;
				}

				signArray[index] -= 1;
				aleft += 1;
			} else { // 当前状态是不满足的，则移动右边，直到满足
				int index = a.charAt(aRight); // - 'a';

				if (!existArray[index]) {
					aRight += 1;
					continue;
				}

				if (signArray[index] == -1) { // 因为，只有一个不满足就算不满足，因此就这一个不满足
					isMatch = true;
				}

				signArray[index] += 1;
				aRight += 1;
			}
		}

		// 右边全部计算完毕，那么，最后一次缩紧左侧
		if (isMatch) {
			for (int i = aleft; i <= aRight; i++) {
				int index = a.charAt(i); // - 'a';

				if (!existArray[index]) {
					continue;
				}

				if (signArray[index] == 0) {
					min_result = Math.min(min_result, aRight - index);
					break;
				}

				signArray[index] -= 1;
			}
		}

		return min_result;
	}
}
