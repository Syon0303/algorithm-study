import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s = sc.next();
		int MAX = 1; //최대 컵홀더 수
		for(int i=0; i<N; i++) {
			if(s.charAt(i)=='S') {
				MAX++;
			}else { // L이라면
				MAX++;
				i++;
			}
		}
		System.out.println(N<MAX?N:MAX);
	}
}