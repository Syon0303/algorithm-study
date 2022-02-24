import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_15686_치킨배달_골드5 {
		static List <int[]> home;
		static List <int[]> chicken;
		static int arr[];
		static boolean check[];
		static int res=Integer.MAX_VALUE;

		static int maxChicken;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		home = new ArrayList<int[]>();
		chicken = new ArrayList<int[]>();
		int N = sc.nextInt();
		
		maxChicken = sc.nextInt();

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int temp = sc.nextInt();
				if(temp==1) home.add(new int [] {i,j});
				else if(temp==2) chicken.add(new int [] {i,j});
			}
		}
		arr = new int[maxChicken];
		check = new boolean[chicken.size()];
		comb(0,0);
		System.out.println(res);
	}
	
	static void comb(int start, int idx) {
		if(idx==maxChicken) {
			int temp=0;
			for(int [] tempHome : home) {
				int min =Integer.MAX_VALUE;
				for(int i=0;i<maxChicken;i++) {
					min = Math.min(min, Math.abs(tempHome[0] - chicken.get(arr[i])[0])+ Math.abs(tempHome[1] - chicken.get(arr[i])[1]));
				}
				temp+=min;
			}
			res = Math.min(res,temp);
			return;
		}
		for(int i = start; i<chicken.size();i++) {
				arr[idx] = i;
				comb(i+1,idx+1);
			
		}
		
	}

}