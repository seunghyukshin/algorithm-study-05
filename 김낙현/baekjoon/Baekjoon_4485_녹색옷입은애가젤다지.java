package test;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_4485_����������ְ������� {

	static int[] dx = { 0, 0, -1, 1 }; // �����¿�
	static int[] dy = { -1, 1, 0, 0 }; // �����¿�
	static int Answer, N;
	static int[][] map;
	static int[][] lp;
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int test_case = 1;
		while (true) {
			N = Integer.parseInt(in.readLine());
			Answer = 0;
			if (N == 0)
				break;

			map = new int[N][N];
			lp = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(lp[i], -1);
			}

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int idx = 0;
				while (st.hasMoreTokens()) {
					map[i][idx++] = Integer.parseInt(st.nextToken());
				}
			}

			q = new LinkedList<>();
			move2(new Point(0, 0), map[0][0]);

			System.out.println("Problem " + (test_case++) + ": " + lp[N - 1][N - 1]);
		}

	}

	public static void move2(Point p, int sum) {
		q.offer(p);
		lp[0][0] = sum;

		while (!q.isEmpty()) {
			Point temp = q.poll();
			int y = temp.y; // ���� y ��ǥ
			int x = temp.x; // ���� x ��ǥ
			int val = lp[y][x];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d]; // �̵��� y ��ǥ
				int nx = x + dx[d]; // �̵��� x ��ǥ

				// �̵��� ������ ���� ������ ������ ������ ���� ������ ����
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && (lp[ny][nx] > (map[ny][nx] + val) || lp[ny][nx] == -1)) {
					lp[ny][nx] = map[ny][nx] + val;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}
}