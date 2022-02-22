package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-21, 10분
 * @title DFS와 BFS
 */

public class BOJ_S2_1260{
    static int N;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");

        // 정점의 개수
        N = Integer.parseInt(st.nextToken());

        // 간선의 개수
        int M = Integer.parseInt(st.nextToken());

        // 정점의 번호
        int V = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 배열에 입력
            arr[start][end] = arr[end][start] = 1;
        }


        dfs(arr, new boolean[N+1], V);
        System.out.println();
        bfs(arr, new boolean[N+1], V);


    }
    public static void dfs(int[][] arr, boolean[] visited, int start){

        visited[start] = true;
        System.out.print(start + " ");

        for(int i=1; i<=N; i++){
            if(!visited[i] && arr[start][i] != 0){
                dfs(arr, visited, i);
            }
        }

    }


    public static void bfs(int[][] arr, boolean[] visited,int start){

        Queue<Integer> queue = new LinkedList<Integer>();

        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");
            for(int i=1; i<=N; i++){
                if(!visited[i] && arr[current][i] != 0){
                    queue.offer(i);
                    visited[i] =true;
                }
            }


        }




    }

}