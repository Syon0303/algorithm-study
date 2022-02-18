import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
        static int size = 9, arr[], gy[], iy[], res_g = 0, res_i = 0;
        static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            gy = new int[size+1];
            iy = new int[size+1];
            visited = new boolean[size*2+1];
            arr = new int[size+1];
            StringTokenizer stn = new StringTokenizer(br.readLine());
            // 규영 카드 순서 받기
            for (int j = 1; j <= size; j++) {
                gy[j] = Integer.parseInt(stn.nextToken());
                visited[gy[j]] = true;
            }
            // 인영 카드 배열 입력
            int cnt = 1;
            for (int j = 1; j <= size * 2; j++) {
                if(visited[j]) continue;
                iy[cnt] = j;
                cnt++;
            }
            //visited 재사용
            visited = new boolean[size+1];
 
            Permutation(1); // 순열 재귀
            System.out.println("#"+i+" "+res_g+" "+res_i);
            res_g = 0; res_i = 0;
        }
    }
     
    public static void Permutation(int cnt) {
    	// 9개가 선택되었으면
        if(cnt == size+1) {
            int gy_s = 0, iy_s = 0; // 규영이 점수, 인영이 점수
            for (int i = 1; i <= size; i++) {
            	// 낸 숫자 비교해 점수 계산 (각 카드)
                if(gy[i] > arr[i]) {
                    gy_s += gy[i] + arr[i];
                }else if(gy[i] < arr[i]) {
                    iy_s += gy[i] + arr[i];
                }
            }
            // total 점수 더 큰 쪽을 win 점수 1 증가
            if(gy_s > iy_s) {
                res_g++;
            }else if(gy_s < iy_s){
                res_i++;
            }
            return;
        }
         
        for (int i = 1; i <= size; i++) {
            if(visited[i]) {
                continue;
            }
            arr[cnt] = iy[i];
            visited[i] = true;
            Permutation(cnt+1);
            visited[i] = false;
        }
    }
}