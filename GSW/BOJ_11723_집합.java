import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		List<Integer> arr = new ArrayList<>();
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("add")) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			if (str.equals("remove")) {
				arr.remove(Integer.valueOf(Integer.parseInt(st.nextToken())));

			}
			if (str.equals("check")) {
				int input = Integer.parseInt(st.nextToken());
				if (arr.contains(input)) {
					bw.write(String.valueOf(1) + "\n");
				} else {
					bw.write(String.valueOf(0) + "\n");
				}
			}
			if (str.equals("toggle")) {
				int input = Integer.parseInt(st.nextToken());
				if (arr.contains(input)) {
					arr.remove(Integer.valueOf(input));
				} else {
					arr.add(input);
				}
			}
			if (str.equals("all")) {
				arr.clear();
				for (int j = 1; j <= 20; j++) {
					arr.add(j);
				}
			}
			if (str.equals("empty")) {
				arr.clear();
			}
		}
        bw.flush();
	}

}
