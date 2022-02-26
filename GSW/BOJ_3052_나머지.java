import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;

public class BOJ_3052_나머지 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean [] check = new boolean[42];
		for(int i=0;i<10;i++) {
			check[sc.nextInt()%42] = true;
		}
		int res=0;
		for(boolean b : check) {
			if(b) res++;
		}
		System.out.println(res);
		
		
	
	}
}