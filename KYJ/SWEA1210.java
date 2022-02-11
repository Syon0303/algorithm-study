import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class SWEA1210 {
    static int[] dx = {-1, 1, 0};
    static int[] dy = {0, 0, -1};
    static int X;
	static String[][] ladder = new String[100][100];
    
    static void go(int x, int y, int direction) {
    	if(y == 0) { // 사다리 맨 위에 도달했으면 그때의 x값 저장하고 return
    		X = x;
    		return;
    	}
    	
    	if(direction == 2) { // 위로 가는 방향이면
    		for(int i = 0; i < 3; i++) { // !!!좌, 우, 위!!! 순서로 탐색 후
    			if(y+dy[i] >= 0 && x+dx[i] < 100 && x+dx[i] >= 0) {
        			if(ladder[y+dy[i]][x+dx[i]].equals("1")) {
        				go(x+dx[i], y+dy[i], i); // 길이 있으면 이동
        				break; // break를 꼭 해줘야함
        			}
    			}
    		}
    	} else { // 위로 가는 방향이 아닐 때
    		if(x+dx[direction] < 100 && x+dx[direction] >= 0) { // 가던 방향이 배열 벗어나지 않으면
	    		if(!ladder[y+dy[direction]][x+dx[direction]].equals("1")) { // 가던 방향으로 길이 없다면 되돌아가지 않으니까 무조건 위로 방향 바꾸기
	    			direction = 2;
	    		}
    		} else { // 가던 방향이 배열 벗어나면 마찬가지로 되돌아가지 않으니까 위로 방향 바꿔주기
    			direction = 2;
    		}
    		go(x+dx[direction], y+dy[direction], direction);
    	}
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 이 문제는 T 개수 입력받아 for문 돌리는 게 아님에 주의,, 문제 꼼꼼히 읽기!!
        for (int tc = 1; tc <= 10; tc++) {
        	int T = Integer.parseInt(br.readLine());
        	// 사다리 입력 받기
        	for(int i = 0; i < 100; i ++) {
        		ladder[i] = br.readLine().split(" ");
        	}
        	// 마지막 line에서 도착지 X(=2) idx 찾기
        	int idx;
        	for(idx = 0; idx < 100; idx++) {
        		if(ladder[99][idx].equals("2")) break;
        	}
        	
        	// 위에서 찾은 X로부터 위로 올라가면서 사다리 탐색
        	go(idx, 99, 2);
        	System.out.println("#"+T+" "+ X);
        }
    }
}
