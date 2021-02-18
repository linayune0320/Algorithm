package programmers;

public class Solution_P42842_카펫 {
	
	  public int[] solution(int brown, int yellow) {
	      int x = (int) Math.sqrt(yellow+brown) +1;

	      int [] answer = new int [2] ; 
	      for (int i = 1; i <=x; i++) {
	        for (int j = i; j <=yellow+brown; j++) {
	            if(i*j == yellow+brown && 2*(i+j-2)==brown) {
	                answer[0]=  j ;
	                answer[1] = i;
	                break;
	                } 
	            }
	        }
	      return answer ; 
	    }




}
