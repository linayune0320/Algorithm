package programmers;

import java.util.ArrayList;

public class Solution_P42578_위장 {

	public static int solution(String[][] clothes) {
		int answer = 1;
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < clothes.length; i++) {
			if (!list.contains(clothes[i][1])) {
				list.add(clothes[i][1]);
			}
		}
		int clothesType[] = new int[list.size()];
		for (int i = 0; i < clothes.length; i++) {
			clothesType[list.indexOf(clothes[i][1])]++;
		}
		
		for (int i = 0 ; i < clothesType.length; i++) {
			answer *=  (clothesType[i]+1);
		}
		

		return answer-1;
	}

	

}
