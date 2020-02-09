package backjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 9시 10분 시작. 10시 6분 종료

public class Main_1260_DFS와BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int V = Integer.parseInt(s[2]);

        Point[] lines = new Point[M]; // 연결된 간선 담은 배열
        boolean[] visitPoint = new boolean[N + 1]; // 방문 check 배열
        Stack<Integer> stack = new Stack<>();
        for (int m = 0; m < M; m++) {
            String[] ss = br.readLine().split(" ");
            lines[m] = new Point(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
        }

        stack.push(V);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            // 방문했으면 다음 Point
            if (visitPoint[v]) {
                continue;
            }
            visitPoint[v] = true;
            System.out.print(v + " ");
            ArrayList<Integer> list = new ArrayList<>();
            // 연결된점 찾아서 list에 담아서 오름차순
            for (int i = 0; i < M; i++) {
                if (lines[i].x == v) {
                    list.add(lines[i].y);
                } else if (lines[i].y == v) {
                    list.add(lines[i].x);
                }
            }
            Collections.sort(list, new SC());
            // 연결된 점들 중에서 방문 안한 점만 push
            for (int i : list) {
                if (!visitPoint[i]) {
                    stack.push(i);
                }
            }
        }

        System.out.println();
        Arrays.fill(visitPoint, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (visitPoint[v]) {
                continue;
            }
            visitPoint[v] = true;
            System.out.print(v + " ");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                if (lines[i].x == v) {
                    list.add(lines[i].y);
                } else if (lines[i].y == v) {
                    list.add(lines[i].x);
                }
            }
            Collections.sort(list);
            for (int i : list) {
                if (!visitPoint[i]) {
                    queue.offer(i);
                }
            }
        }


    }

    private static class SC implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
