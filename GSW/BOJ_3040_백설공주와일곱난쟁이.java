import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 백설공주 {
	static int arr[];
	static int arr2[];

	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		arr2 = new int[7];
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
		}
		comb(0,0);
		
		
	}
	
	public static void comb(int cnt,int start) {
		if(cnt==7) {
			int sum=0;
			for(int i=0;i<7;i++) {
				sum+=arr2[i];
			}
			if(sum==100) {
				for(int i=0;i<7;i++) {
					System.out.println(arr2[i]);
				}
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			arr2[cnt] = arr[i];
			comb(cnt+1,i+1);
		}
		
	}

}
