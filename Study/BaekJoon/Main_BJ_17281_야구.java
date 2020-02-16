package BJ_GOLD;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BJ_17281_야구 {
	static int[][] I; 
	static int[] P; 
	static boolean[] used; 
	static int N; 
	static int ans; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		I = new int[N][9];
		

		for (int i = 0; i < N; i++) {//이닝
			StringTokenizer st = new StringTokenizer(in.readLine());
			int idx=0;
			while(st.hasMoreTokens()) {
				I[i][idx++] = Integer.parseInt(st.nextToken());
			}
			
		}

		used = new boolean[9];
		P = new int[9];

		used[0] = true; 
		P[3] = 0; //순서 고정

		perm(0); //순서를 생각한 뽑기 -> 순열

		System.out.println(ans);
	}

	static void perm(int idx) {
		if (idx == 9) {
			int score = game();//순서를 떼와서 여기서 하는게 편하다 <- 이거 생각하기가 어려웠음

			ans = Math.max(ans, score); // 더 큰 점수가 생기면 갱신

			return;
		}

		if (idx == 3) { //1번 선수 순서 고정 -> 다음으로
			perm(idx + 1);
			return;
		}

		for (int i = 1; i < 9; i++) {//1번이 순서 고정이므로 제외 (i=1)
			if (!used[i]) {
				P[idx] = i; 
				used[i] = true; 
				perm(idx + 1); 
				used[i] = false; 
			}
		}
	}

	static int game() {
		int score = 0;
		int hitS = 0; // 치는 순서

		for (int i = 0; i < N; i++) {
			int out = 0;
			int[] base = new int[4];//베이스

			while (true) {//게임시작
				if (out == 3) // out cnt = 3이면 게임 종료
					break;

				switch (I[i][P[hitS]]) {
				case 1://1루타
					score += base[3];
					base[3] = base[2];
					base[2] = base[1];
					base[1] = 1;
					break;
				case 2://2루타
					score += base[3] + base[2];
					base[3] = base[1];
					base[2] = 1;
					base[1] = 0;
					break;
				case 3://3루차
					score += base[3] + base[2] + base[1];
					base[3] = 1;
					base[2] = 0;
					base[1] = 0;
					break;
				case 4://홈런
					score += base[3] + base[2] + base[1] + 1;
					base[3] = 0;
					base[2] = 0;
					base[1] = 0;
					break;
				case 0://아웃
					out++;
					break;
				}
				hitS = (hitS + 1) == 9 ? 0 : hitS + 1;//현재 번호에 따라 처음으로 다시 또는 그냥 다음 순서
			}
		}

		return score;
	}
}
