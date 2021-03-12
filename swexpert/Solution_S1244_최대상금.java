package swexpert;

import java.io.*;
import java.util.*;

public class Solution_S1244_최대상금 {

	static int cnt;
	static int max;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		char[] charArr;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			cnt = Integer.parseInt(st.nextToken());
			charArr = s.toCharArray();
			char[] maxArr = s.toCharArray();
			Arrays.sort(maxArr);
			String maxNum = "";
			for (int i = maxArr.length - 1; i >= 0; i--) {
				maxNum += maxArr[i];
			}
			max = Integer.MIN_VALUE;
			flag = false;
			dfs(charArr, 0, Integer.parseInt(maxNum));
			System.out.println("#" + t + " " + max);
		}

	}

	private static void dfs(char[] charArr, int count, int maxNum) {
		if (flag)
			return;
		int t = Integer.parseInt(String.valueOf(charArr));
		if (count == cnt) {
			max = Math.max(t, max);
			return;
		}
		char a;
		for (int i = 0; i < charArr.length - 1; i++) {
			for (int j = i + 1; j < charArr.length; j++) {
				a = charArr[i];
				charArr[i] = charArr[j];
				charArr[j] = a;
				t = Integer.parseInt(String.valueOf(charArr));
				if (t == maxNum) {
					flag = true;
					if ((cnt - (count + 1)) % 2 == 0) {
						max = Math.max(t, max);
					} else {
						char x = charArr[charArr.length - 1];
						charArr[charArr.length - 1] = charArr[charArr.length - 2];
						charArr[charArr.length - 2] = x;
						max = Math.max(Integer.parseInt(String.valueOf(charArr)), max);
					}
					return;
				}
				dfs(charArr, count + 1, maxNum);
				charArr[j] = charArr[i];
				charArr[i] = a;
			}
		}

	}

}
