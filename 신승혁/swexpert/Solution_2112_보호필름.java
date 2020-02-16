import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * nCr * 2^r
 *
 */
public class Solution_2112_보호필름 {
	// 0 : A
	// 1 : B
	static String[][] map;
	static int D;
	static int W;
	static int K;
	static boolean flag;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			D = Integer.parseInt(s[0]); // 행
			W = Integer.parseInt(s[1]); // 열
			K = Integer.parseInt(s[2]); // 합격기준
			map = new String[D][W];
			for (int d = 0; d < D; d++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int i = 0; i < W; i++) {
					map[d][i] = st.nextToken();
				}
			}
			// 여기까지 입력받는 부분

			flag = false;
			if (K == 1) { // 성능검사 안해도됨
				flag = true;
			}
				
			// r개 선택
			result = 0;
			for (int r = 0; r < D && !flag; r++) {
				if(r == K) { // k개만큼 바꿔주면 그냥 됨!
					flag = true;
					result = r;
					break;
				}
//				System.out.println(" << r >> " + r);
				nCr(0, 0, r);
				result = r;
			}
			System.out.println("#" + t + " " + result);

//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map[i].length; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}

		}

	}

	// TODO nCr 내에서 nPr? No
	// 123행을 바꿀건데 000으로 바꿔보고 001, 010, .. 으로 바꿔야함
	// if:count=r에서x for문에서! 
	// R : 1, 2, 3, ...
	private static void nCr(int start, int count, int R) {
		
		if (count == R) {
			if (check(K))
				flag = true;
//			print();
			return;
		}
		// nCr에서 고른 부분을 0이나 1로 바꾸주고 다시 원래대로 복구
		// 시간 오래잡은 부분은 깊은복사를안하고 얕은복사를해서 모두 1이 되버림.
		// clone is 깊복
		for (int i = start; i < D; i++) {
			for (int j = 0; j <= 1; j++) { // 0으로 한번 바꿔주고 1로한번 바꿔주고
				String[] temp = map[i].clone();
				change(i, j, map);
				nCr(i + 1, count + 1, R);
				map[i] = temp; // 덮어쓰기가 안된다..

			}
		}
	}

//	private static void print() {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

	// i: 바꿀 행, num: 0 or 1로 바꾸겠다
	private static void change(int i, int num, String[][] arr) {
		for (int j = 0; j < W; j++) {
			arr[i][j] = String.valueOf(num);
		}
	}

	// 성능 검사
	// true면 k개일 때 통과임
	private static boolean check(int k) {
		boolean isTrue = true;

		// k만큼의 연속된 "0"과 "1"을 String으로 만들어줌
		StringBuilder sb0 = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb0.append("0");
			sb1.append("1");
		}

		for (int i = 0; i < W; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < D; j++) {
				sb.append(map[j][i]);
			}
			String s = String.valueOf(sb);
			if (s.contains(sb0) || s.contains(sb1)) {
			} else { // 각 열의 String을 이어붙힌게 "000"이나 "111"이 없으면
				isTrue = false;
				break;
			}
		}
		return isTrue;
	}
}
