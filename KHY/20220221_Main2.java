import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] alp = br.readLine().toCharArray();
		int n = alp.length;
		int res = 0;
		for (int i = 0; i < n; i++) {
			if(alp[i] == 'c') {
				if(i+1 != n && (alp[i+1] == '=' || alp[i+1] == '-')) {
					i++;					
				}	
			}else if(alp[i] == 'd') {
				if(i+1 != n && (alp[i+1] == '-')) {
					i++;
				}else if(i+2 < n && alp[i+1] == 'z' && alp[i+2] == '=') {
					i+=2;
				}
			}else if(alp[i] == 'l') {
				if(i+1 != n && alp[i+1] == 'j') {
					i++;
				}
			}else if(alp[i] == 'n') {
				if(i+1 != n && alp[i+1] == 'j') {
					i++;
				}
			}else if(alp[i] == 's') {
				if(i+1 != n && alp[i+1] == '=') {
					i++;
				}
			}else if(alp[i] == 'z') {
				if(i+1 != n && alp[i+1] == '=') {
					i++;
				}
			}
			res++;
		}
		System.out.println(res);
	}
}