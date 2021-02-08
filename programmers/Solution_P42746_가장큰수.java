package programmers;

import java.util.*;

class Solution_P42746_가장큰수 {
    public String solution(int[] number) {

    	List<Num> numbers = new ArrayList<Num>();
    	boolean flag =false; 
    	for (int i = 0; i < number.length; i++) {
    		numbers.add(new Num(number[i]+""));
    		if(number[i]!=0) flag = true;
		}
    	if(!flag) return "0";
    	
    	Collections.sort(numbers);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
			answer.append(numbers.get(i).num+"");
		}
        return answer.toString();
    }
}

class Num implements Comparable<Num>{
	String num; 
	
	public Num(String num) {
		this.num = num;
	}

	@Override
	public int compareTo(Num o) {
		
        String a = this.num+o.num;
        String b = o.num+this.num;
       
		return a.compareTo(b)*-1;

	}
}
