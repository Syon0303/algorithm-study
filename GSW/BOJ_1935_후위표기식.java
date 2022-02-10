import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();//공백제거용
		String str = sc.nextLine();
		List<Character> arr = new ArrayList<Character>();
		double [] arr2 = new double[N];
		char [] item = str.toCharArray();
		double num1,num2;
		int index;
		Stack<Double> stack = new Stack<Double>();
		
		for(int i=0;i<N;i++) {
			 arr.add((char) (65+i)); // 알파벳의 종류는 A부터 연속적이기 때문에 A의 아스키코드 값에 i를 더해 표현
			 arr2[i] = sc.nextDouble();//알파벳의 종류에 대응되는 값 입력
		}
		for(int i=0;i<item.length;i++) {
			
			//+,-,*,/,이외의 알파벳 각각의 경우에 따라 작동되어야할 코드 분류
			// - , / 는 pop한 두 수  계산시 순서 주의
			switch(item[i]) {
			case'+':
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1+num2);
				break;
			case'-':
				//먼저 pop된 숫자가 뒤에서 계산되어야하는 수
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1-num2);
				break;
			case'*':
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1*num2);
				break;
			case'/':
				//먼저 pop된 숫자가 뒤에서 계산되어야하는 수
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1/num2);
				break;
			default://알파벳일 경우
				//알파벳의 인덱스 == 대응되는 숫자의 인덱스
				//따라서 현재 알파벳의 인덱스를 구해 대응되는 숫자가 저장된 배열의 인덱스로 사용
				index = arr.indexOf(item[i]); 
				stack.push(arr2[index]);
				break;
			}


		}
		System.out.printf("%.2f",stack.pop()); //소수점 두자리까지 출력
	}
}
