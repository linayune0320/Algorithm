package programmers;

public class Solution_P49993_스킬트리 {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		char[] arr = skill.toCharArray();
		for (int i = 0; i < skill_trees.length; i++) {
			String s = skill_trees[i];
			int lastIndex = -1;
			boolean flag = false;
			Loop1: for (int j = 0; j < s.length(); j++) {
				for (int k = 0; k < arr.length; k++) {
					if (s.charAt(j) == arr[k]) {
						if (lastIndex == -1) {
							if (k != 0) {
								flag = true;
								break Loop1;
							}
							lastIndex = k;

						} else {
							if (lastIndex + 1 == k) {
								lastIndex = k;
							} else {
								flag = true;
								break Loop1;
							}
						}
					}
				}
			}
			if (!flag)
				answer++;

		}
		return answer;
	}

}
