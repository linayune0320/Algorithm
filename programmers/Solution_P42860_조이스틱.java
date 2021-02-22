package programmers;

public class Solution_P42860_조이스틱 {
	public int solution(String name) {
		int answer = 0;
		char[] a = new char[name.length()];
		for (int i = 0; i < name.length(); i++) {
			a[i] = 'A';
		}

		for (int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i) - a[i], 'Z' - name.charAt(i) + 1);
		}
		int min = name.length() - 1;
		int index = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != 'A') {
				index = i + 1;
				while (index < name.length() && name.charAt(index) == 'A') {
					index++;
				}
				min = Math.min(min, i + name.length() - index + Math.min(i, name.length() - index));
				i = index;
			}
		}

		return answer + min;
	}
}
