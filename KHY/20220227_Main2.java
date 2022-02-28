import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			char[] OX = br.readLine().toCharArray();
			int sum = 0;
			int point = 0;
			for (int i = 0; i < OX.length; i++) {
				switch (OX[i]) {
				case 'O':
					point++;
					sum += point;
					break;
				case 'X':
					point = 0;
					break;
				}
			}
			System.out.println(sum);
		}
	}
}
