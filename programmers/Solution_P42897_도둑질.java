package programmers;

import java.util.*;

class Solution_P42897_도둑질 {
    static int answer;
    static int visitMax[][];
    public int solution(int[] money) {
        visitMax = new int [money.length][2];
        answer = 0;
        visitMax[0][0] = 0; // 첫번재 방문안한것
        visitMax[0][1] = money[0];  // 첫번째 방문한것 
        visitMax[1][0] = money[1];
        visitMax[1][1] = money[0]; 
        for(int i=2; i<money.length ; i++){
             visitMax[i][0] = Math.max(visitMax[i-2][0]+money[i] , visitMax[i-1][0]);
        } 
        for(int i=2; i<money.length-1 ; i++){
            visitMax[i][1] = Math.max(visitMax[i-2][1]+money[i] , visitMax[i-1][1]);
        }

        answer = Math.max(visitMax[money.length-1][0] , visitMax[money.length-2][1]);


        return answer;
    }


}