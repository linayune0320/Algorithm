package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_P43164_여행경로 {
	static ArrayList<String> answerList ;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        answerList = new ArrayList<String>();
        boolean visited [] = new boolean [tickets.length]; //방문체크
        dfs(tickets, visited, 0 ,"ICN", "ICN");
        Collections.sort(answerList);
        answer = answerList.get(0).split(" ");
        return answer;
    }

	private void dfs(String[][] tickets, boolean[] visited, int cnt,String country ,  String value) { 
		if(cnt == tickets.length) {
			 answerList.add(value);
			 return ; 
		 }
		for (int i = 0; i < tickets.length; i++) {
			if(!visited[i] && tickets[i][0].equals(country)) {
				visited[i] = true;
				dfs(tickets,visited,cnt+1,tickets[i][1], value+" "+tickets[i][1]);
				visited[i] = false;
			}
			
		}
		
		
	}
	}


