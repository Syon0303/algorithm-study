import java.io.IOException;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws IOException {
		Scanner sc =  new Scanner (System.in);
		int N = sc.nextInt();
		int res=0;
		int temp=1;
		if(N==1) {
			System.out.println(1);
			return;
		}
		for(int i=1;;i++) {
			temp+=(i*6);
			if(N<=temp) {
				res = i;
				break;
			}
		}
		res+=1;
		System.out.println(res);
	}

	

}