import java.util.Arrays;
import java.util.Scanner;

public class SEA_1220_Magnetic_D3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		//int testCase = sc.nextInt();

		for (int t = 1; t <= 10; t++) {
			////////////////////////////
			int N =sc.nextInt();
			int map[][] = new int[N][N];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int res=0;
			for(int i=0;i<100;i++) {
				boolean [] check = new boolean[2]; 
				for(int j=0;j<100;j++) {
					if(map[j][i]==0) continue;
					if(map[j][i]==1) {
						check[0]  = true;
					}
					else {
						if(check[0]) {
							check[1] = true;
						}
					}
					if(check[0]&&check[1]) {
						res++;
						check[0] = false;
						check[1] = false;
					}
					
				}
			}
			System.out.printf("#%d %d%n",t,res);
			///////////////////////
		}

	}
}
