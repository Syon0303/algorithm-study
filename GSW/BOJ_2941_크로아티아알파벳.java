import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		String str = br.readLine();
		int len = str.length();
		String [] list = {"c=","c-","dz=","d-","lj","nj","s=","z="}; //크로아티아 알파벳 목록
		for(int i=0;i<list.length;i++) {
			if(str.contains(list[i])) { //문자열에 크로아티아 알파벳이 포함되어있으면
				str=str.replaceAll(list[i], "a"); //크로아티아 알파벳=1글자, a는 크로아티아 알파벳 표현에 사용되지않음, 크로아티아 알파벳을 다 a로 바꿈
			}
		}
		System.out.println(str.length());
	}

}