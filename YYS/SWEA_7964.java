import java.io.*;
import java.util.*;
public class Solution {
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int T = Integer.parseInt(br.readLine());
	for(int t=1; t<=T; t++) {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1]; // N+1 크기의 배열을 만들고 0부터 시작합니다.
		
		st = new StringTokenizer(br.readLine());
		// 1부터 배열 안에 값들을 넣어줍니다
		for(int i=1; i<=N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 카운트 변수와 현재 인덱스를 기록할 now
		int cnt = 0;
		int now = 0;
		boolean construct; //주변에 차원문이 없다면 건설을 해주게 만드는 변수
		
		while(now<=N) {
			construct = true; // 무조건 짓는다고 가정
			
			for(int i=now+D; i>=now+1; i--) { // D만큼 떨어진 곳에서부터 차원문이 있는지 검색
				if(i>N) {
					break; //경계값을 벗어나면 차원문이 필요없으므로 반복문 종료 
				}
				if(arr[i]==1) { // 주변에 차원문이 있다면 굳이 건설 X
					construct=false; // 안짓는다고 명시
					now = i; //차원문을 타고 그 쪽으로 이동
					i=-1; // 반복문 종료
				}
			}
			if(construct) { // 주변에 차원문이 없다면
				now += D; //D만큼 떨어진 곳에 차원문을 세우고
				cnt++; // 1 추가
			}
		}
		cnt--;
		System.out.println("#"+t+" "+cnt);
	}
	
	 
}
}