package programmers;

import java.util.*;

public class Solution_P42884_단속카메라 {
	 public int solution(int[][] routes) {
	        int answer = 1;
	        int min = Integer.MAX_VALUE;
	        ArrayList<Car> list = new ArrayList<Car>();
	        for(int i=0 ; i <routes.length ; i++){
	            list.add(new Car(routes[i][0] ,routes[i][1]));
	        }
	        Collections.sort(list);
	        for (int i = 0; i < list.size(); i++) {
				Car car = list.get(i);
				if(min < car.s) {
					answer ++;
					min = car.e;
				}else {
					min  = Math.min(min, car.e);
				} 
			}
	        
	        return answer;
	    }

}
class Car implements Comparable<Car>{
    int s ; 
    int e ;
    public Car(int s, int e ){
        this.s = s ; 
        this.e = e ; 
    }
	@Override
	public int compareTo(Car o) {
		if(this.s==o.s) {
			return this.e-o.e;
		}
		return this.s-o.s;
	}
}
