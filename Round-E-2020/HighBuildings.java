import java.util.Scanner;

public class HighBuildings {
    public static void main(String arg[]) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        int incr = 1;
        for (int j = 0; j < t; j++) {
            int n = ob.nextInt();
            int a = ob.nextInt();
            int b = ob.nextInt();
            int c = ob.nextInt();
            int cc = c;
            int aa = a - c;
            int bb = b - c;
            int builds[] = new int[n];
            if (aa + bb + c > n || aa < 0 || bb < 0) {
                System.out.println("Case #" + incr + ": " + "IMPOSSIBLE");
                incr++;
                continue;
            }
            int ans = 0;
            for (int i = 0; i < aa; i++) {
                builds[i] = 1;
                ans++;
            }
            int h = bb;
            int last = n - 1;
            while (h != 0) {
                builds[last] = 1;
                ans++;
                last--;
                h--;
            }
            int rem = n - (aa + bb);
            for (int i = aa; i < aa + rem; i++) {
                if (i == aa) {
                    builds[i] = n;
                    ans++;
                    c--;
                } else if (i == aa + rem - 1) {
                    if (c >= 1) {
                        builds[i] = n;
                        c--;
                        ans++;
                    } else {
                        if (i + 1 < n) {
                            builds[i + 1]++;
                            builds[i] = 1;
                            ans++;
                        } else {
                            ans = n + 1;
                        }
                    }
                } else if (c >= 2) {
                    builds[i] = n;
                    ans++;
                    c--;
                } else {
                    builds[i] = 1;
                    ans++;
                }

            }
            StringBuilder ab = new StringBuilder();
            for (int i = 0; i < n; i++) {
                ab.append(builds[i] + " ");
            }
            if (ans == n) {
                System.out.println("Case #" + incr + ": " + ab.toString());
            } else {
                c = cc;
                aa = b - c;
                bb = a - c;
                builds = new int[n];
                if (aa + bb + c > n || aa < 0 || bb < 0) {
                    System.out.println("Case #" + incr + ": " + "IMPOSSIBLE");
                    incr++;
                    continue;
                }
                ans = 0;
                for (int i = 0; i < aa; i++) {
                    builds[i] = 1;
                    ans++;
                }
                h = bb;
                last = n - 1;
                while (h != 0) {
                    builds[last] = 1;
                    ans++;
                    last--;
                    h--;
                }
                rem = n - (aa + bb);
                for (int i = aa; i < aa + rem; i++) {
                    if (i == aa) {
                        builds[i] = n;
                        ans++;
                        c--;
                    } else if (i == aa + rem - 1) {
                        if (c >= 1) {
                            builds[i] = n;
                            c--;
                            ans++;
                        } else {
                            if (i + 1 < n) {
                                builds[i + 1]++;
                                builds[i] = 1;
                                ans++;
                            } else {
                                ans = n + 1;
                            }
                        }
                    } else if (c >= 2) {
                        builds[i] = n;
                        ans++;
                        c--;
                    } else {
                        builds[i] = 1;
                        ans++;
                    }

                }
                ab = new StringBuilder();
                for (int i = n - 1; i >= 0; i--) {
                    ab.append(builds[i] + " ");
                }
                if (ans == n) {
                    System.out.println("Case #" + incr + ": " + ab.toString());
                } else {
                    System.out.println("Case #" + incr + ": " + "IMPOSSIBLE");
                }
            }
            incr++;
        }
    }
}
