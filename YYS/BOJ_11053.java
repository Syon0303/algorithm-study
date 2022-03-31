import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int MAX = 1;
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken()); // 0인덱스에 숫자 기록, 1에 누적 기록
            arr[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j][0] < arr[i][0] && arr[j][1] + 1 > arr[i][1]) {
                    arr[i][1] = arr[j][1] + 1;
                    MAX = Math.max(MAX, arr[i][1]);
                }
            }
        }
        System.out.println(MAX);
    }
}