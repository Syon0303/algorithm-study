import java.util.Arrays;
import java.util.Scanner;

public class SEA_7236_저수지물깊이_D3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 1; t <= testCase; t++) {
			////////////////////////////
			int N =sc.nextInt();
			sc.nextLine();
			int map[][] = new int[N][N];
			int [] d = {-1,0,1};
			for(int i=0; i<N;i++) {
				String str[] = sc.nextLine().split(" ");
				for(int j=0;j<N;j++) {
					if(str[j].equals("G")) map[i][j] =0;
					else map[i][j] = 1;
				}
			}
			int res=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==1) {
						int dx,dy;
						int temp=0;
						for(int k=0;k<3;k++) {
							for(int l=0;l<3;l++) {
								if(k==1&&l==1) continue;
								dx = j+d[l];
								dy = i+d[k];
								if(dx>=0&&dx<N&&dy>=0&&dy<N) {
									temp+=map[dy][dx];
								}
							}
						}
						if(temp==0) temp=1;
						res = Math.max(res, temp);
					}
				}
			}
			System.out.printf("#%d %d%n",t,res);
			///////////////////////
		}

	}
}
