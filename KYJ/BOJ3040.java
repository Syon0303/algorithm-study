import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ3040 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> dwarf = new ArrayList<>();
		int X = 0;
		for(int i = 0; i < 9; i++) {
			dwarf.add(Integer.parseInt(br.readLine()));
			X += dwarf.get(i);
		}
		X -= 100;
		boolean b = false;
		for(int i = 0; i < 9; i++) {
			if(b) break;
			else if(dwarf.get(i) >= X) continue;
			else {
				for(int j = i; j < 9; j++) {
					if(dwarf.get(j) >= X) continue;
					else if(dwarf.get(i) + dwarf.get(j) == X) {
						dwarf.remove(i);
						dwarf.remove(j-1);
						b = true;
						break;
					}
				}
 			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 7; i++) sb.append(dwarf.get(i)+"\n");
		System.out.print(sb.toString());
	}
}
