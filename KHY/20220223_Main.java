import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split("");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < temp.length; i++) {
			if(temp[i].equals("<")) {
				if(sb != null) {
					sb.reverse();
					System.out.print(sb);
					sb = new StringBuilder();
				}
				sb.append(temp[i]);
				while(true) {
					i++;
					if(temp[i].equals(">")) {
						sb.append(temp[i]);
						System.out.print(sb);
						sb = new StringBuilder();
						break;
					}
					sb.append(temp[i]);
				}
			}else if(temp[i].equals(" ")) {
				sb.reverse();
				System.out.print(sb+" ");
				sb = new StringBuilder();
			}else {
				sb.append(temp[i]);
			}
		}
		sb.reverse();
		System.out.println(sb);
	}
}
