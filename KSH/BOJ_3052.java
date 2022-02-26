package day17;

import java.util.HashSet;
import java.util.Scanner;

// 나머지, 브론즈 2, 5분
public class BOJ_3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0; i<10; i++) arr[i] = sc.nextInt();
		
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<10; i++) {
			hs.add(arr[i]%42);
		}
		System.out.println(hs.size());

	}

}
