package programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution_전화번호목록 {

	public boolean solution(String[] phone_book) {
		Map<Integer, String> hm = new HashMap<Integer, String>();
		for (int i = 0; i < phone_book.length; i++) {
			hm.put(i, phone_book[i]);
		}
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book[i].length(); j++) {
				if (hm.containsValue(phone_book[i].substring(0, j))) {
					return false;
				}
			}

		}

		return true;
	}

}
