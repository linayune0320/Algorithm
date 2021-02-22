package programmers;

public class Solution_P43163_단어변환 {
	static int answer;

	public int solution(String begin, String target, String[] words) {
		answer = Integer.MAX_VALUE;
		boolean visited[] = new boolean[words.length];
		dfs(begin, target, words, visited, 0);
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	private void dfs(String begin, String target, String[] words, boolean[] visited, int cnt) {
		if (begin.equals(target)) {
			answer = Math.min(answer, cnt);
			return;
		}
		for (int i = 0; i < words.length; i++) {
			if (canTransfer(begin, words[i]) && !visited[i]) {
				visited[i] = true;
				dfs(words[i], target, words, visited, cnt + 1);
				visited[i] = false;
			}
		}

	}

	private boolean canTransfer(String begin, String string) {
		int result = 0;
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) != string.charAt(i))
				result++;
		}
		if (result == 1)
			return true;
		return false;
	}

}
