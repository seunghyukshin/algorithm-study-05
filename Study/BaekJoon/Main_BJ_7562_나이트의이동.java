package BJ_SIVER;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_7562_나이트의이동 {
	static int T, I, cnt;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> queue;
	static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };// 팔방 이동

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			I = Integer.parseInt(in.readLine());
			map = new int[I][I];

			StringTokenizer st = new StringTokenizer(in.readLine());
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());// 입력 순서 조심

			StringTokenizer st2 = new StringTokenizer(in.readLine());
			int gx = Integer.parseInt(st2.nextToken());
			int gy = Integer.parseInt(st2.nextToken());

			visited = new boolean[I][I];// 방문여부

			bfs(cx, cy, gx, gy);

			System.out.println(map[gy][gx]);// 목표지점 값 출력

		}

	}

	private static void bfs(int cx, int cy, int gx, int gy) {
		queue = new LinkedList<Point>();
		visited[cy][cx] = true;// 일단 하나 방문
		queue.offer(new Point(cy, cx));// 현재위치 저장

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int sy = point.y;
			int sx = point.x;

			if (sy == gy && sx == gx) {// 도착했으면
				break;// 종료
			}
			for (int d = 0; d < 8; d++) {// 이동
				int ny = sy + dy[d];
				int nx = sx + dx[d];
				if (ny >= 0 & ny < I && nx >= 0 && nx < I && !visited[ny][nx]) {// 방문하지 않았다면
					visited[ny][nx] = true;// 방문한것으로 처리하고
					map[ny][nx] = map[sy][sx] + 1;// 이동횟수를 누적
					queue.offer(new Point(ny, nx));// 다음 갈곳을 큐에 집어넣음
				}
			}
		}
	}
}
