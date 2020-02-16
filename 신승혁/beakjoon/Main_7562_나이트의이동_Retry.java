package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// visitMap : boolean -> int
public class Main_7562_나이트의이동_Retry {
    static int[] dx = {2, 2, 1, -1, -2, -2, -1, 1};
    static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int[][] visitMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int l = Integer.parseInt(br.readLine());// 체스판 한변의 길이
            String[] s = br.readLine().split(" ");
            // 나이트가 현재 있는칸
            int startX = Integer.parseInt(s[0]);
            int startY = Integer.parseInt(s[1]);

            String[] s2 = br.readLine().split(" ");
            // 나이트가 이동하려고하는 칸
            int goalX = Integer.parseInt(s2[0]);
            int goalY  = Integer.parseInt(s2[1]);

            visitMap = new int[l][l];

            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(startX, startY, 0));
            int minDist = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                Point nowPoint = queue.poll();
                if (nowPoint.dist >= minDist) {
                    continue;
                }
                if (nowPoint.y == goalY && nowPoint.x == goalX) {
                    int nowDist = nowPoint.dist;
                    if (nowDist < minDist) {
                        minDist = nowDist;
                        //System.out.println("find!!" + minDist );
                    }
                } else {
                    for (int d = 0; d < 8; d++) {
                        int nextY = nowPoint.y + dy[d];
                        int nextX = nowPoint.x + dx[d];
                        if (nextY >= 0 && nextX >= 0 && nextX < l && nextY < l) {
                            int nextDist = nowPoint.dist+1;
                            if(visitMap[nextY][nextX] < nextDist){
                                visitMap[nextY][nextX] = nextDist;
                                queue.offer(new Point(nextX, nextY, nextDist));
                            }
                        }
                    }
                }
            }

            System.out.println(minDist);

        }
    }

    public static class Point {
        int x;
        int y;
        int dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
