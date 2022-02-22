import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[7][2]; // 6반까지 존재, 성별
		int cnt = 0;
		
		while(N-->0) {
			int S = sc.nextInt(); // 학생의 성별: 0(여) , 1(남)
			int Y = sc.nextInt(); // 학년
			arr[Y][S] += 1;
		}
		
		for(int i=1; i<=6; i++) {
			int XX = arr[i][0]; // 여자수
			int XY = arr[i][1]; // 남자수
			
			if(XX%K==0) { //정확히 나누어 떨어진다면
				XX /= K;
			}else {
				XX = XX/K + 1;
			}
			
			if(XY%K==0) { //정확히 나누어 떨어진다면
				XY /= K;
			}else {
				XY = XY/K + 1;
			}
			
			cnt += XX + XY;
		}
		System.out.println(cnt);
}
}