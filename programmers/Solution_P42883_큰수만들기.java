package programmers;

public class Solution_P42883_큰수만들기 {

	public String solution(String number, int k) {

		int idx = 0;
		StringBuilder sb = new StringBuilder();
		int pick = number.length() - k; // 뽑아야될 갯수
		while (true) {
			if (pick == 0)
				break;
			int max = -1;
			for (int j = idx; j < number.length() - pick + 1; j++) {
				if (max < number.charAt(j) - '0') {
					max = number.charAt(j) - '0';
					idx = j;
				}
			}
			sb.append(max);
			pick--;
			max = -1;
			idx++;
		}

		return sb.toString();
	}

}
