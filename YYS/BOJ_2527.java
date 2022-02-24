import java.io.*;
import java.util.*;
public class Main {
	
	static int lineMeet(int x1, int x2, int x3, int x4) { // (x1,x2) 와 (x3,x4) 선분의 관계 파악
		if(x2<x3 || x4<x1) { // 둘이 만나지 않는 경우
			return 0;
		}else if(x2==x3 || x4 == x1) { //둘이 한 점에서 만나는 경우
			return 1;
		}
		return 2; // 둘이 선분으로 만나는 경우
	}
	
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	//x, y,(왼쪽 아래) p, q(오른쪽 위)
	for(int i=0; i<4; i++) {
		int[] rec = new int[8];
		//값 넣기
		for(int j=0; j<8; j++) {
			rec[j] = sc.nextInt();
		}
		// x 선분끼리 만나는지 확인
		int res = lineMeet(rec[0], rec[2], rec[4], rec[6]);
		
		// y 선분끼리 만나는지 확인
		int res2 = lineMeet(rec[1], rec[3], rec[5], rec[7]);
		
		// 그 둘을 곱해 종합한 값을 구함
		int res3 = res*res2;
		
		
		// 둘의 곱한 값에 따라 분기
		switch(res3) {
			case 4: System.out.println("a"); break;
			case 2: System.out.println("b"); break;
			case 1: System.out.println("c"); break;
			case 0: System.out.println("d"); break;
		}
	}
}
}