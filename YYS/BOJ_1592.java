import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr = new int[N]; // 기본적으로 0이 채워집니다
		int cnt = 0;
		int now =  0; // now는 현재 공이 있는 위치입니다. 1번 위치(=0 인덱스)에서 공을 던집니다.
		
		while(true) {
			if(arr[now]%2==0) { // now 위치에서 현재까지 공을 받은 횟수가 짝수일 때 
				now = (now - L)%N; // 알짜 위치를 반환합니다

				if(now<0) { //0보다 작다면 N만큼 더해서 경계값으로 들어오게 합니다
					now += N;
				}

			} else { // now 위치에서 현재까지 공을 받은 횟수가 홀수일 때 
				now = (now + L)%N;
			}

			arr[now]++; //받은 개수 추가

			if(arr[now]==M) {
				break;
			}
            
			cnt++;
		}
		System.out.println(cnt);
}
}