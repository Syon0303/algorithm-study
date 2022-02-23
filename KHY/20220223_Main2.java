import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(stn.nextToken());
			int y1 = Integer.parseInt(stn.nextToken());
			int p1 = Integer.parseInt(stn.nextToken());
			int q1 = Integer.parseInt(stn.nextToken());
			int x2 = Integer.parseInt(stn.nextToken());
			int y2 = Integer.parseInt(stn.nextToken());
			int p2 = Integer.parseInt(stn.nextToken());
			int q2 = Integer.parseInt(stn.nextToken());
			
			int xmax = Math.max(x1, x2); 
			int pmin = Math.min(p1, p2);
			int ymax = Math.max(y1, y2);
			int qmin = Math.min(q1, q2);
			
			int xdiff = pmin - xmax;
			int ydiff = qmin - ymax;
			
			if(xdiff > 0 && ydiff > 0){
				System.out.println("a");
			}else if(xdiff < 0 || ydiff < 0) {
				System.out.println("d");
			}else if(xdiff == 0 && ydiff == 0) {
				System.out.println("c");
			}else {
				System.out.println("b");
			}
		}
	}
}
