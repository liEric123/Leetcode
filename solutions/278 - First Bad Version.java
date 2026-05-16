import java.util.*;

class VersionControl {
    static int bad;

    boolean isBadVersion(int version) {
        return version >= bad;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Time Complexity: O(LogN) for binary search.
        // Space Complexity: O(1) for a few variables.
        int l = 1;
        int r = n;
        int first = n;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                first = Math.min(first, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return first;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Enter bad version: ");
        VersionControl.bad = sc.nextInt();

        System.out.println("First bad version: ");
        System.out.println(new Solution().firstBadVersion(n));

        sc.close();
    }
}