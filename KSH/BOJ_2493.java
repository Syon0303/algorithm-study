package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력을 위한 br 및 st 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// br을 통한 탑의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 탑 스택인 map 선언
		Stack<int[]> map = new Stack<int[]>();
		
		// 탑의 높이를 입력받기 위한 StringTokenizer st 선언
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 결과 값을 저장할 StringBuilder res 선언
		StringBuilder res = new StringBuilder();
		
		
		for(int i=0; i<n; i++){
			// 다음 탑의 높이
			int num = Integer.parseInt(st.nextToken());
			if(map.isEmpty()){
				res.append(0 + " ");
			}
			else {
				while(true) {
					// 저장된 스택의 맨 위의 탑의 정보(temp)를 불러와라 
					int[] temp = map.peek();
					// temp 탑의 idx (첫 번째부터 시작)
					int idx = temp[0];
					// temp 탑의 높이
					int height = temp[1];
					
					// 만약 temp 탑의 높이보다 다음 탑의 높이가 작다면 (레이저가 닿는다면)
					if(height > num) {
						res.append(idx + " ");
						break;
					}
					// temp 탑의 높이보다 다음 탑의 높이가 크다면 (레이저가 닿지 않는다면)
					else {
						// temp를 죽여라
						map.pop();
					}
					
					// 만약 map이 비어있다면 (스택에 아무것도 없다면 = 레이저가 닿지않는다면)
					if(map.isEmpty()) {
						// 0을 결과에 추가
						res.append(0 + " ");
						break;
					}
				}
			}
			// 스택에 다음 탑의 정보를 저장
			map.push(new int[] {i+1, num});
		}
		System.out.println(res.toString());
	}
}
