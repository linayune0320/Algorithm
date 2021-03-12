package programmers;
import java.util.*;
public class Solution_P43238_입국심사 {

	 public long solution(int n, int[] times) {

	        Arrays.sort(times);
	        long answer = (long)times[0]*n;
	        long right = (long)times[0]*n; // 걸리는 시간의 최대값 
	        long left = 1 ; //최소값 

	        while(left <= right){
	            long mid = (left+right)/2;
	            long people = 0 ; // 시간 mid 일때 맡을수있는 사람수           
	            for(int i=0 ; i< times.length ; i++){
	                people +=  mid / (long)times[i]; 
	            }
	            if(people < (long) n){ //n명보다 적으면
	                left = mid +1 ;                
	            }else {                
	                right = mid-1; 
	                answer = mid;
	            }           
	        }

	        return answer;
	    }
}
