package programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_P42587_프린터 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < priorities.length; i++) {
        	if(i == location) {
        		q.add(priorities[i]*-1);
        	}else {
        		q.add(priorities[i]);
        	}
	
		}
        while(!q.isEmpty()) {
        int j =q.poll();
        boolean isJ =false ;
        if(j<0) isJ = true;
        j = Math.abs(j);
        Iterator<Integer> iterator = q.iterator();
        boolean flag =false; 
        while(iterator.hasNext()) {
        	if(j < Math.abs(iterator.next())) {
        		flag= true;
        		q.add(isJ ? j*-1 : j);
        		break;
        	}
        }
        if(!flag) {
        	answer++;
        	if(isJ) return answer;
        }  
        }
		return answer;
    }
}
