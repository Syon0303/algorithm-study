import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] r = new int[42];
		for (int i = 0; i < 10; i++) {
			r[Integer.parseInt(br.readLine()) % 42]++;
		}
		int res = 0;
		for (int i = 0; i < 42; i++) {
			if(r[i] != 0) res++;
		}
		System.out.println(res);
	}
}