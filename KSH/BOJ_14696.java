package day11;

import java.util.Scanner;

// 딱지놀이 브론즈 1 5분
public class BOJ_14696 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for(int test_case=1; test_case<=N; test_case++) {

			int aNum = sc.nextInt();
			int[] aArr = new int[5];
			for(int i=0; i<aNum; i++) aArr[sc.nextInt()]++;

			int bNum = sc.nextInt();
			int[] bArr = new int[5];
			for(int i=0; i<bNum; i++) bArr[sc.nextInt()]++;


			for(int i=4; i>0; i--) {
				if(aArr[i] > bArr[i]){
					System.out.println("A");
					break;
				}
				else if(aArr[i] < bArr[i]) {
					System.out.println("B");
					break;
				}
				else if(i==1) System.out.println("D");						
			}
		}
	}
}
