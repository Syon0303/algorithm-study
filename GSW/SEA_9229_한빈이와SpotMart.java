import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Solution {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int t=1;t<=testCase;t++) {
			int N = sc.nextInt();
			int limit = sc.nextInt();
			int weight;
			int res=-1; // 제한무게 안에서 과자를 선택하지 못할시 -1출력해야 하기때문에 -1로 초기화
			int []arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=0;i<N;i++) { //과자 하나 선택하는 반복문
				weight = 0;
				for(int j=i+1;j<N;j++) {//이후 남은 과자들 중 하나를 더 선택하는 반복문
					weight = arr[i]+arr[j]; 
					if(weight>limit) continue; //과자 두개의 무개를 합쳐 제한무게와 비교, 제한무게보다 크면 현재 반복을 건너뜀
					if(res<weight) res = Math.max(res,weight); //현재 무게가 지금까지 나온 최대무게보다 크면 최대무게를 현재무게로 변경 
				}
			}
			System.out.printf("#%d %d\n",t,res);
		}
	}
}
