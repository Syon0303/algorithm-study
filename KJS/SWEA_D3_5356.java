package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-26, 15분
 * @title 의석이의 세로로 말해요
 */

public class SWEA_D3_5356 {
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());


        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            char[][] arr = new char[5][15];

            // 입력
            for(int i=0; i<5; i++) {
                String str =br.readLine();
                for(int j=0;j<str.length(); j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            // 출력
            for(int i=0; i<15; i++){
                for(int j=0; j<5; j++){
                    if(arr[j][i] != 0){
                        sb.append(arr[j][i]);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
