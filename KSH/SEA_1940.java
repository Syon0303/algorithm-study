package day10;

import java.util.Scanner;
/*
 * 가라 RC카
 * D2, 5분
 */
public class SEA_1940 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int time = sc.nextInt();
			int nowSpeed = 0; // 현재속도
			int d = 0; // 거리
			
			for(int i=0; i<time; i++) {
				int command = sc.nextInt();
				
				if(command != 0) {
					int speed = sc.nextInt(); // 가속도
					
					if(command == 1) nowSpeed += speed;
					else {
						if(nowSpeed < speed) nowSpeed = 0;
						else nowSpeed -= speed;
					}
				}
				d += nowSpeed;
			}
			System.out.println("#" + test_case + " " + d);
			
			
			
			
			
			
			
		}
	}
}
