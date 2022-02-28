import java.util.*;
public class Main {
	public static void main(String[] args){
		int[][] arr = new int[19][19];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while(N-->0) {
			String s = sc.next();
			int count = 0;
			int sum = 0;
			for(int i=0; i<s.length();i++) {
				if(s.charAt(i)=='X') { // X를 만나면 정산
					sum += (count+1)*count/2;
					count = 0;
				}else { //O를 만나면 1 누적
					count ++;
				}
			}
			System.out.println(sum+(count+1)*count/2); //O로 끝날 수 있으므로 계산
		}
	}
}