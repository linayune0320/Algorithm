package programmers;

import java.util.Stack;

public class Solution_주식가격 {

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Market> stack = new Stack<Market>();
		for (int i = 0; i < prices.length - 1; i++) {
			stack.add(new Market(i, prices[i]));
			while (!stack.isEmpty() && stack.peek().price > prices[i + 1]) {
				answer[stack.peek().index] = i + 1 - stack.peek().index;
				stack.pop();

			}
		}
		while (!stack.isEmpty()) {
			answer[stack.peek().index] = prices.length - stack.peek().index - 1;
			stack.pop();
		}
		return answer;
	}

	class Market {
		int index;
		int price;

		public Market(int index, int price) {
			this.index = index;
			this.price = price;
		}
	}

}