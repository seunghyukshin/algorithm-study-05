package BJ;

import java.io.*;
import java.util.*;

public class Main_BJ_4485_녹색옷입은애가젤다지 {

	static int[][] map, value;
	static int N, cnt;
	static boolean flag;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };// 사방탐색

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0));
		value[0][0] += map[0][0] + 1;//초기 map의 값을 value에 입력 // 초기에 -1로 초기화해놔서 1을 더해줘야한다
		while (!q.isEmpty()) {
			Point p = q.poll();
			int sy = p.y;
			int sx = p.x;

			for (int d = 0; d < 4; d++) {
				int ny = sy + dy[d];
				int nx = sx + dx[d];// 사방탐색
			
				if (check(ny, nx)) {//범위내에 있고
					if (value[ny][nx] == -1//탐색하지 않았고, 탐색한 값이 이전에 저장되어있던 값보다 작으면
							|| (value[sy][sx] + map[ny][nx]) < value[ny][nx]) {//이때부터는 value값에 있는 -1이 영향이 없다
						q.offer(new Point(ny, nx));//큐에 넣고
						value[ny][nx] = value[sy][sx] + map[ny][nx];//큐에 넣은 좌표에 대한 value값을 갱신
					}
				}
			}
		}
	}

	private static boolean check(int ty, int tx) {
		if (ty >= 0 && ty < N && tx >= 0 && tx < N) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		cnt = 0;
		while (true) {
			N = Integer.parseInt(in.readLine());
			if (N == 0) {
				break;
			}
			map = new int[N][N];
			value = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int idx = 0;
				while (st.hasMoreTokens()) {
					map[i][idx++] = Integer.parseInt(st.nextToken());
				}
			} // 주어진 지도 작성

			for (int i = 0; i < N; i++) {
				Arrays.fill(value[i], -1);
			} // 도둑루피 합 지도

			bfs();
			cnt++;
			System.out.println("Problem " + cnt + ": " + value[N - 1][N - 1]);
		}

	}

	
}
