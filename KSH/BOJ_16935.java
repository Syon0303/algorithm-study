package day7;

import java.util.Scanner;

// 배열 돌리기 3
public class BOJ_16935 {

	static int[][] map;
	static int N;
	static int M;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		map = new int[N][M];
		for(int i=0; i<N; i++) for(int j=0; j<M; j++) map[i][j] = sc.nextInt();

		int op[] = new int[R];
		for(int i=0; i<R; i++) op[i] = sc.nextInt();

		for(int i=0; i<R; i++) {
			if(op[i] == 1) {
				map = func1();
			}
			else if(op[i] == 2) {
				map = func2();
			}
			else if(op[i] == 3) {
				map = func3();
			}
			else if(op[i] == 4) {
				map = func4();
			}
			else if(op[i] == 5) {
				map = func5();
			}
			else if(op[i] == 6) {
				map = func6();
			}
		}
		for(int i[]:map) {
			for(int j:i) {
				System.out.print(j + " ");
			}System.out.println();
		}
	}

	static int[][] func1() {
		int[][] resArr = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				resArr[N-1-i][j] = map[i][j];
			}
		}
		return resArr;
	}

	static int[][] func2() {
		int[][] resArr = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				resArr[i][M-1-j] = map[i][j];
			}
		}
		return resArr;
	}

	static int[][] func3() {
		int[][] resArr = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				resArr[j][N-1-i] = map[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		
		return resArr;
	}

	static int[][] func4() {
		int[][] resArr = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				resArr[M-1-j][i] = map[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		
		return resArr;
	}

	static int[][] func5() {
		int[][] resArr = new int[N][M];
		int midN = N/2;
		int midM = M/2;

		// 1->2
		for(int i=0; i<midN; i++) {
			for(int j=0; j<midM; j++) {
				resArr[i][midM+j] = map[i][j];
			}
		}
		// 2->3
		for(int i=0; i<midN; i++) {
			for(int j=midM; j<M; j++) {
				resArr[midN+i][j] = map[i][j];
			}
		}
		// 3->4
		for(int i=midN; i<N; i++) {
			int col = 0;
			for(int j=midM; j<M; j++,col++) {
				resArr[i][col] = map[i][j];
			}
		}
		
		int row = 0;
		// 4->1
		for(int i=midN; i<N; i++,row++) {
			for(int j=0; j<midM; j++) {
				resArr[row][j] = map[i][j];
			}
		}
		
		return resArr;
	}

	static int[][] func6() {
		int[][] resArr = new int[N][M];
		int midN = N/2;
		int midM = M/2;
		
		for(int i=0; i<midN; i++) {
			for(int j=0; j<midM; j++) {
				resArr[midN+i][j] = map[i][j];
			}
		}
		for(int i=midN; i<N; i++) {
			for(int j=0; j<midM; j++) {
				resArr[i][midM+j] = map[i][j];
			}
		}
		int row = 0;
		for(int i=midN; i<N; i++,row++) {
			for(int j=midM; j<M; j++) {
				resArr[row][j] = map[i][j];
			}
		}
		for(int i=0; i<midN; i++) {
			int col = 0;
			for(int j=midM; j<M; j++,col++) {
				resArr[i][col] = map[i][j];
			}
		}
		return resArr;
	}
}
