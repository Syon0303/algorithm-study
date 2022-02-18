import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int arr[] = new int[10];
	static int min = Integer.MAX_VALUE;
	static int res;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++) {
			arr[i] = sc.nextInt();
		}
		int sum=0;
		for(int i=0;i<10;i++) {
			sum+=arr[i];
			if(min==Math.abs(sum-100)&&res<sum) {
				res=sum;
			}
			if(min>Math.abs(sum-100)) {
				min = Math.abs(sum-100);
				res = sum;
			}
			if(sum>100) break;
			
		}
		System.out.println(res);
	}


}
