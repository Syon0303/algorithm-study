package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-16, 10분
 * @title ATM, 실버3
 */
public class BOJ_11399 {
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 사람 수
        int N = Integer.parseInt(br.readLine());

        // 사람 배열
        ArrayList<Integer> list = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int sum = 0;
        int idx = 1;
        while(idx<N+1){
            for(int i=0; i<idx;i++){
                sum += list.get(i);
            }
            idx++;
        }

        sb.append(sum);
        System.out.println(sb);


    }
}
