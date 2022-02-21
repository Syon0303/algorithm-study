import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int t = sc.nextInt();
		//개미는 2w 2h마다 제자리로 돌아옴
		
		int netX = (t+p)%(2*w);
		if(netX>w) netX = 2*w-netX;
		int netY = (t+q)%(2*h);
		if(netY>h) netY = 2*h-netY;
		System.out.println(netX+" "+netY);
	}
}