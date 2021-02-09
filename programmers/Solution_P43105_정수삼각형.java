package programmers;

class Solution_P43105_정수삼각형 {
	// https://programmers.co.kr/learn/courses/30/lessons/43105?language=java
	public int solution(int[][] triangle) {
		int answer = -1;
		int[][] sum = new int[triangle.length][triangle.length];
		sum[0][0] = triangle[0][0];
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j - 1 >= 0) {
					sum[i][j] = Math.max(sum[i - 1][j], sum[i - 1][j - 1]) + triangle[i][j];
				} else {
					sum[i][j] = sum[i - 1][j] + triangle[i][j];
				}
			}
		}

		for (int i = 0; i < triangle.length; i++) {
			if (answer < sum[triangle.length - 1][i]) {
				answer = sum[triangle.length - 1][i];
			}
		}

		return answer;
	}

}