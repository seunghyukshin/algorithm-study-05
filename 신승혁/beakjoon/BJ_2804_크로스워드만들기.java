import java.io.*;
import java.util.Arrays;

public class BJ_2804_크로스워드만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		char[] c1 = s[0].toCharArray();
		char[] c2 = s[1].toCharArray();
		int N = c1.length;
		int M = c2.length;
		int sameNumA = 0;
		int sameNumB = 0;
		boolean flag = true;
		for (int i = 0; i < c1.length && flag; i++) {
			for (int j = 0; j < c2.length && flag; j++) {
				if (c1[i] == c2[j]) {
					sameNumA = i;
					sameNumB = j;
					flag = false;
				}
			}
		}
		char[][] map = new char[M][N];

		for (int i = 0; i < M; i++) {
			Arrays.fill(map[i], '.');
		}

		for (int i = 0; i < N; i++) {
			map[sameNumB][i] = c1[i];
		}

		for (int i = 0; i < M; i++) {
			map[i][sameNumA] = c2[i];
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
