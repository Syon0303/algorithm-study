import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		int check = 0;
		for (int i = 0; i < M; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			String com = stn.nextToken(); // 커맨드
			int n = 0;
			if(stn.hasMoreTokens()) {
				n = Integer.parseInt(stn.nextToken());
			}
			switch (com) {
			case "add":
				check = check | (1 << (n-1));
				break;
			case "remove":
				check = ~check;
				check = check | (1 << (n-1));
				check = ~check;
				break;
			case "check":
				if((check & (1 << (n-1))) == 1 << (n-1)) {
					bw.write(1+"\n");
				}else {
					bw.write(0+"\n");
				}
				break;
			case "toggle":
				if((check & (1 << (n-1))) == 1 << (n-1)) {
					check = check & (0 << (n-1));
				}else {
					check = check | (1 << (n-1));
				}
				break;
			case "all":
				check = check | 0b11111111111111111111;
				break;
			case "empty":
				check = check & 0;
				break;
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}