import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int sec = Integer.parseInt(br.readLine());
		
		x+=sec;
		y+=sec;
		x=x%(2*w);
		y=y%(2*h);
		if(x>w) x= w*2-x;
		if(y>h) y= h*2-y;
		System.out.printf("%d %d",x,y);	
	}

}