import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mushrooms = new int[10];
		for (int i = 0; i < mushrooms.length; i++) {
			mushrooms[i] = Integer.parseInt(br.readLine());
		}
		int sum = 0;
		for (int i = 0; i < mushrooms.length; i++) {
			if(Math.abs(100 - sum) < Math.abs(100 - (sum + mushrooms[i]))) {
				break;
			}
			sum += mushrooms[i];
		}
		System.out.println(sum);
	}
}