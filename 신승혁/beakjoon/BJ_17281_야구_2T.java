import java.io.*;
import java.util.*;

// 9시 start
public class BJ_17281_야구_2T {
	static int size = 8;
	static int[][] map;
	static int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
	static boolean[] base;
	static int inningPoint = 0;
	static int inningOut = 0;
	static int N;
	static int R;
	static int result;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 이닝 수
		R = 8;
		map = new int[N][size + 1];
		base = new boolean[4]; // 0: 홈 1:1루 2:2루 3:3루
		result = Integer.MIN_VALUE;
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < size + 1; i++) {
				map[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		nPr(0);
		System.out.println(result);
	}

	private static void nPr(int count) {
		if (count == size) {
			// 타순 배열리스트
			list = new ArrayList<Integer>();
			for (int i : nums) {
				list.add(i);
			}
			list.add(3, 0); // 1번호를 4번타자로

			int sum = 0;
			int start = -1; // 타석에 나올 사람
			for (int i = 0; i < N; i++) {
				inningPoint = 0;
				inningOut = 0;
				Arrays.fill(base, false);
				while (true) {
					start = (start + 1) % 9;
					int playerNum = list.get(start);
					hit(map[i][playerNum]);
					if (inningOut == 3) {
						break;
					}
				}
				sum += inningPoint;
			}
			result = Math.max(sum, result);
			return;
		}
		for (int i = count; i < size; i++) {
			swap(i, count);
			nPr(count + 1);
			swap(i, count);
		}
	}

	private static void swap(int i, int count) {
		int temp = nums[i];
		nums[i] = nums[count];
		nums[count] = temp;
	}

	// point:타점
	public static void hit(int point) {
		if (point == 0) { // 아웃
			inningOut++;
		} else if (point == 4) { // 홈런
			int cnt = 1;
			for (int i = 0; i < 4; i++) {
				if (base[i]) {
					cnt++;
					base[i] = false;
				}
			}
			inningPoint += cnt;
		} else { // 1 2 3
			for (int i = 3; i > 0; i--) {
				if (base[i]) {
					int nextRu = i + point;
					if (nextRu > 3) {
						inningPoint++;
						base[i] = false;
					} else {
						base[nextRu] = true;
						base[i] = false;
					}
				}

			}
			base[point] = true;
		}
	}
}
/*
 * 2
 * 
 * 4 3 2 1 0 4 3 2 1
 *
 * 1 2 3 4 1 2 3 4 0
 */