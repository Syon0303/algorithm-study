package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/***
 *
 * @author us13579
 * @since 2022-02-17,20분
 * @title 딱지놀이, 브론즈1
 */

public class BOJ_14696 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 라운드 수
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String res = "";
            st = new StringTokenizer(br.readLine(), " ");

            int A_size = Integer.parseInt(st.nextToken());
            ArrayList<Integer> A = new ArrayList<Integer>();

            for(int j=0; j<A_size; j++){
                A.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine(), " ");

            int B_size = Integer.parseInt(st.nextToken());
            ArrayList<Integer> B = new ArrayList<Integer>();

            for(int j= 0; j<B_size; j++){
                B.add(Integer.parseInt(st.nextToken()));
            }

            // 내림차순 정렬
            Collections.sort(A, Collections.reverseOrder());
            Collections.sort(B, Collections.reverseOrder());

            // A사이즈가 더 큰경우
            if(A.size()>B.size()){
                for(int j=0; j<A.size();j++){
                    if(A.get(j)>B.get(j)){
                        res += "A";
                        break;
                    }
                    else if(A.get(j)<B.get(j)){
                        res += "B";
                        break;
                    }
                    // 같은 경우
                    else{
                        if(j == (B.size()-1)){
                            res += "A";
                            break;
                        }
                        continue;
                    }
                }
            }
            // B 사이즈가 더 큰경우
            else if(A.size()<B.size()){
                for(int j=0; j<B.size();j++){
                    if(A.get(j)>B.get(j)){
                        res += "A";
                        break;
                    }
                    else if(A.get(j)<B.get(j)){
                        res += "B";
                        break;
                    }
                    // 같은 경우
                    else{
                        if(j == (A.size()-1)){
                            res+="B";
                            break;
                        }
                        continue;
                    }
                }
            }
            // 사이즈가 같은 경우
            else{
                for(int j=0; j<A.size();j++){
                    if(A.get(j)>B.get(j)){
                        res += "A";
                        break;
                    }
                    else if(A.get(j)<B.get(j)){
                        res += "B";
                        break;
                    }
                    // 같은 경우
                    else{
                         if(j == (A.size()-1)){
                             res+="D";
                             break;
                         }
                         continue;
                    }
                }
            }

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

}
