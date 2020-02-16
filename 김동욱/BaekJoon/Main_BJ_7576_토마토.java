
import java.io.*;
import java.util.*;

public class Main_BJ_7576_토마토 {
	// 익은 토마토가 두개인 경우...어떻게 처리할까
	// 큐에 동시에 offer를 하면 동시에 돈다고??
	static int M, N;
	static int[][] map, visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int cnt;

	public static class Point {//awt Point 쓰면 패맞어
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}


	public static boolean check(int ty, int tx) {//범위 내에 있냐 메소드
		if (tx >= 0 && tx < M && ty >= 0 && ty < N) {
			return true;
		} else
			return false;
	}

	// BFS
	public static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					visited[i][j] = 1;
					queue.offer(new Point(i, j));//현재 좌표 큐에 넣기
				}
				if (map[i][j] == -1) {//-1이면 무시하고 다음으로
					continue;
				}
			}
		}

		while (!queue.isEmpty()) {
			Point p = queue.poll();//하나 빼서
			int sy = p.y;
			int sx = p.x;//헷갈리지 않게 조심 //awt Point를 쓰면 반대로 넣어야한다 // 쓰지마 패맞어
			map[sy][sx] = 1;//현재위치를 1로 만들고 // 이걸 올리지 않으면 아래조건에 의해 되돌아간다
			
			for (int k = 0; k < 4; k++) {
				int nx = sx + dx[k];
				int ny = sy + dy[k];//사방 탐색

				if (check(ny, nx) && map[ny][nx] == 0 && visited[ny][nx] == 0) {//범위를 안벗어나고, 안익은토마토이고,방문하지 않았으면
					queue.offer(new Point(ny, nx));//다음 좌표를 큐에 넣기
					visited[ny][nx] = visited[sy][sx] + 1;//몇번째인지 표시
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		M = Integer.parseInt(st.nextToken());// 가로
		N = Integer.parseInt(st.nextToken());// 세로

		map = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int idx = 0;
			while (st.hasMoreTokens()) {
				map[i][idx++] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		
		int max = -1;//비교를 위한 기준 // -1은 활동하지않는다
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {//bfs돌렸는데도 안익은 놈이 있으면
					flag = false;//false
				}
				max = Math.max(max, visited[i][j]);//비교해서 맥스값에 넣기
			}
		}
		if (!flag) {//안익은 놈이 남아있다?
			System.out.println(-1);
		} else {
			System.out.println(max -1 );//시작을 1로 해놔서 1을 빼줌

		}

	}

}
