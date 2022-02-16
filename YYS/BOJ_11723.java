import java.io.*;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int S = 0;
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()){
				case "add": // OR 연산으로 추가합니다
					S |= 1<<Integer.parseInt(st.nextToken());
					break;
				case "remove": // 비트를 뒤집고 AND 연산
					S &= ~(1<<Integer.parseInt(st.nextToken()));
					break;
				case "check": // AND 연산으로 확인
					sb.append((S & 1<<Integer.parseInt(st.nextToken()))!=0?1:0).append("\n");
					break;
				case "toggle": // 원래 원소가 1이든 0이든 1과 XOR 연산하면 그 반대가 나옵니다.
					S ^= 1<<Integer.parseInt(st.nextToken());
					break;
				case "all":
					S |= ~0;
					break;
				case "empty": S = 0; break;
			}
		}
		System.out.println(sb.toString());
	}
}