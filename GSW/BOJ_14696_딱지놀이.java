import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			int [] arr1 = new int[5];
			int [] arr2 = new int[5];
			int max = sc.nextInt();
			for(int j=0;j<max;j++) {
				arr1[sc.nextInt()]++;
			}
			max = sc.nextInt();
			for(int j=0;j<max;j++) {
				arr2[sc.nextInt()]++;
			}
			for(int j=4;j>=0;j--) {
				if(arr1[j]>arr2[j]) {
					System.out.println("A");
					break;
				}
				else if(arr1[j]<arr2[j]) {
					System.out.println("B");
					break;
				}
				else if(arr1[j]==arr2[j]&&j==0) {
					System.out.println("D");
					break;
				}
			}
		}
	}


}
