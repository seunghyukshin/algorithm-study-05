import java.io.*;
import java.util.*;

// int 이차원배열  (메모리초과 ) >> boolean 이차원배열 
// 메모리 초과

public class BJ_7576_토마토 {
	static int[][] map;
	static boolean[][] visitMap;
	static int answer;
	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { 1, -1, 0, 0 };
	// 1: 익은토마토
	// 0: 안익은 토마토
	// -1: 비어있음

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]); // 6 :j :x
		int N = Integer.parseInt(s[1]); // 4 :i :y
		map = new int[N][M];
		visitMap = new boolean[N][M];
		Queue<Point> queue = new LinkedList<>();
		answer = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visitMap[i][j] = false;
				if (map[i][j] == 1) { // 토마토1 offer
					queue.offer(new Point(j, i, 0));
					visitMap[i][j] = true;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		
		while (!queue.isEmpty()) {
			Point nowPoint = queue.poll();
			int nowX = nowPoint.x;
			int nowY = nowPoint.y;
			int nowDay = nowPoint.day;
			max = Math.max(max, nowDay);
			for (int d = 0; d < dx.length; d++) {
				int nextX = nowX + dx[d];
				int nextY = nowY + dy[d];
				if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && map[nextY][nextX] == 0
						&& !visitMap[nextY][nextX]) {
					visitMap[nextY][nextX] = true;
					queue.offer(new Point(nextX, nextY, nowDay + 1));
				}
			}
		}

		boolean flag = true;
		for (int i = 0; i < N && flag; i++) {
			for (int j = 0; j < M && flag; j++) {
				if (!visitMap[i][j] && map[i][j] == 0) {
					max = -1;
					flag = false;
				}
			}
		}
		System.out.println(max);

	}

	private static class Point {
		int x;
		int y;
		int day;

		public Point(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}

	}

}
