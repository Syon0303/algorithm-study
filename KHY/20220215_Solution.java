import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 설탕 무게
		int fres = 0, tres = 0; // 5kg 봉지 수, 3kg 봉지 수
		boolean flag = false;
		while(true) {
			// N = 0 이면 딱 나누어 떨어진 것이므로 결과 값 출력
			if(N == 0) {
				System.out.println(fres+tres);
				break;
			}
			if(flag) break;
			// 5보다 크면 5kg 봉지 일단 추가
			if(N >= 5) {
				N -= 5;
				fres++;
			// 3보다 크고 5보다 작으면 3kg 봉지 추가
			}else if(N >= 3) {
				N -= 3;
				tres++;
			// 3보다 작으면 딱 나누어 떨어진 게 아니므로
			}else {
				// 5kg 하나씩 줄이면서 3kg 늘려 봄
				while(true) {
					// 3보다 크면 3kg 봉지 추가
					if(N >= 3) {
						N -= 3;
						tres++;
					// 딱 나누어 떨어지면 break
					}else if(N == 0) {
						break;
					// 딱 나누어 떨어지지 않으면 5kg 봉지를 하나씩 줄임
					}else {
						// 5kg 봉지가 있으면
						if(fres > 0) {
							N += 5;
							fres--;
						// 5kg 봉지가 없으면 딱 나누어 떨어지는 경우 없음
						}else {
							System.out.println(-1);
							flag = true;
							break;
						}
					}
				}
			}
		}
	}
}