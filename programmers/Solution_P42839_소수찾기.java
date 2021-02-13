package programmers;

import java.util.HashSet;
import java.util.Iterator;

public class Solution_P42839_소수찾기 {
	static HashSet<Integer> hs = new HashSet<Integer>();

	public int solution(String numbers) {
		int answer = 0;
		boolean visited[] = new boolean[numbers.length()];
		permutation(visited, numbers, "", 0);
		Iterator<Integer> iter = hs.iterator();
		while (iter.hasNext()) {
			if (isDecimal(iter.next())) {
				answer++;
			}
		}
		return answer;
	}

	private boolean isDecimal(Integer integer) {
		if (integer <= 1)
			return false;
		for (int i = 2; i < integer; i++) {
			if (integer % i == 0) {
				return false;
			}
		}
		return true;
	}

	private void permutation(boolean[] visited, String numbers, String result, int cnt) {

		if (result.length() != 0)
			hs.add(Integer.parseInt(result));

		for (int i = 0; i < numbers.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				permutation(visited, numbers, result + "" + numbers.charAt(i), cnt + 1);
				visited[i] = false;
			}
		}

	}

}
