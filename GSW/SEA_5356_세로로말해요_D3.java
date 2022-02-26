import java.util.Arrays;
import java.util.Scanner;

public class SEA_5356_세로로말해요_D3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= testCase; t++) {
			////////////////////////////
			StringBuilder sb = new StringBuilder();
			char [][] str = new char[5][15];
			for(int i=0;i<5;i++) {
				char [] temp = sc.nextLine().toCharArray();
				for(int j=0;j<temp.length;j++) {
					str[i][j] = temp[j];
				}
			}
			for(int i=0;i<15;i++) {
				for(int j=0;j<5;j++) {
					if(str[j][i]!= 0) sb.append(str[j][i]);
				}
			}
			System.out.printf("#%d %s",t,sb.toString());
			
			///////////////////////
		}

	}
}
