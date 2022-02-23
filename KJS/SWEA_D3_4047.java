package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-23, 10분
 * @title 영준이의 카드 카운팅
 */

public class SWEA_D3_4047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수
        int tc = Integer.parseInt(br.readLine());

        for(int T=1; T<= tc; T++){
            sb.append("#").append(T).append(" ");

            String str = br.readLine();

            // 카드가 있는지 정보
            boolean[][] check = new boolean[4][14];

            // flag ( error 체크 )
            boolean flag = true;

            for(int i = 0; i<str.length(); i+=3){
                // 카드 무늬
                char c = str.charAt(i);
                // 카드 숫자
                int num = Integer.parseInt(str.substring(i+1,i+3));

                if(c == 'S'){
                    if(check[0][num]){
                        flag = false;
                        break;
                    }
                    check[0][num] = true;
                }
                else if( c == 'D'){
                    if(check[1][num]){
                        flag = false;
                        break;
                    }
                    check[1][num] = true;
                }
                else if(c == 'H'){
                    if(check[2][num]){
                        flag = false;
                        break;
                    }
                    check[2][num] = true;
                }
                else if(c =='C'){
                    if(check[3][num]){
                        flag = false;
                        break;
                    }
                    check[3][num] = true;
                }
            }

            if(!flag){
                sb.append("ERROR");
            }

            else {
                for (int i = 0; i < 4; i++) {
                    int cnt = 0;
                    for (int j = 0; j < 14; j++) {
                        if (check[i][j]) {
                            cnt++;
                        }
                    }
                    sb.append(13 - cnt).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
