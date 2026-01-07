import java.util.*;
class TimeMap {
    // Space Complexity: O(N) for the maps.
    //                   They map each key with its values and timestamps.
    private Map<String, List<Integer>> timeMap;
    private Map<String, List<String>> valueMap;

    public TimeMap() {
        timeMap = new HashMap<>();
        valueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // Time Complexity: O(1) to add to the maps.
        //                  No sorting needed because timestamps are strictly increasing.
        // Space Complexity: O(1) to add one timestamp and value.
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
            valueMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(timestamp);
        valueMap.get(key).add(value);
    }
    
    public String get(String key, int timestamp) {
        // Time Complexity: O(LogN) to binary search for the largest timestamp less than target.
        // Space Complexity: O(1) for a few variables.
        if (!timeMap.containsKey(key)) {
            return "";
        }
        List<Integer> times = timeMap.get(key);
        List<String> values = valueMap.get(key);

        int left = 0;
        int right = times.size() - 1;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // valid candidate but keep searching for better
            if (times.get(mid) <= timestamp) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (answer == -1) {
            return "";
        }
        return values.get(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TimeMap timeMap = new TimeMap();

        System.out.println("Type 'set', 'get', or 'exit'");

        while (true) {
            System.out.println("Enter operation:");
            String op = sc.nextLine();

            if (op.equals("exit")) {
                System.out.println("Exiting program");
                break;
            }

            if (op.equals("set")) {
                System.out.println("Enter key:");
                String key = sc.nextLine();

                System.out.println("Enter value:");
                String value = sc.nextLine();

                System.out.println("Enter timestamp:");
                int timestamp = sc.nextInt();
                sc.nextLine();

                timeMap.set(key, value, timestamp);
                System.out.println("Set operation completed");
            } 
            else if (op.equals("get")) {
                System.out.println("Enter key:");
                String key = sc.nextLine();

                System.out.println("Enter timestamp:");
                int timestamp = sc.nextInt();
                sc.nextLine();

                String result = timeMap.get(key, timestamp);
                System.out.println("Output: " + result);
            } 
            else {
                System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}