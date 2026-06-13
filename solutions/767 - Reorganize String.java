import java.util.*;
class Solution {
    public String reorganizeString(String s) {
        // Time Complexity: O(N * Log26). O(N) to count frequencies.
        //                  O(26) to find maximum frequency. O(26 * Log26) to build max heap.
        //                  O(N * Log26) to loop over all chars and add to heap.
        // Space Complexity: O(N) for StringBuilder.
        //                   Also O(26) for frequency array and PriorityQueue.

        // Check for solvability first.
        // For odd number of characters, there are (N + 1) / 2 safe spots.
        // For even number of characters, there are N / 2 safe spots.
        // So (N + 1) / 2 safe spots work for all strings.
        // We need maxFrequency <= (N + 1) / 2 by pigeonhole to ensure no adjacent characters.
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int maxFrequency = 0;
        for (int i : freq) {
            maxFrequency = Math.max(maxFrequency, i);
        }

        if (maxFrequency > (s.length() + 1) / 2) {
            return "";
        }

        // Max-Heap gives instant access to the most frequent character at any time.
        // Greedily place high frequency characters to lower risk of duplicates later.
        // We store the index of the elements in the frequency array.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> freq[b] - freq[a]);

        // Push all characters that exist in the string into the max-heap.
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int prev = -1;
        while (!maxHeap.isEmpty()) {
            int maxFreqChar = maxHeap.poll();
            sb.append((char)(maxFreqChar + 'a'));
            freq[maxFreqChar]--;

            if (prev != -1) {
                maxHeap.add(prev);
            }
            
            if (freq[maxFreqChar] == 0) {
                prev = -1;
            } else {
                prev = maxFreqChar;
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter string: ");
        String s = sc.nextLine();
    
        Solution sol = new Solution();
        String result = sol.reorganizeString(s);
    
        System.out.println("Reorganized string: ");
        System.out.println(result);
    
        sc.close();
    }
}