import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int R, C, cnt = 1, max;
	static char[][] map;
	static ArrayList<Character> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stn.nextToken());
		C = Integer.parseInt(stn.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			stn = new StringTokenizer(br.readLine());
			map[i] = stn.nextToken().toCharArray();
		}
		list = new ArrayList<Character>();
		move(0, 0);
		System.out.println(max);
	}
	
	public static void move(int r, int c) {
		list.add(map[r][c]);
		// 오른쪽 이동 검증
		boolean pass = true;
		for (int i = 0; i < list.size(); i++) {
			// 오른쪽이 경계 밖이거나 오른쪽 알파벳이 이미 지나갔던 알파벳이면
			if(c+1 >= C || map[r][c+1] == list.get(i)) {
				pass = false;
				break;
			}
		}
		// 오른쪽 이동
		if(pass) {
			cnt++;
			move(r, c+1);
		}
		
		// 아래쪽 이동 검증
		pass = true;
		for (int i = 0; i < list.size(); i++) {
			// 아래쪽이 경계 밖이거나 오른쪽 알파벳이 이미 지나갔던 알파벳이면
			if(r+1 >= R || map[r+1][c] == list.get(i)) {
				pass = false;
				break;
			}
		}
		// 아래쪽 이동
		if(pass) {
			cnt++;
			move(r+1, c);
		}
		
		// 위쪽 이동 검증
		pass = true;
		for (int i = 0; i < list.size(); i++) {
			// 위쪽이 경계 밖이고 오른쪽 알파벳이 이미 지나갔던 알파벳이면
			if(r-1 < 0 || map[r-1][c] == list.get(i)) {
				pass = false;
				break;
			}
		}
		// 위쪽 이동
		if(pass) {
			cnt++;
			move(r-1, c);
		}
		
		// 왼쪽 이동 검증
		pass = true;
		for (int i = 0; i < list.size(); i++) {
			// 왼쪽이 경계 밖이고 오른쪽 알파벳이 이미 지나갔던 알파벳이면
			if(c-1 < 0 || map[r][c-1] == list.get(i)) {
				pass = false;
				break;
			}
		}
		// 왼쪽 이동
		if(pass) {
			cnt++;
			move(r, c-1);
		}
		
		// 깊이 계산
		max = Math.max(max, cnt);
		// 원상 복구 (백트랙킹)
		list.remove(list.size()-1);
		cnt--;
	}
}