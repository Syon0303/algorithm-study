package day17;

import java.util.Scanner;

// 의석이의 세로로 말해요, D3, 10분
public class SEA_5356 {

	static final int MAX_VALUE = 15;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			String[][] arr = new String[5][];
			
			for(int i=0; i<5; i++) arr[i] = sc.next().split("");
			System.out.print("#" + test_case + " ");
			
			for(int i=0; i<MAX_VALUE; i++) {
				for(int j=0; j<5; j++) {
					if(i < arr[j].length) System.out.print(arr[j][i]);
				}
			}
			System.out.println();
		}
	}
}
