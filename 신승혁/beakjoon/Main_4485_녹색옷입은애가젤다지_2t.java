package beakjoon;

import java.awt.Point;
import java.io.*;
import java.util.*;

// 간다음에 확인하는게 아니라 가기전에 확인하고 들어가겠다.
// Point 클래스 두 변수만 사용하기

// pass

public class Main_4485_녹색옷입은애가젤다지_2t {
	static int[][] map;
	static int[][] valueMap;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;
	static int TC;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TC = 1;
		do {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}

			map = new int[N][N];
			valueMap = new int[N][N];
			for (int i = 0; i < valueMap.length; i++) {
				Arrays.fill(valueMap[i], -1);

			}

			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < s.length; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			Queue<Point> queue = new LinkedList<>();
//			int minValue = Integer.MAX_VALUE;
			queue.offer(new Point(0, 0));
			valueMap[0][0] = map[0][0];
			while (!queue.isEmpty()) {
				Point nowPoint = queue.poll();
				int nowY = nowPoint.y;
				int nowX = nowPoint.x;
				int nowValue = valueMap[nowY][nowX];
//				if (minValue < nowValue) {
//					continue;
//				}
////				 minValue 했을 때 276ms 안했을때 364ms
//
//				if (nowX == N - 1 && nowY == N - 1) {
//					if (minValue < nowValue) {
//						minValue = nowValue;
//					}
//					continue;
//				}
				for (int d = 0; d < dx.length; d++) {
					int nextX = nowX + dx[d];
					int nextY = nowY + dy[d];
					if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N
							&& (valueMap[nextY][nextX] > nowValue + map[nextY][nextX]
									|| valueMap[nextY][nextX] == -1)) {
						valueMap[nextY][nextX] = nowValue + map[nextY][nextX];
						queue.offer(new Point(nextX, nextY));
					}
				}
			}
			System.out.println("Problem " + (TC++) + ": " + valueMap[N-1][N-1]);
		} while (true);

		br.close();
	}

}
