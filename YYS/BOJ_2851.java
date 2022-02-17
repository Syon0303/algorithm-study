import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int prev=0,now=0;
        
		for(int i=0; i<10; i++) { //10개의 입력값
			prev = now; //현재 now 값을 이전값 prev에 저장합니다
            
			now += sc.nextInt(); //그리고 now에 다음 값을 더합니다
            
			if(now>=100) { // now가 100을 넘기는 순간: prev에는 100보다 작은 값, now에는 100보다 큰 값이 저장
				i=10; //반복문을 종료합니다.
			}
		}
		if(now-100<=Math.abs(100-prev)) { // 그 둘을 비교하고 100과의 차이가 적은 수를 내보냅니다
			System.out.println(now);
		}else {
			System.out.println(prev);
		}
	}
}