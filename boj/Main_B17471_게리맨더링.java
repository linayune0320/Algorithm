package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_B17471_게리맨더링 {

	static int map[][]; // 1-N 인접행렬
	static int people[]; // 1-N 구역까지 인구수
	static int N;
	static int area[]; // 1구역이면 해당 Nindex 1 // 0구역이면 해당 Nindex 0
	static int area0[];
	static int area1[];
	static boolean visit0[];
	static boolean visit1[];
	static boolean ans0;
	static boolean ans1;
	static int pick[];
	static LinkedList<Integer> li = new LinkedList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		people = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				int k = Integer.parseInt(st.nextToken());
				map[i][k] = 1;
			}
		} // 입력완료
		if(N==2) {
			System.out.println(Math.abs(people[1]-people[2]));
			return;
		}

		area = new int[N + 1];
		pick = new int[N + 1];

		/* 나눌수 있는 구역의 조합 */
		for (int r = 1; r <= N / 2; r++) {
			combination(N, r, r);
		}

		if (li.size() == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(li);
			System.out.println(li.get(0));
		}

	}

	private static void combination(int n, int index, int r) {

		// 기저조건
		if (index == 0) {

			for (int i = 1; i <= r; i++) {
				area[pick[i]] = 1;

			}
			// 두 구역이 인접한지 확인하는 함수 호출
			make_set(r);

			Arrays.fill(area, 0); // area 초기화
			return;
		}
		if (n < index) {
			return;
		}
		pick[index] = n;
		combination(n - 1, index - 1, r);
		combination(n - 1, index, r);

		return;

	}

	private static void make_set(int r) {
		area1 = new int[r];
		area0 = new int[N - r];
		visit1 = new boolean[N + 1];
		visit0 = new boolean[N + 1];
		int index0 = 0;
		int index1 = 0;
		for (int i = 1; i <= N; i++) {
			if (area[i] == 1) {
				area1[index1] = i;
				index1++;
			} else {
				area0[index0] = i;
				index0++;
			}
		}
		ans0 = false;
		ans1 = false;
		if(area0.length==1) ans0= true;
		if(area1.length==1) ans1=true;
		isnear(area0[0], area1[0]);
		if (ans0 && ans1) {
			int sum1 = 0;
			int sum0 = 0;
			for (int i = 0; i < area0.length; i++) {
				sum0 += people[area0[i]];
			}
			for (int i = 0; i < area1.length; i++) {
				sum1 += people[area1[i]];
			}
			li.add(Math.abs(sum0 - sum1));

		}

	}

	private static void isnear(int current0, int current1) {
		// 기저조건

		for (int i = 0; i < area0.length; i++) {
			if (!visit0[area0[i]])
				break;
			if (i == area0.length - 1)
				ans0 = true;
		}

		for (int i = 0; i < area1.length; i++) {
			if (!visit1[area1[i]])
				break;
			if (i == area1.length - 1)
				ans1 = true;
		}

		// 실행
		visit0[current0] = true;
		for (int i = 0; i < area0.length; i++) {
			if (map[current0][area0[i]] == 1 && !visit0[area0[i]]) {
				visit0[area0[i]] = true;
				isnear(area0[i], current1);
				// visit0[area0[i]]=false;
			}
		}
		visit1[current1] = true;
		for (int i = 0; i < area1.length; i++) {
			if (map[current1][area1[i]] == 1 && !visit1[area1[i]]) {
				visit1[area1[i]] = true;
				isnear(current0, area1[i]);
				// visit1[area1[i]]=false;
			}
		}
		// 호출

	}

}
