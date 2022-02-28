import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Queue;

public class BOJ_2615_오목_실버2 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int map [][] = new int [19][19];
		boolean check[][][] = new boolean[19][19][4];
		int dx []= {1,1,1,0};
		int dy[] = {-1,0,1,1};
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int winner =0;
		int resX=0;
		int resY=0;
		outer:for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(map[j][i]!=0) {
					for(int k=0;k<4;k++) {
						int sum=1;
						int nextX = i+dx[k];
						int nextY = j+dy[k];
						if(nextX<0||nextX>=19||nextY<0||nextY>=19) continue;
						
						while(map[j][i]==map[nextY][nextX]&&!check[nextY][nextX][k]) {
							check[nextY][nextX][k] = true;
							sum++;
							nextX = nextX+dx[k];
							nextY = nextY+dy[k];
							if(nextX<0||nextX>=19||nextY<0||nextY>=19) break;
						}
						if(sum==5) {
							winner  = map[j][i];
							resX=i+1;
							resY=j+1;
							break outer;
						}
					}
				}
			}
		}
		System.out.println(winner);
		if(winner!=0) {
			System.out.println(resY+" "+resX);
		}
		
	}
}