import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B16637_괄호추가하기 {
	
	static int N ; 
	static int [] number;
	static String [] opr;
	static int max = Integer.MIN_VALUE;


	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		number = new int [N/2+1]; //숫자 담는 배열 
		opr = new String[N/2]; // 연산자 담는 배열 
		
		int nCount = 0;
		int oCount = 0; 
		
		String[] token = str.split("");
		for (int i = 0; i <N; i++) {
			if(i%2==0) {//짝수
				number[nCount++] = Integer.parseInt(token[i]);
			}else {
				opr[oCount++]= token[i];
			}
		}
		solve(0,number[0]);
		
		System.out.println(max);
	}
	// index번째 연산자수행, save = 지금까지 계산한값 
	private static void solve(int index, int save) {
		if(index == N/2) {
			max= Math.max(max, save);
			return ;
		}
		
		int result = cal(save,opr[index],number[index+1]);
		
		
		solve(index+1,result);
		
		
		if(index+1<N/2) {
			result = cal(save, opr[index], cal(number[index+1], opr[index+1], number[index+2]));
		    solve(index+2,result);

		}
	}
	private static int cal(int num1, String operator, int num2) {
int ret = 0;
		
		switch(operator) {
		case "+":
			ret = num1 + num2;
			break;
			
		case "-":
			ret = num1 - num2;
			break;

		case "*":
			ret = num1 * num2;
			break;
		}
		
		return ret;



	}

	
}
