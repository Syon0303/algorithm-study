import java.util.*;


public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		int sum = 0;
		for(int i=0; i<N; i++) {
			arr[i]= sc.nextInt();	
		}
		Arrays.sort(arr); //정렬
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				sum += arr[j]; // 현재항에 대해 이전항부터 현재항까지 모든 합 구하기
			}
		}
		System.out.println(sum);
	}
}