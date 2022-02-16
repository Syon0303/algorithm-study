import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA6808 {
	static int win;
	static int lose;
	static ArrayList<Integer> K;	// 규영이 카드
	static ArrayList<Integer> I;	// 인영이 카드
	static boolean[] visited;		// 순열 구할 때 사용할 visited 배열
    static int[] result;			// 순열을 담을 배열
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			K = new ArrayList<>();
			for(int i = 0; i < 9; i++) K.add(Integer.parseInt(st.nextToken()));
			I = new ArrayList<>();
			for(int i = 1; i <= 18; i++) if(!K.contains(i)) I.add(i);
			visited = new boolean[9];
			result = new int[9];
			win = 0;
			lose = 0;
			permutation(0);
			System.out.println("#"+tc+" "+win+" "+lose);
		}
		
 	}
	
	public static void game(int[] result) {
		int k = 0, i = 0;
		for(int r = 0; r < 9; r++) {
			if(K.get(r) > result[r]) k += K.get(r) + result[r];
			else i += K.get(r) + result[r];
		}
		if(k > i) win++;
		if(k < i) lose++;
	}

	public static void permutation(int idx) {	// 순열 구하기
		if(idx == 9) {
			game(result);
		}
		for(int i = 0; i < 9; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                result[idx] = I.get(i);
                permutation(idx + 1);
                visited[i] = false;
            }
        }
	}
}
