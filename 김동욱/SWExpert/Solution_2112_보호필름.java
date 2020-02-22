package SW_D4;
import java.io.*;
import java.util.*;

public class Solution_2112_보호필름 {
	static int T, D, W, K, cnt;
	static int[][] map;
	static int[][] map2;
	static boolean[] visited;
	static ArrayList<Integer> list;
	static boolean testOk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[D][W];
			visited = new boolean[D];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				int idx = 0;
				while (st.hasMoreTokens()) {
					map[i][idx++] = Integer.parseInt(st.nextToken());
				}
			}

			cnt = 0;
			while (true) {
				testOk = false;
				Arrays.fill(visited, false);
				choiceFilmLayer(0, 0, cnt, visited);
				if (!testOk) {
					cnt++;
				} else {
					break;
				}

			}
			System.out.println("#" + t + " " + cnt);
		}

	}

	private static void copyMap() {
		map2 = new int[D][W];
		for (int i = 0; i < D; i++) {
			System.arraycopy(map[i], 0, map2[i], 0, W);
		}
	}

	private static boolean testFilm(int[][] map) {//검사 시이바라아앙림나ㅓㅣㅏㅓㅁㄴㅇ러ㅣㅏ
		boolean H_flag = true;
		for (int j = 0; j < W && H_flag; j++) {
			int H_cnt = 0;
			for (int i = 0; i < D - 1; i++) {
				if (map[i][j] == map[i + 1][j]) {//같으면 갯수 증가
					H_cnt++;
				} else if (map[i][j] != map[i + 1][j]) {//다르면 초기화
					H_cnt = 0;
				}
				if (H_cnt == K - 1) {//검사 통과하면 중지
					break;
				}
			}
			if(H_cnt < K-1) {//검사 통과 못하면 전체 검사 중지
				H_flag = false;
			}
		}
		if (!H_flag) {
			return false;
		} else {
			return true;
		}

	}

	private static void injectCham(int len) {
		int h = (int) Math.pow(2, len);//갯수를 이진수로 변환
		int[][] b = new int[h][len];
		for (int i = 0; i < h; i++) {
			String y = Integer.toBinaryString(i);
			for (int j = 0; j < y.length(); j++) {
				b[i][len - y.length() + j] = y.charAt(j) - '0';

			}
		}
		for (int i = 0; i < h; i++) {//이진수 배열순서대로 입력
			for (int j = 0; j < len; j++) {
				Arrays.fill(map2[list.get(j)], b[i][j]);
			}

			if (testFilm(map2)) {
				testOk = true;
				break;
			}

		}

	}

	private static void choiceFilmLayer(int start, int count, int R, boolean[] visited) {
		if (count == R) {
			if (R == 0) {//약물을 넣을 필요가 없을 때
				if (testFilm(map)) {
					testOk = true;
				}
			} else {
				list = new ArrayList<>();
				for (int i = 0; i < D; i++) {
					if (visited[i]) {
						list.add(i);
					}
				}
				copyMap();//조작할 두번째맵 생성
				int len = list.size();
				injectCham(len);
			}
			return;
		}
		for (int i = start; i < D; i++) {
			visited[i] = true;
			choiceFilmLayer(i + 1, count + 1, R, visited);
			visited[i] = false;
		}
	}

}
