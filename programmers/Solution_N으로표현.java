package programmers;

public class Solution_N으로표현 {
	static int Min;
	static int num;
	static int[] numArray = new int[9];// 1~8

	public int solution(int N, int number) {
		Min = Integer.MAX_VALUE;
		num = number;

		numArray[1] = N;
		for (int i = 2; i < 9; i++) {
			numArray[i] = numArray[i - 1] * 10 + N;
		}

		for (int i = 1; i < 9; i++) {
			dfs(i, numArray[i]);
		}

		if (Min == Integer.MAX_VALUE)
			return -1;
		else
			return Min;
	}

	private void dfs(int cnt, int result) {
		if (cnt > 8 || Min < cnt)
			return;
		if (result == num && Min > cnt) {
			Min = cnt;
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (cnt + i > 8)
				break;
			dfs(cnt + i, result * numArray[i]);
			dfs(cnt + i, result + numArray[i]);
			if (result / numArray[i] > 0) {
				dfs(cnt + i, result / numArray[i]);
			}
			dfs(cnt + i, result - numArray[i]);
			dfs(cnt + i, numArray[i] - result);
		}

	}

}
