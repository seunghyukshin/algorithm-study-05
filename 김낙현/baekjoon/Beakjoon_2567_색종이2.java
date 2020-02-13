package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_2567_색종이2 {

	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		int[][] map = new int[102][102]; // 색종이를 표시할 2차원 배열
		boolean[][] check = new boolean[102][102]; // 이미 탐색했는지 체크할 배열
		int[][] tri = new int[T][2]; // 사각형의 좌표를 저장할 배열

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			y++;
			x++;
			tri[t][0] = y; // 색종이의 y 좌표 저장
			tri[t][1] = x; // 색종이의 x 좌표 저장
			
			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					map[i][j]++; // 색종이영역을 표시 > 색종이 영역은 1, 겹치는 부분은 1이 아님
				}
			}
		}
		int cnt = 0;

		for (int i = 0; i < T; i++) {
			int y_start = tri[i][0]; // 하나의 색종이의 y 좌표
			int x_start = tri[i][1]; // 하나의 색종이의 x 좌표

			for (int j = y_start; j < y_start + 10; j++) {
				for (int k = x_start; k < x_start + 10; k++) {
					for (int d = 0; d < 4; d++) { // 4방향을 탐색
						int ny = j + dy[d];
						int nx = k + dx[d];
						// 해당 좌표 주변에 0이 있으면 가장 자리 라는 뜻
						if (ny >= 0 && ny < 102 && nx >= 0 && nx < 102 
								&& map[ny][nx] == 0 && check[j][k] == false) {
							cnt++; // 가장자리 카운트 증가
						}
					}
					check[j][k] = true; // 해당좌표를 방문했다고 체크
				}
			}
		}

		System.out.println(cnt); // 출력
	}
}
