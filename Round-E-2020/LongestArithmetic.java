import java.util.Scanner;

public class LongestArithmetic{
    public static void main(String arg[]) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        int incr = 1;
        while (t != 0) {
            int n = ob.nextInt();
            int a[] = new int[n];
            int diff[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ob.nextInt();
                if (i >= 1) {
                    diff[i] =a[i - 1] - a[i];
                }
            }
            int ans = 2;
            boolean b = true;
            int prev = diff[1];
            int actans = 2;
            for (int i = 2; i < n; i++) {
                if (b && prev == diff[i]) {
                    ans++;
                } else {
                    b = true;
                    prev = diff[i];
                    actans = Math.max(ans, actans);
                    ans = 2;
                }
            }

            actans = Math.max(ans, actans);
            System.out.println("Case #" + incr + ": " + actans);
            incr++;
            t--;
        }
    }
}
