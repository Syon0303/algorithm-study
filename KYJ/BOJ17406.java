import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 {
	static int ans = Integer.MAX_VALUE;	// answer
	static int N, M, K;					// Arr 크기, 회전 연산 개수
	static int[][] Arr;
    static int[][] rotates;				// 회전 연산 정보 r, c, s
    static boolean[] visited;
    static int[] result;				// 순열을 담을 배열
	
    // 회전연산 순서(순열) 구하기
	public static void permutation(int idx, int K) {
        if(idx == K) {
            int[][] map = new int[N][M]; // Arr 깊은 복사
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < M; j++) {
        			map[i][j] = Arr[i][j];
        		}
        	}
            rotate(map);				// 회전시키기 + 값 구하기
            return;
        }
        
        for(int i = 0; i < K; i++) {	// 순열 구하기
            if(visited[i] == false) {
                visited[i] = true;
                result[idx] = i;
                permutation(idx + 1, K);
                visited[i] = false;
            }
        }
    }
	
	// rotate + min 값 계산
	public static void rotate(int[][] map) {
		for(int tc = 0; tc < result.length; tc++) {	// 순열
			int r = rotates[result[tc]][0];
			int c = rotates[result[tc]][1];
			int s = rotates[result[tc]][2];
			
			int X = c-s;							// 회전시킬 가장 왼쪽 위 X
			int Y = r-s;							// 회전시킬 가장 왼쪽 위 Y
			int a = 2*s+1;							// 회전시킬 정사각형 한 변의 길이
			int iteration = s+1; 					// 껍데기 수
			int x, y, temp, prev, flag = 1;
			for(int i = 0; i < iteration; i++) { 	// 껍데기 회전시키기
				x = i+X;
				y = i+Y;
				prev = map[y][x];					// 해당 껍데기의 가장 왼쪽 위에 있는 item 기준으로
				for(int j = 0; j < 2; j++) { 		// 우 -> 하 -> 좌 -> 상 회전
					for(int k = 0; k < a - i*2 - 1; k++) {
						x += flag;
						temp = map[y][x];
						map[y][x] = prev;
						prev = temp;
					}
					for(int k = 0; k < a - i*2 - 1; k++) {
						y += flag;
						temp = map[y][x];
						map[y][x] = prev;
						prev = temp;
					}
					flag *= -1;
				}
			}
		}
		
		// 회전시킨 Arr 값 구하기
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < M; j++) {
				sum += map[i][j];
			}
			ans = Math.min(sum, ans);
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 배열 크기 N, M
		M =  Integer.parseInt(st.nextToken());
		K =  Integer.parseInt(st.nextToken());	// 회전 연산 개수 K
		
		Arr = new int[N][M];	// 회전 시킬 배열 Arr
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				Arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotates = new int[K][3];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rotates[i][0] = Integer.parseInt(st.nextToken()) - 1;	// r
			rotates[i][1] = Integer.parseInt(st.nextToken()) - 1;	// c
			rotates[i][2] = Integer.parseInt(st.nextToken());		// s
		}

		visited = new boolean[K];
        result = new int[K];
        permutation(0, K);

		System.out.println(ans);
	}
}
