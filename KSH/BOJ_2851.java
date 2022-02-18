package day11;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 슈퍼마리오 브론즈1 30분
public class BOJ_2851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int map[] = new int[10];
		for(int i=0; i<10; i++) map[i] = sc.nextInt();
		
		int sum = 0;
		for(int i=0; i<10; i++) {
			if(Math.abs(sum+map[i]-100) <= Math.abs(sum-100)) {
				sum += map[i];
			}
			else break;
		}
		System.out.println(sum);
	}
}
