import java.util.*;

public class Main {
	static int[] answer = new int[7]; //7명의 난쟁이 선택
	static int[] arr = new int[9]; // 총 9명의 난쟁이 값을 받기
	
	static void dfs(int idx, int cnt, int sum) {
		if(idx==9) { //9에 도달하면 return으로 종료시켜야 합니다
        
			if(sum==100 && cnt==7) { //합이 100이면서 동시에 7명이라면 정답이므로 출력
				for(int i=0; i<7; i++) {
					System.out.println(answer[i]);
				}
			}
			return;
		}
        
		dfs(idx+1,cnt,sum); // 현재 난쟁이를 선택X
		
		if(cnt<7)answer[cnt]=arr[idx]; //8명을 넘게 선택한 경우 오류 발생
        
		dfs(idx+1,cnt+1,sum+arr[idx]); // 현재 난쟁이를 선택O
	}
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);	
	for(int i=0; i<9; i++) {
		arr[i] = sc.nextInt();
	}
	dfs(0,0,0); // 난쟁이 번호(0~9), 현재까지 선택한 난쟁이, 합
}
}