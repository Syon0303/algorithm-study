import java.io.*;
import java.util.*;
public class Main {
	static int R,C,map[][][];
	// 3차원 배열을 이용해 현재의 모습을 map[][][0]에 저장하고 미래의 모습을 map[][][1]에 저장했습니다
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int[] machine = new int[2]; // 기계 위치 행은 모르지만 열은 0 고정
	
	static void Misae() { // 미세먼지가 퍼지는 메서드
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				
				if(map[i][j][0]>0) { // 미세먼지가 0보다 크면
					
					int origin = map[i][j][0]; // 현재 미세먼지의 먼지양을 기록하고
					int spread = origin/5; //퍼지는 양을 계산
					
					for(int k=0; k<4; k++) { //4방 이동 (배열 좌표 이용)
						int row = i+dx[k];
						int col = j+dy[k];
						
						if(row<0 || row>=R || col<0 || col>=C ||
								(col ==0 &&(row==machine[0] || row==machine[1]))) {
							continue;
						} //4 방향으로 가기 전 가지치기 부분 : 경계값이거나 공기청정기부분
						
						map[row][col][1] += spread; // 미래의 값에 퍼진 양 더해주기
						
						origin -= spread; //현재 먼지양에서 그만큼 빼주기
					}
					map[i][j][1] += origin; // 최종 먼지양을 미래의 값에 기록
				}
			}
		}
	}
	
	static void circulation() {
		//바람을 불어오는 방향으로 기록해가면 꼭지점을 따로 저장할 필요X
		
		for(int i=machine[0]-1; i>=1; i--) { //왼쪽 위 바람 들어오는 바람부터
			map[i][0][1] = map[i-1][0][1];
		}
		
		for(int i=machine[1]+1; i<R-1; i++) { //왼쪽 아래 
			map[i][0][1] = map[i+1][0][1];
		}
		
		for(int j=0; j<C-1; j++) { //맨 끝 위 아래 들어오는 바람 묶어서 표현
			map[0][j][1] = map[0][j+1][1];
			map[R-1][j][1] = map[R-1][j+1][1];
		}
		
		for(int i=0; i<machine[0]; i++) { //오른쪽 위로 올라가는 바람
			map[i][C-1][1] = map[i+1][C-1][1];
		}
		
		for(int i=R-1; i>=machine[1]; i--) { // 오른쪽 아래로 내려가는 바람
			map[i][C-1][1] = map[i-1][C-1][1];
		}
		
		
		for(int j=C-1; j>=2; j--) { // 공기청정기 오른쪽으로 나가는 바람(묶어서)
			map[machine[0]][j][1] = map[machine[0]][j-1][1];
			map[machine[1]][j][1] = map[machine[1]][j-1][1];
		}
		
		map[machine[0]][1][1] = 0; //기계 바로 앞 먼지 제거 
		map[machine[1]][1][1] = 0; //기계 바로 앞 먼지 제거2
	}
	
	static void Res() { //미래의 값을 현재의 값에 저장하는 메서드
		for(int i=0; i<R; i++) {
			for(int j =0; j<C; j++) {
				map[i][j][0] = map[i][j][1];
				map[i][j][1] = 0;
			}
		}
	}
	
	static void Check1() { // 중간 결과 확인용 메서드
		System.out.println("-------------------");
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j][0]+" ");
			}
			System.out.println();
		}
	}
	static void Check2() { // 중간 결과 확인용 메서드2 
		System.out.println("-------------------");
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j][1]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C][2]; //3차원배열 크기에 맞게 생성
		
		//입력값 넣어주기
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j][0]=Integer.parseInt(st.nextToken());
			}
		}
		
		//공기청정기 위치 찾아주기
		for(int j=0; j<R; j++) {
			if(map[j][0][0]==-1) {
				machine[0] = j;
				machine[1] = j+1;
				j=R;
			}
		}
		
		//시간이 1초 지날 때마다 : [먼지 확산] - [순환] - [미래값->현재값] 반복
		for(int t=0; t<T; t++) {
			Misae();
		//	Check2();
			circulation();
		//	Check2();
			Res();
		}
		
		//결과 도출 부분
		int sum=0;
		
		// 마지막으로 저장된 현재값에서 먼지의 양을 가져온다: map[][][0]
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j][0]==-1)continue;
				sum += map[i][j][0];
			}
		}
		System.out.println(sum);
	}
}