import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc  = new Scanner(System.in);
		int testCase = sc.nextInt();
		Queue <int[]> queue;
		for(int t=0;t<testCase;t++) {
			
			int len = sc.nextInt();
			int target = sc.nextInt();
			int max = Integer.MIN_VALUE;
			int temp;
			queue = new LinkedList<int[]>();
			int [] arr;
			int [] tempArr;
			
			for(int i=0;i<len;i++) {
				arr = new int[2]; //arr[0] = 중요도, arr[1] = 내가 찾는 문서인지 여부(맞으면 1, 아니면 0)
				temp = sc.nextInt();
				max=Math.max(temp,max); //데이터를 읽으면서 가장 큰 중요도로 max초기화
				arr[0] = temp;         //arr[0]에 중요도 저장
				if(i==target) arr[1] = 1; //내가 찾는 문서면 arr[1] 1로 초기화
				queue.offer(arr); //arr배열 순서대로 queue에 입력
			}
			
			
			// temp랑 arr 재사용합니다
			
			temp=0; // 몇번째 출력인지 count <result역할> 
			
			while(true) {
				arr=queue.poll(); //먼저 큐 내부 가장앞에 있는 문서 뽑음
				if(arr[0]==max) { // 가장앞에 있는 문서의 중요도가 가장 큰 중요도와 같으면 출력이 진행됨
					max=Integer.MIN_VALUE; //남은 문서중 가장 큰 중요도를 다시 찾기위해 초기화
					temp++; //출력횟수 +1
					if(arr[1]==1) { //출력되는 문서가 내가 찾는 문서라면
					
						System.out.println(temp); //출력 이후 끝
						break;
					}
					else { //내가 찾는 문서가 아니라면
						
						for(int i=0;i<queue.size();i++) { //queue내부를 순회 
							tempArr = queue.poll(); // 가장 앞에있는 문서 확인
							max=Math.max(tempArr[0],max); //문서의 중요도와 현재까지 가장 큰 중요도 비교후 max 설정
							queue.offer(tempArr); //문서 확인 후 다시 queue삽입
						} //반복문 끝나면 반복문 시작전 queue상태와 동일
					}
				}
				else { //가장 앞에 있는 문서가 출력될 문서가 아니라면
					queue.offer(arr);//queue맨뒤로 
				}
			}
		}
	}
}
