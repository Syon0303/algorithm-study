import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int [13];
		int N = sc.nextInt();
		int K = sc.nextInt();
		for(int i=0;i<N;i++) {
			//성별이 0,1로 입력되기 때문에 성별*6+학년을 통해 1~6은 여학생 count, 7~12는 남학생 카운트
			arr[sc.nextInt()*6+sc.nextInt()]++; 
			}
		int res =0;
		for(int i=1;i<13;i++) {
			//각 배열을 K로 나눈 결과를 통해 방 갯수를 구할 수 있다.
			res += arr[i]/K;
			//나머지가 있다면 방 +1
			if(arr[i]%K!=0) res++;
		}
		System.out.println(res);
		
	}

}