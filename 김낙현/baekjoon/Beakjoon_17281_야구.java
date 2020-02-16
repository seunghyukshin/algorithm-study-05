package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Beakjoon_17281_야구 {
	static ArrayList<Integer> re2;
	static int point, max, N;
	static int[][] inn;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		inn = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int idx = 0;
			while (st.hasMoreTokens()) {
				inn[i][idx++] = Integer.parseInt(st.nextToken());
			}
		}

		re2 = new ArrayList<>();
		point = 0;
		max = -1;
		perm(0, 0);
		System.out.println(max);

	}

	private static void perm(int flag, int count) {
		if (count == 8) {
			// 선수 순서 정하고
			re2.add(3, 1);
			game(re2); // 게임시작
			max = Math.max(max, point);
			re2.remove((Integer) 1);
			return;
		}

		for (int i = 0; i < 8; i++) {
			if ((flag & (1 << i)) == 0) {
				re2.add(i + 2);
				perm((flag | (1 << i)), count + 1);
				re2.remove((Integer) (i + 2));
			}
		}
	}

	private static void game(ArrayList<Integer> plist) {
		int outCount = 0;
		point = 0;
		ArrayList<Integer> pos = new ArrayList<>();
		int i = 0;
		int num = 0;
		int len = 0;
		while (i != N) {
			if (num == 9)
				num = 0;
			int hit = inn[i][plist.get(num) - 1];
			switch (hit) {
			case 1:
				// System.out.println("안타 !!");
				pos.add(0);
				len = pos.size();
				for (int j = len - 1; j >= 0; j--) {
					pos.set(j, pos.get(j) + 1);
					if (pos.get(j) >= 4) {
						point++;
						pos.remove(j);
					}
				}
				break;
			case 2:
				// System.out.println("2루타 !!");
				pos.add(0);
				len = pos.size();
				for (int j = len - 1; j >= 0; j--) {
					pos.set(j, pos.get(j) + 2);
					if (pos.get(j) >= 4) {
						point++;
						pos.remove(j);
					}
				}
				break;
			case 3:
				// System.out.println("3루타 !!");
				pos.add(0);
				len = pos.size();
				for (int j = len - 1; j >= 0; j--) {
					pos.set(j, pos.get(j) + 3);
					if (pos.get(j) >= 4) {
						point++;
						pos.remove(j);
					}
				}
				break;
			case 4:
				// System.out.println("홈런 !!");
				pos.add(0);
				len = pos.size();
				point += len;
				pos.clear();
				break;
			case 0:
				// System.out.println("아웃 !!");
				outCount++;
				break;

			default:
				break;
			}
			num++;
			if (outCount == 3) {
				// System.out.println("3 아웃!!!!!!");
				outCount = 0;
				pos.clear();
				i++;
			}
		}
	}
}
