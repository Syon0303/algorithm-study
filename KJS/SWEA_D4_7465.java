package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-22, 15분
 * @title 창용 마을 무리의 개수
 */

public class SWEA_D4_7465 {
    static StringTokenizer st;
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 번호
        int tc = Integer.parseInt(br.readLine());

        for(int T=1; T<=tc; T++){
            sb.append("#").append(T).append(" ");
            st = new StringTokenizer(br.readLine(), " ");


            // 사람의 수
            N = Integer.parseInt(st.nextToken());
            // 관계 수
            int M = Integer.parseInt(st.nextToken());

            makeSet();
            for(int i = 0; i<M; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                // 집합 합치기
                unionSet(start, end);
            }

            // 집합 개수 구하기
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=1; i<=N; i++){
                int temp = findSet(i);
                if(list.contains(temp)){
                    continue;
                }
                list.add(temp);
            }
            sb.append(list.size()).append("\n");

        }
        System.out.println(sb);
    }


    // 사람들 그룹 정의
    static void makeSet(){
        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = i;
        }
    }

    static boolean unionSet(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot){
            return false;
        }

        arr[bRoot] = aRoot;
        return true;
    }

    static int findSet(int a){
        if(a == arr[a]){
            return a;
        }
        arr[a] = findSet(arr[a]);
        return arr[a];
    }
}
