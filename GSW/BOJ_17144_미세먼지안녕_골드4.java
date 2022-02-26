import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Queue;

public class BOJ_17144_미세먼지안녕_골드4 {
	
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int [] m = new int[2]; //공기청정기 y좌표 저장할 배열
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
		int[][]map = new int[R][C]; //현재 상태
		int[][]tempMap = new int[R][C]; //미세먼지 퍼지는 거 저장배열
		
		int total =0;
		int index=0;
		//입력
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0) total+=map[i][j];
				if(map[i][j]==-1) {
					m[index] = i;
					index++;
				}
			}
		}
		
		//시간만큼
		for(int t=0;t<T;t++) {
			//확산
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(map[i][j]>0) { //먼지가 있으면
						int dust = map[i][j]/5; //퍼질 먼지의 양
						for(int k=0;k<4;k++) {
							int nextX = j+dx[k]; 
							int nextY = i+dy[k];
							//퍼질공간이 범위 안쪽이고 공기청정기가 아니라면
							if(nextX>=0&&nextX<C&&nextY>=0&&nextY<R&&!(map[nextY][nextX]==-1)) {
								tempMap[nextY][nextX] += dust; //퍼질 먼지 임시저장
								map[i][j] -=dust; //퍼진 먼지만큼 빼기
							}
						}
					}
				}
			}
			
			//임시저장했던 퍼진먼지 합산
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					map[i][j]+=tempMap[i][j];
					tempMap[i][j]=0;
				}
			}	

			
			//제거되는 먼지가 있는 곳은 공기청정기의 위쪽 아래쪽 항상동일
			//해당 위치에 있는 먼지양 만큼 전체 먼지양에서 빼주기
			total = total - map[m[0]-1][0] -map[m[1]+1][0];
			
			//공기청정기 작동
			//반시계방향 이동
			for(int i=m[0]-1;i>0;i--) {
				map[i][0] = map[i-1][0];
			}
			for(int i=0;i<C-1;i++) {
				map[0][i] = map[0][i+1];
			}
			for(int i=0;i<m[0];i++) {
				map[i][C-1] = map[i+1][C-1];
			}
			for(int i=C-1;i>1;i--) {
				map[m[0]][i] = map[m[0]][i-1];
			}
			map[m[0]][1]= 0;
			
			//시계방향 이동
			for(int i=m[1]+1;i<R-1;i++) {
				map[i][0] = map[i+1][0];
			}
			for(int i=0;i<C-1;i++) {
				map[R-1][i] = map[R-1][i+1];
			}
			for(int i=R-1;i>m[1];i--) {
				map[i][C-1] = map[i-1][C-1];
			}
			for(int i=C-1;i>0;i--) {
				map[m[1]][i] = map[m[1]][i-1];
			}	
			map[m[1]][1] = 0;
		}		
		System.out.println(total);
	}
}