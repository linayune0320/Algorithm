package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_P42626_더맵게 {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> q  = new PriorityQueue<Integer>();
        if(scoville[1]==0 && K!=0) return -1 ;
        for (int i = 0; i < scoville.length; i++) {
				q.add(scoville[i]);
		}
        int a ;
        int first ; 
        while(!q.isEmpty() && q.peek() < K) {
        	if(q.size()==1 && q.poll() < K) return -1;
        	first = q.poll();
        	a = first +q.poll()*2;
        	answer++;
        	if( first  < K  ) {
        		q.add(a);
        	};
        	if(!q.isEmpty()&&q.peek()>K) return answer ; 
        }
        return (!q.isEmpty()&&q.peek()<K ? -1 : answer);
    }
}
