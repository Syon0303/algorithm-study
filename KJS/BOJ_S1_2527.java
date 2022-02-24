package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-23, 1시간
 * @title 직사각형
 */


public class BOJ_S1_2527 {
    static StringTokenizer st;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 4; t++) {

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());


            int minX = Math.min(x1, x2); // 입력받은 x좌표의 최솟값
            int maxX = Math.max(p1, p2); // 입력받은 x좌표의 최댓값
            int minY = Math.min(y1, y2); // 입력받은 y좌표의 최솟값
            int maxY = Math.max(q1, q2); // 입력받은 y좌표의 최댓값

            int width1 = p1 - x1; // 첫번째 직사각형의 가로 길이
            int height1 = q1 - y1; // 첫번째 직사각형의 세로 길이
            int width2 = p2 - x2; // 두번째 직사각형의 가로 길이
            int height2 = q2 - y2; // 두번째 직사각형의 세로 길이


            // 선
            if (((width1+width2 == maxX-minX) && (height1+height2 > maxY-minY)) || ((height1+height2 == maxY-minY) && (width1+width2 > maxX-minX)))
                sb.append("b");
            // 점
            else if ((width1+width2 == maxX-minX) && (height1+height2 == maxY-minY))
                sb.append("c");
            // 없는 경우
            else if ((width1+width2 < maxX-minX) || (height1+height2 < maxY-minY))
                sb.append("d");
            // 직사각형
            else
                sb.append("a");

            sb.append("\n");
        }
        System.out.println(sb);
    }
}