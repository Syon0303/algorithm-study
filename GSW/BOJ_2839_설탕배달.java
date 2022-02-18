import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main_설탕 {


	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum=0;
		int temp,temp2;
		int res=Integer.MAX_VALUE;
		
		for(int i=0;i<=N/5;i++) {
			temp=N;
			if(i!=0) {
				sum=i;
				temp=temp-(5*i);
			}
			for(int j=0;j<=N/3;j++) {
				temp2=temp;
				sum=i;
				if(j!=0) {
					sum+=j;
					temp2=temp2-(3*j);
				}
				if(temp2==0) {
					res=Math.min(res, sum);
				}
			}
		}
		if(res==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(res);
		}
		
		
		
		
	}
	
	

}
