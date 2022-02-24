package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-25, 10분
 * @title 요세푸스 문제
 */
public class BOJ_S5_1158 {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        st = new StringTokenizer(br.readLine(), " ");

        // 사람수
        int N = Integer.parseInt(st.nextToken());

        // 순서
        int K =Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<Integer>();

        sb.append("<");
        // 큐에 삽입
        for(int i=1; i<N+1; i++){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            for(int i=0;i<K-1;i++) {
                queue.add(queue.poll());
            }
            if(queue.size()==1){
                sb.append(queue.poll()).append(">");
            }
            else {
                sb.append(queue.poll()).append(", ");
            }
        }

        System.out.println(sb);



    }

}
