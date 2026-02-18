import java.util.*;
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        // Time Complexity: O(1) because loops to check all times and count bits are constant.
        // Space Complexity: O(1) for a few variables. Also, output list can't be that big.
        List<String> answer = new ArrayList<>();
        
        // Simulate all possible times.
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                // Count bits manually.
                int totBits = 0;
                int temp = i;
                while (temp > 0) {
                    totBits += temp & 1;
                    temp >>= 1;
                }
                temp = j;
                while (temp > 0) {
                    totBits += temp & 1;
                    temp >>= 1;
                }
                
                // Verify current time has same number of bits as desired time.
                if (totBits == turnedOn) {
                    answer.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter turnedOn: ");
        int turnedOn = sc.nextInt();
    
        Solution sol = new Solution();
        List<String> res = sol.readBinaryWatch(turnedOn);
    
        System.out.println("Times: ");
        System.out.println(res);
    
        sc.close();
    }    
}