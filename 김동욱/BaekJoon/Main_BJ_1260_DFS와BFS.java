package BJ_SIVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS와BFS {
	static int nodeCnt;// 노드 개수
	static LinkedList<Integer>[] nodeList;// 노드간의 연결을 표현하기 위한 LinkedList사용

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		nodeCnt = Integer.parseInt(st.nextToken());
		int lineCnt = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		nodeList = new LinkedList[nodeCnt + 1];// 노드정보를 저장하기위한 LinkedList배열

		for (int i = 0; i <= nodeCnt; i++) {
			nodeList[i] = new LinkedList<Integer>();//주의!! 노드갯수만큼 객체를 생성
		}

		for (int i = 0; i < lineCnt; i++) {
			st = new StringTokenizer(in.readLine());

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			nodeList[node1].add(node2);// 노드간 연결상태 입력
			nodeList[node2].add(node1);

			Collections.sort(nodeList[node1]);// 낮은숫자의 노드부터 방문하므로 정렬
			Collections.sort(nodeList[node2]);
		}

		StringBuilder dfsResult = new StringBuilder();
		StringBuilder bfsResult = new StringBuilder();

		boolean[] dfsVisited = new boolean[nodeCnt + 1];// 방문여부를 파악하기 위한 boolean배열
		boolean[] bfsVisited = new boolean[nodeCnt + 1];

		dfs(start, dfsVisited, dfsResult);
		bfs(start, bfsVisited, bfsResult);

		System.out.println(dfsResult + "\n" + bfsResult);
	}

	public static void dfs(int node, boolean[] visited, StringBuilder sb) {
		if (visited[node])
			return;

		visited[node] = true;
		sb.append(node + " ");

		for (int nextNode : nodeList[node]) {
			dfs(nextNode, visited, sb);
		}
	}

	public static void bfs(int node, boolean[] visited, StringBuilder sb) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(node);

		while (!queue.isEmpty()) {
			node = queue.poll();

			if (visited[node])
				continue;
			visited[node] = true;
			sb.append(node + " ");

			for (int nextNode : nodeList[node]) {
				queue.add(nextNode);
			}
		}
	}

}
