package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution_P42586_기능개발 {

	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer;
		List<Integer> answers = new ArrayList<Integer>();
		int idx = 0;
		while (true) {
			for (int i = 0; i < progresses.length; i++) {
				progresses[i] += speeds[i];
			}
			int result = 0;
			while (idx < progresses.length && progresses[idx] >= 100) {
				idx++;
				result++;
			}
			if (result > 0)
				answers.add(result);
			if (idx == progresses.length)
				break;

		}
		answer = new int[answers.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answers.get(i);
		}
		return answer;
	}

}
