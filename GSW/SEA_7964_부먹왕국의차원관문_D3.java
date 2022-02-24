import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SEA_7964_부먹왕국의차원관문_D3 {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for (int t = 1; t <= testCase; t++) {
			////////////////////////////
			int N = sc.nextInt();
			int D = sc.nextInt();
			int arr [] = new int[N];
			int res=0;
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			if(arr[0]==0) {
				res++;
				arr[0]=1;
			}
			if(arr[N-1]==0) {
				res++;
				arr[N-1]=1;
			}
			int temp=0;
			for(int i=0;i<N;i++) {
				if(arr[i]==0) {
					temp++;
				}
				else {
					temp=0;
				}
				if(temp == D) {
					res++;
					temp=0;
				}
			}
			System.out.printf("#%d %d\n",t,res);
			
			
			///////////////////////
		}

	}
}
