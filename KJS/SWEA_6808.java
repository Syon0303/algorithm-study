package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author us13579
 * @since 2022-02-14 1시간 10분
 * @title 규영이와 인영이의 카드게임, D3
 */
public class SWEA_6808 {
	static StringTokenizer st;
	static int win, lose;
	// 규영이 카드
	static int[] arr;
	// 인영이 카드
	static int[] arr_in;
	// 인영이가 낼 수 있는 카드의 배열
	static int[] arr_in_card;
	// 카드 개수
	static int card = 9;
	// 18개의 카드 중 가져간 것 찾기 위해
	static boolean[] isChecked;
	// permutation boolean
	static boolean[] check;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			// 규영이 카드
			arr = new int[card];
			// 인영이 카드
			arr_in = new int[card];
			isChecked = new boolean[19];
			
			// 최종 규영이 승 패 
			win = 0;
			lose = 0;
			
			// 테스트 케이스 마다 입력
			st = new StringTokenizer(br.readLine(), " ");
			// 규영이의 카드
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				// 규영이가 가져간 카드를 체크
				isChecked[arr[i]] = true;
			}

			// 규영이가 가지고 있지 않은 것을 인영이에게 준다
			int index = 0;
			for (int i = 1; i < isChecked.length; i++) {
				if (isChecked[i]) {
					continue;
				} else {
					arr_in[index] = i;
					index++;
				}
			}
			check = new boolean[card];
			arr_in_card = new int[arr_in.length];
			permutation(0);

			// 규영이의 승패
			sb.append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

	// 순열 계산
	static void permutation(int index) {
		// 기저조건
		if (index == arr.length) {

			// 규영이, 인영이 점수 합계
			int gyu_sum = 0;
			int in_sum = 0;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > arr_in_card[i]) {
					gyu_sum += arr[i] + arr_in_card[i];
				} else {
					in_sum += arr[i] + arr_in_card[i];
				}
			}
			// 결국 이겼는지 졌는지 판단
			if (gyu_sum > in_sum) {
				win++;
			} else if (in_sum > gyu_sum) {
				lose++;
			}

			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if(!check[i]) {
				arr_in_card[index] = arr_in[i];
				check[i] = true;
				permutation(index+1);
				// 역트래킹
				check[i] = false;
			}
		}

	}
}
