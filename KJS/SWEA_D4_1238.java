package SWEA;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-21, 50분
 * @title Contact
 *
 */
public class SWEA_D4_1238 {
    static StringTokenizer st;
    static int N;
    static int[][] arr;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=10; tc++){
            sb.append("#").append(tc).append(" ");

            // 데이터 길이
            N = sc.nextInt();

            // 시작점
            int first = sc.nextInt();

            // 간선 정보 저장 배열
            arr = new int[101][101];

            // 몇번째로 연락받았는지 체크
            visited = new int[101];

            for(int i =0; i<N/2; i++){
                // 방향성이 있다
                arr[sc.nextInt()][sc.nextInt()] = 1;
            }

            bfs(first);

          // 최댓값 구하기
            int maxCnt = Integer.MIN_VALUE;
            int maxIdx = Integer.MIN_VALUE;
            for(int i=1; i<101; i++){

                // 가지치기
                if(visited[i]==0){
                    continue;
                }
                // 제일 많은 cnt구하기
               maxCnt = Math.max(visited[i], maxCnt);
                if(maxCnt == visited[i]){
                    maxIdx = Math.max(maxIdx, i);
                }
            }


            sb.append(maxIdx).append("\n");
        }
        System.out.println();
        System.out.println(sb);
    }

    public static void bfs(int start){

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(start);
        visited[start] = 1;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i=1; i<101; i++) {
                if (visited[i]==0 && arr[current][i] != 0) {
                        queue.offer(i);
                        visited[i] = visited[current]+1;
                }
            }
        }
    }
}
