import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

// fail
public class BJ_2567_색종이2_2t {
	static int[][] map;
	static final int mapSize = 102;
	static final int paperLen = 10;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[mapSize][mapSize];
		for (int n = 0; n < N; n++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			sum = 0;

			for (int i = 0; i < paperLen; i++) {
				for (int j = 0; j < paperLen; j++) {
					map[y + i][x + j]++;
				}
			}
		}
//		for (int i = 0; i < mapSize; i++) {
//			for (int j = 0; j < mapSize; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				if (map[i][j] !=0 ) {
					for (int d = 0; d < 4; d++) {
						int x = j + dx[d];
						int y = i + dy[d];
						if (map[y][x] == 0) {
							sum++;
						}
					}
				}
			}
		}
		System.out.println(sum);
	}
}
