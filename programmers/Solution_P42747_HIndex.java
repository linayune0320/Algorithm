package programmers;

import java.util.Arrays;

public class Solution_P42747_HIndex {
	
	public int solution(int[] citations) {
        int answer = -1;
        int size = citations.length ; 
        Arrays.sort(citations);
        for(int i=0 ; i< size ; i++){
              if(size-i <= citations[i]){
                  if(size-i > answer){
                      answer = size-i;
                  }
              }
        }
        return answer ==-1 ? 0 : answer;
    }
	

}
