package SW_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_6719_성수의프로그래밍강좌시청 {
	static int T, N, K;
	static float ans;
	static int[] M;
	static boolean[] visited;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			M = new int[N];
			visited = new boolean[N];

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				M[i] = Integer.parseInt(st.nextToken());
			}

			ans = 0;

			Arrays.sort(M);

			for (int i = 0; i < N - K+1; i++) {
				float tmp = 0;
				for (int j = i; j < K+i; j++) {
					tmp = (tmp + M[j]) / 2;
					
				}
				ans = Math.max(ans, tmp);
			}

			System.out.print("#" + t + " ");
			System.out.printf("%.6f", ans);
			System.out.println();

		}
	}

}
