import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int total = sc.nextInt();
		int arr[] = new int[N];
		int res=0;
		
		for(int i=N-1;i>=0;i--) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			res += total/arr[i];
			total = total%arr[i];
		}
		System.out.println(res);
		
		
		
		
	}
	
	

}
