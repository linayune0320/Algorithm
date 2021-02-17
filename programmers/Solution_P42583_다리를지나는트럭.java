package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_P42583_다리를지나는트럭 {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < truck_weights.length; i++) {
			q.add(truck_weights[i]);
		}
		Queue<Integer> bridge = new LinkedList<Integer>();
		int sum = 0;
		int in =0 ; 
		while (true) {
			if(sum == truck_weights.length && in == 0)break;
			
			answer++;
			if(bridge.size()==bridge_length) {
				in -= bridge.peek();
				bridge.poll();
			}
			
			if(sum < truck_weights.length && in + q.peek()<= weight ) {
				bridge.add(q.peek());
				in += q.poll();
				sum++;
			}else {
				bridge.add(0);
			}
		}

		return answer;
	}

}
