package programmers;

public class Solution_P72412_순위검색 {
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		String[][] infoArr = new String[info.length][5];
		for (int i = 0; i < info.length; i++) {
			infoArr[i] = info[i].split(" ");
		}
		String[][] queryArr = new String[query.length][5];
		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and", "");
			queryArr[i] = query[i].split(" ");
		}
		int num = 0;
		int a, b;

		for (int i = 0; i < queryArr.length; i++) { // qeury 마다 맞는 지원자 찾기
			num = 0;
			for (int j = 0; j < infoArr.length; j++) { // 지원자 하나씩 비교

				for (int k = 0; k < 4; k++) {
					if (!queryArr[i][k].equals("-") && !queryArr[i][k].equals(infoArr[j][k])) {
						break;
					}
					if (k == 3) {
						if (queryArr[i][4].equals("-"))
							num++;
						else {
							a = Integer.parseInt(queryArr[i][4]);
							b = Integer.parseInt(infoArr[j][4]);
							if (b >= a)
								num++;

						}

					}
				}

			}
			answer[i] = num;

		}

		return answer;
	}

}
