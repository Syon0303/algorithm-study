import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
public class Solution {
	public static int [] arr;
	public static int [] arr2;
	public static boolean [] check;
	public static int[] num;
	public static int win;
	public static int lose;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));

	
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for(int t=1;t<=testCase;t++) {
			////////////////////////////
			int N = sc.nextInt();
			int res=0;
			int s=0;
			for(int i=0;i<N;i++) {
				int temp;
				switch(sc.nextInt()) {
				case 0:
					break;
				case 1:
					temp=sc.nextInt();
					s=s+temp;
					break;
				case 2:
					temp=sc.nextInt();
					if(s<temp) s=0;
					else s=s-temp;
					break;
				}
				res+=s;
			}
			System.out.printf("#%d %d\n",t,res);
			////////////////////////
		}
	}
}
