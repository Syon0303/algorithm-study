package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-16, 15분
 * @title 가랏! RC카!, D2
 *
 */
public class SWEA_1940 {
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트케이스
        int tc = Integer.parseInt(br.readLine());

        for(int T = 1; T<=tc; T++){
            sb.append("#").append(T).append(" ");

            // 이동한 거리
            int res = 0;

            // 입력 개수
            int N = Integer.parseInt(br.readLine());

            // 속도
            int speed = 0;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine(), " ");
                int command = Integer.parseInt(st.nextToken());
                switch (command){
                    case 0:
                        break;

                    case 1:
                        speed += Integer.parseInt(st.nextToken());
                        break;

                    case 2:
                        int temp = Integer.parseInt(st.nextToken());
                        if(speed<temp){
                            speed = 0;
                        }
                        else {
                            speed -= temp;
                        }
                        break;
                }
                res += speed;

            }
            sb.append(res).append("\n");

        }
        System.out.println(sb);
    }
}
