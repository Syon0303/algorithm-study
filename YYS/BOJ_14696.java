import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while(N-->0) {
			int[] A = new int[5];
			int[] B = new int[5]; //카운팅 배열
			char result = 'D';
			
			int num = sc.nextInt();
			while(num-->0) {
				A[sc.nextInt()]++;
			}
			
			num = sc.nextInt();
			while(num-->0) {
				B[sc.nextInt()]++;
			}
			
			for(int i=4; i>=0; i--) {
				if(A[i]>B[i]) {
					result = 'A';
					i = -1; //반복문 종료
				}else if(A[i]<B[i]) {
					result = 'B';
					i = -1;
				}
			}
			System.out.println(result);
		}
	}
}