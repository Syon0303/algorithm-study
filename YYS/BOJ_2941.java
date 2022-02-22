import java.io.*;
public class Main {
public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   String s = br.readLine();
       // 미리 크로아티아 알파벳들을 입력하고 replace 
	   String[] alphabet = {"c=","c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	   for(int i =0; i<8; i++) {
		   s = s.replace(alphabet[i], "*");
	   }
	   System.out.println(s.length());
	}
}