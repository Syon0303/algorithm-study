import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> arr = new ArrayList<int[]>();
        int N = sc.nextInt();
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr.add(new int[] { sc.nextInt(), sc.nextInt() });
        }
        // 넣은 후 번호 순 정렬 (역방향 정렬도 가능)
        arr.sort(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return (o1[0] - o2[0]);
            }
        });
        int max = 1;
        // LIS
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            int now = arr.get(i)[1];
            for (int j = 0; j < i; j++) {
                if (arr.get(j)[1] < now && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(dp[i], max);
                }
            }
        }
        System.out.println(N - max);
    }
}