import java.util.*;

public class Main {
	public static void main(String[] args){
//		초항: 1
//		등차: 6n
//		An = 1 + 6(1+2+...n-1)
//		An = 1 + 3n(n-1) = n번째 껍질이 시작하는 곳
//		(N-1)/3 <= k(k-1) 를 만족하면 k만큼 이동
//		(N-1)/3 <= (k-0.5)^2-0.25
//		sqrt [(N-1)/3 + 0.25] <= k -0.5
		System.out.print((int)Math.ceil(Math.sqrt((new Scanner(System.in).nextDouble()-1)/3 + 0.25)+0.5));
	}
}