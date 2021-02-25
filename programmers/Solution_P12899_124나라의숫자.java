package programmers;

public class Solution_P12899_124나라의숫자 {

	public class Solution {

		public String solution(int n) {
			String answer = "";
			int k = 3;
			int i = 2; // 자릿수
			int sum = k; // 자릿수-1까지 만들수있는 숫자
			if (n <= 2)
				return answer + n;
			if (n == 3)
				return "4";
			while (true) {
				if (sum < n && n <= sum + k * 3)
					break;
				k *= 3;
				sum += k;
				i++;
			}
			int j = n - sum - 1;
			String[] map = new String[i];
			String[] number = { "1", "2", "4" };
			int t = 1;
			for (int l = 0; l < i; l++) {
				if (j == 0) {
					map[l] = "1";
				} else {
					map[l] = number[(j / t) % 3];
					t *= 3;
				}

				answer = map[l] + answer;
			}

			return answer;
		}

	}

}
