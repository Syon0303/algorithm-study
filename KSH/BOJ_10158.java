import java.util.Scanner;

// 개미, 실버 4, 40분
public class BOJ_10158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int t = sc.nextInt();
		
		// p+t = 개미가 t초 동안 움직인 거리(x 기준)
		// p+t / w = 개미가 몇 번 왕복했는가?
		// (p+t/w) % 2 == 0 이면, 개미가 양수로 나아가고 있다는 뜻
		// (p+t/w) % 2 == 1 이면, 개미가 w에서부터 돌아오고 있다는 뜻
		int x = (p+t)/w;
		int y = (q+t)/h;
		
		int resX = 0;
		int resY = 0;
		
		if(x%2 == 0)	resX =     (p+t) % w;
		else		resX = w - (p+t) % w;
		
		if(y%2 == 0)	resY =     (q+t) % h;
		else	 	resY = h - (q+t) % h;
		
		System.out.println(resX + " " + resY);
	}

}
