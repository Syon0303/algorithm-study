import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static boolean [] isInfect;
	static List<ArrayList> com;
	static int N;
	public static void main(String[] args) throws IOException {
		Scanner sc  = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int com1, com2;
		int res=0;
		isInfect = new boolean[N]; //바이러스 감염여부 확인용
		com = new ArrayList<ArrayList>(); //연결 컴퓨터 저장목록의 배열
		
		for(int i=0;i<N;i++) {
			com.add(new ArrayList<Integer>()); //한 컴퓨터에 연결된 컴퓨터 저장용
		}
		
		for(int i=0;i<M;i++) {
			com1 = sc.nextInt()-1; //연결된 컴퓨터
			com2 = sc.nextInt()-1; //연결된 컴퓨터
			com.get(com1).add(com2); // com1의 연결된 컴퓨터 목록에 com2 추가
			com.get(com2).add(com1); // com2의 연결된 컴퓨터 목록에 com1 추가
		}

		check(0); //첫번째 컴퓨터와 연결된 컴퓨터 탐색용

		
		for(int i=1;i<N;i++) { //컴퓨터1은 포함 안됨
			if(isInfect[i]) res++; //감염여부가 true인 컴퓨터 수 확인
		}
		System.out.println(res);
	}
	
	public static void check(int num) {

		if(isInfect[num])return; //현재 컴퓨터가 이미 감염된걸 확인했으면 return
		else isInfect[num] = true; //현재 컴퓨터 감염여부 true변경
		for(int i=0;i<com.get(num).size();i++) {
				check((int) com.get(num).get(i)); //현재 컴퓨터와 연결된 컴퓨터 check
		}
		return;
	}
}
