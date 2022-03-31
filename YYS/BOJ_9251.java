import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[] dp = new int[s1.length()]; // 1번째 문자열로 dp 기록
        int MAX = 0;
        // 2번째 문자열을 기준으로 검사
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            int max = 0;
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == c && max + 1 > dp[j]) {
                    dp[j] = max + 1;
                    MAX = Math.max(MAX, dp[j]);
                } else {
                    max = Math.max(max, dp[j]);
                }
            }
        }
        System.out.println(MAX);
    }
}