import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] num = new int [N];
		for(int i=0;i<N;i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		int sum=0;
		int min=0;
		for(int i=0;i<N;i++) {
			sum+=num[i];
			min +=sum;
		}
		System.out.println(min);
	}

}
