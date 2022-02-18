import java.io.IOException;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws IOException {
		Scanner sc =  new Scanner (System.in);
		int N = sc.nextInt();
		int res=0;
		// N개의 정사각형으로 만들수 있는 경우
		// 세로의길이를 기준으로 나누어 생각 가능 
		// ex) N개로 세로의 길이가 1인 직사각형을 만들때 그 직사각형의 넓이는 1x1 ...1xN까지
		//     세로의 길이가 2인경우 2x1 2x2 ......2x(N/2) 여기서 2x1인 사각형은 세로의 길이가 1일때 나온 1x2인 사각형과 같으니까 패스
		//     세로의 길이가 3인 경우 3x1 3x2 3x3 ..... 3x(N/3) 여기서도 3x1은 세로의길이가 1일때 3x2인경우는 세로의 길이가 2일때 사용됨
		//     결국 세로의 길이가 a인 경우 갯수를 세야하는건 a x a부터 a x (N/a)까지임 (a-1,a-2....)xN은 미리 세고 왔기 때문
		
		outer: for(int i=1;i<=N/i;i++) {
			for(int j=i;j<=N/i;j++) {
				if(i*j<=N) res++;
				else {
					continue outer; //만든 직사각형의 넓이가 N보다 커지는순간 현재 세로길이에서는 더 만들 직사각형이 없다는뜻
				}
			}
		}
		System.out.println(res);
		
	}

	

}