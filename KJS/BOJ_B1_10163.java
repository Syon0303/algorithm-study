package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-22, 10분
 * @title 색종이
 *
 */
public class BOJ_B1_10163 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 전체 배열
        int[][] arr = new int[1002][1002];

        // 색종이의 수
        int N = Integer.parseInt(br.readLine());

        // 마지막 범위 찾을 때 시간을 줄이기 위한 변수
        int max_x = 0;
        int max_y = 0;

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            // 배열에 범위 만큼 숫자 넣어주기 ( 첫번째면 1,, 두번째는 2,,, )
            for(int j= x; j< x+weight; j++){
                for(int z = y; z<y+height; z++){
                    arr[j][z] = i;
                }
            }

            max_x = Math.max(max_x, x+weight);
            max_y = Math.max(max_y, y+height);
        }

        // 배열 돌면서 합 구하기
        for(int i=1; i<N+1; i++){
            int sum = 0;
            for(int j=0;j<max_x;j++){
                for(int z=0; z<max_y;z++){
                    if(arr[j][z] == i){
                        sum++;
                    }
                }
            }
            sb.append(sum).append("\n");
        }


        System.out.println(sb);
    }
}
