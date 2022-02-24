import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;

public class BOJ_2527_직사각형_실버1 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		for(int t=0;t<4;t++) {
			int ax1 = sc.nextInt();
			int ay1 = sc.nextInt();
			int ax2 = sc.nextInt();
			int ay2 = sc.nextInt();
			int bx1 = sc.nextInt();
			int by1 = sc.nextInt();
			int bx2 = sc.nextInt();
			int by2 = sc.nextInt();
			
			if(by1>ay2||by2<ay1||bx1>ax2||bx2<ax1) {
				System.out.println("d");
				continue;
			}
			else if((ay1==by2&&(ax1==bx2||ax2==bx1))||(ay2==by1&&(ax1==bx2||ax2==bx1))) {
				System.out.println("c");
			}
			else if(ay1==by2 || ay2==by1 || ax1==bx2 || ax2==bx1) {
				System.out.println("b");
			}
			else {
				System.out.println("a");
			}
		}
		
	
	}
}