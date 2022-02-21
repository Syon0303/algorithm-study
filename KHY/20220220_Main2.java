import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = {1,1,-1,-1};
	static int dc[] = {1,-1,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken()); //q가 컬럼
		int p = Integer.parseInt(st.nextToken()); //p가 로우
		int t = Integer.parseInt(br.readLine());
		int x = (q+t)%(2*W);
		int y = (p+t)%(2*H);
		
		x = W - Math.abs(W-x);
		y = H - Math.abs(H-y);
		
		System.out.println(x+" "+y);
	}
}

// x와 y를 따로 보면 x는 w*2, y는 h*2를 주기인 것을 알 수 있다.
// 따라서 그 이상인 경우는 의미가 없으므로 나머지 연산 취함
// 전체 길이를 w가 아닌 2w로 본다면 한번에 그 위치를 알 수 있게 된다.
// ex) 예제1에서 x를 12로 보고 현재 개미가 2에 있었으면 5시간 뒤에는 7에 있다. 이는 5의 위치랑 매칭이 된다
// 위를 식으로 구현하면 아래의 % 앞의 연산