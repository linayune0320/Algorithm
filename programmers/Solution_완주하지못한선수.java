package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_완주하지못한선수 {

	    public String solution(String[] participant, String[] completion) {
	    	Queue<String> q = new PriorityQueue<String>();
	    	Queue<String> q1 = new PriorityQueue<String>();
	    	q.add(participant[participant.length-1]);
	        for(int i =0 ; i <participant.length-1 ; i++){
	        	q.add(participant[i]);
	        	q1.add(completion[i]);
	        }
	       String a , b ;  
	        for (int i = 0; i < completion.length; i++) {
	        	a = q.poll();
	        	b = q1.poll();
	        	if(!a.equals(b)) {
	        		return a;
	        	}
			}
			return q.poll();

	}

}


