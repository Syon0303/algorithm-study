package day12;

import java.util.Scanner;

// 가랏! RC카!, D2, 5분
public class BOJ_1940 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int time = sc.nextInt();
			int nowSpeed = 0;
			int distance = 0;
			
			for(int i=0; i<time; i++) {
				int command = sc.nextInt();
				
				if(command != 0) {
					int acc = sc.nextInt();
					
					if(command==1) nowSpeed += acc;
					else {
						if(nowSpeed < acc) nowSpeed = 0;
						else nowSpeed -= speed;
					}
				}
				distance += nowSpeed;
			}
			System.out.println("#" + test_case + " " + d);
		}
	}
}
