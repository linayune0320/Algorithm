package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_S4408_자기방으로돌아가기 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int p [][] ;
        int from=0 ;
        int to=0;
        int T = Integer.parseInt(br.readLine().trim());
        for(int tc =1; tc<=T;tc++) {
        int room[] = new int [201];
        int N= Integer.parseInt(br.readLine().trim());
        p= new int [N][2];
     
        StringTokenizer st;
        for(int i=0; i<N; i++) {
             
        st = new StringTokenizer(br.readLine());
        from= Integer.parseInt(st.nextToken());
        to= Integer.parseInt(st.nextToken());
         
        if(from>to) {
            int temp= from;
            from = to;
            to=temp;
        }
        if (from%2==0) --from;
        if(to%2==0) --to;
         
            from=(from/2)+1;
            to=(to/2)+1;
            for(int j=from; j<=to ;j++) {
                room[j]++;
                 
            }
         
            }// 입력완료
        int maxcount = 0;
        for(int i =1; i<=200;i++) {
            if(maxcount<room[i]) {
                maxcount = room[i];
            }
        }
             
    System.out.println("#"+tc+ " "+maxcount);
        }
    }
 
}