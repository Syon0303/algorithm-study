import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SEA_4047_영준이의카드카운팅_D3 {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		outer: for (int t = 1; t <= testCase; t++) {
			////////////////////////////
			boolean[][] check = new boolean[4][14];
			String[] str = sc.nextLine().split("");
			int len = str.length;
			for (int i = 0; i < len; i += 3) {
				int a = Integer.parseInt(str[i + 1]);
				int b = Integer.parseInt(str[i + 2]);
				int index = a * 10 + b;
				int index2=0;
				if (str[i].equals("S")) {
					index2=0;
				}
				else if (str[i].equals("D")) {
					index2=1;
				}
				else if (str[i].equals("H")) {
					index2=2;
				}
				else if (str[i].equals("C")) {
					index2=3;
				}
				if(check[index2][index] ) {
					System.out.printf("#%d ERROR\n",t);
					continue outer;
				}
				else {
					check[index2][index] = true;
				}
			}
			System.out.printf("#%d ",t);
			for(int i=0;i<4;i++) {
				int sum=0;
				for(int j=1;j<14;j++) {
					if(!check[i][j]) sum++;
				}
				System.out.printf("%d ",sum);
			}
			System.out.println();
			///////////////////////
		}

	}
}
