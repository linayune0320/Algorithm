package programmers;

class Solution_P43165_타겟넘버 {
	// https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
	static int size;
	static int answer;
	static int numbers[];

	public int solution(int[] number, int target) {
		size = number.length;
		answer = 0;
		numbers = number;
		dfs(0, 0, target);
		return answer;
	}

	public void dfs(int cnt, int result, int target) {
		if (cnt == size) {

			if (result == target) {
				answer++;
			}
			return;

		}

		dfs(cnt + 1, result + numbers[cnt], target);
		dfs(cnt + 1, result - numbers[cnt], target);

	}
}