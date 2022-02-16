package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-16, 30분
 * @title 집합, 실버5
 */

public class BOJ_11723 {
    static StringTokenizer st;
    static int check_res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 수행해야할 연산의 수
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[21];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "add":
                    int num = Integer.parseInt(st.nextToken());
                    arr[num] = num ;
                    break;
                case "remove":
                    arr[Integer.parseInt(st.nextToken())] = 0;
                    break;
                case "check":
                    int num_2 = Integer.parseInt(st.nextToken());
                    if(arr[num_2]==num_2){
                        check_res = 1;
                    }
                    else{
                        check_res = 0;
                    }
                    sb.append(check_res).append("\n");
                    break;
                case "toggle":
                    int temp = Integer.parseInt(st.nextToken());
                    if(arr[temp] == temp){
                        arr[temp] = 0;
                    }
                    else if(arr[temp] == 0){
                        arr[temp] = temp;
                    }
                    break;
                case "all":
                    for(int j=1; j<21; j++){
                        arr[j] = j;
                    }
                    break;
                case "empty":
                    for(int j=1;j<21;j++){
                        arr[j]=0;
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
