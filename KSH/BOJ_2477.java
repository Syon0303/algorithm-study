import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//참외밭, 실버 4
public class BOJ_2477 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[] map = new int[6];
		// 방향은 쓸모없음
		for(int i=0; i<6; i++) {
			int trash = sc.nextInt();
			map[i] = sc.nextInt();
		}
		
		int fullSize = 0;
		int smallSize = 0;
		int idx = 0;
		
		for(int i=0; i<6; i++) {
			// 여기서 map[i+1] 했다가 큰코다침
			int temp = map[i] * map[(i+1)%6];
			// 무조건 두 개씩 묶어서 생각하면, 지금 i와 i+1을 곱한 값이 무조건 사각형이 됨.
			// 그 중에 가장 큰 묶음이 전체 맵이 됨.
			if(fullSize < temp) {
				fullSize = temp;
				idx = i;
			}
		}
		// 그리고 무조건 그 인덱스에 +3 한 것과 +4 한 것이 가장 작은 사각형이 됨.
		smallSize = map[(idx+3)%6] * map[(idx+4)%6];	
		System.out.println(k*(fullSize - smallSize));
	}
}
