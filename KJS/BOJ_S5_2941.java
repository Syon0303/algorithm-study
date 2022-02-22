package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-21, 15분
 * @title 크로아티아 알파벳
 */

public class BOJ_S5_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String str = br.readLine();

        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 문자 시작이 c 고 크기는 벗어나지 않을 때 ( 다음 것까지 체크하기 때문에 -1 )
            if (c == 'c' && i < str.length() - 1) {
                // c=, c-
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    // 2글자에 한 알파벳이기 때문에 i++
                    i++;
                }
            }

            // d-
            else if (c == 'd' && i < str.length() - 1) {
                if (str.charAt(i + 1) == '-') {
                    i++;
                } else if (str.charAt(i + 1) == 'z' && i < str.length() - 2) {
                    // dz=
                    if (str.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            }


            // lj, nj
            else if ((c == 'l' || c == 'n') && i < str.length() - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            }

            // s=, z=
            else if ((c == 's' || c == 'z') && i < str.length() - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }

            // 알파벳 개수 + , 변경할 수 있는 알파벳이 아닌 것들도 +
            res++;
        }


        System.out.println(res);
    }
}
