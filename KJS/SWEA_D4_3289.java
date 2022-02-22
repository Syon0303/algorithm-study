package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/***
 * @author us13579
 * @since 2022-02-22, 30분
 * @title 서로소 집합
 */


public class SWEA_D4_3289 {
    static StringTokenizer st;
    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수
        int tc = Integer.parseInt(br.readLine());

        for (int T = 1; T <= tc; T++) {
            st = new StringTokenizer(br.readLine(), " ");
            sb.append("#").append(T).append(" ");

            // 집합 수
            n = Integer.parseInt(st.nextToken());

            // 연산의 개수
            m = Integer.parseInt(st.nextToken());

            makeSet();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int cal = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());



                // 합집합
                if (cal == 0) {
                    unionSet(a, b);
                }

                // 확인
                else if (cal == 1) {
                    if (findSet(a) == findSet(b)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void makeSet(){
        arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = i;
        }
    }


    // a 집단과 b 집단 합치기 -> 0
    static boolean unionSet(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        // 같은 집합 인 경우
        if (aRoot == bRoot) {
            return false;
        }
        arr[bRoot] = aRoot;

        return true;
    }

    // a가 포함된 대표자 찾기 -> 1
    static int findSet(int a) {
        if (a == arr[a]) {
            return a;
        }
        // 경로 압축
        arr[a] = findSet(arr[a]);
        // 현재위치의 부모값 반환
        return arr[a];
    }
}
