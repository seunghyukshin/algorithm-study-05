package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2567_색종이2 {
	// map을 0을 초기화해서 종이가 덮이는 지역을 1로 입력한 뒤, 색종이가 덮인 외벽의 길이를 센다
	static int xi, yi, cnt;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		int[][] map = new int[102][102];

		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], 0);
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			xi = Integer.parseInt(st.nextToken());
			yi = Integer.parseInt(st.nextToken());

			for (int j = yi + 1; j < yi + 11; j++) {
				for (int k = xi + 1; k < xi + 11; k++) {
					map[j][k] = 1;

				}
			}
		}
		int Answer = 0;
		for (int i = 1; i <= 101; i++) {
			for (int j = 1; j <= 101; j++) {
				if (map[i][j] == 0) {// 색종이 외부를 센다
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];

						if ((ny >= 1 && ny <= 101) && (nx >= 1 && nx <= 101) && map[ny][nx] == 1)
							Answer++;
					}
				}
			}
		}
		System.out.println(Answer);

	}

}
