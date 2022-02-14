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
			win=0;
			lose=0;
			arr = new int[9];
			arr2 = new int[9];
			boolean [] arr3  =new boolean[19];
			check = new boolean[9];
			num = new int[9];
			int temp;
			for(int i=0;i<9;i++) {
				temp = sc.nextInt();
				arr[i] = temp;
				arr3[temp]= true;
			}
			int index=0;
			for(int i=1;i<19;i++) {
				if(!arr3[i]) {
					arr2[index] = i;
					index++;
				}
			}
			perm(0);
			System.out.printf("#%d %d %d\n",t,win,lose);
			////////////////////////
		}
	}
	
	static void perm(int idx) {
		if(idx == 9) {
			
			int sum=0;
			int sum2=0;
			for(int i=0;i<9;i++) {
				if(arr[i]>num[i]) sum+=arr[i]+num[i];
				else if(arr[i]<num[i]) sum2+=arr[i]+num[i];;
			}
			if(sum>sum2) win++;
			else if(sum2>sum) lose++;
			return;
		}
		for(int i=0;i<9;i++) {
			if(check[i]) continue;
			num[idx] = arr2[i];
			check[i] = true;
			perm(idx+1);
			check[i] = false;
		}
	}
}
