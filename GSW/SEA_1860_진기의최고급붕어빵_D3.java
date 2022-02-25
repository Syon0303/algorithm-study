import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SEA_1860_진기의최고급붕어빵_D3 {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		outer: for (int t = 1; t <= testCase; t++) {
			////////////////////////////
			int N = sc.nextInt(); //손님수
			int M = sc.nextInt(); //걸리는 시간
			int K = sc.nextInt(); //M초당 만들수 있는 수
			int [] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr); //빨리오는 순으로 정렬
			int sum=0;
			int index=0;
            if(arr[0]==0){ //0초에는 붕어빵 못만들기 때문에 불가능
                System.out.printf("#%d Impossible\n",t);
					continue outer;
            }
			for(int i=1;i<=arr[N-1];i++) { //제일 늦게 오는 손님이 오는 시간까지 반복문 (1번 반복당 1초)
				if(i%M==0) sum+=K; //붕어빵 만들수 있는 시간 되면 만들기
				
				//손님이 도착할 시간되면 확인, 같은시간(i)에 여러 사람이 올 수 있기때문에 반복문 사용
				while(index!=N&&arr[index]==i) {  //if문 사용해도 통과되긴 했는데 N=2 M=1 K=1, 일때 손님 도착시간이 1,1일때는 틀리기 때문에 if문 쓰면 잘못된 코드임
					if(sum==0) { //붕어빵 없으면 불가능
						System.out.printf("#%d Impossible\n",t);
						continue outer;
					}
					else { //있으면 붕어빵 하나빼고 다음손님 확인
						sum--;
						index++;
					}
				}
			}
			System.out.printf("#%d Possible\n",t);
			///////////////////////
		}

	}
}
