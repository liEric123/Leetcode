import java.util.*;
// Definiton for a doubly-linked list.
// A doubly-linked list helps with fast insertion and removal.
class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;
    
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    // Time Complexity: O(1) for all methods.
    // Space Complexity: O(Capacity) for the HashMap and Linked-List.
    private int capacity;
    private HashMap<Integer, ListNode> map;
    private ListNode least;
    private ListNode most;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        least = new ListNode(0, 0);
        most = new ListNode(0, 0);
        least.next = most;
        most.prev = least;
    }
    
    public int get(int key) {
        // Time Complexity: O(1) to get from HashMap and update pointers.
        if (!map.containsKey(key)) {
            return -1;
        }
        // Updated most recently accessed key.
        ListNode node = map.get(key);
        remove(node);
        addToMost(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // Time Complexity: O(1) for HashMap operations and updating pointers.
        // If key already exists, remove the old ListNode.
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        // Add the new value as a ListNode.
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        addToMost(node);
        if (map.size() > capacity) {
            ListNode leastUsed = this.least.next;
            remove(leastUsed);
            map.remove(leastUsed.key);
        }
    }

    private void remove(ListNode node) {
        // Time Complexity: O(1) to update pointers.
        // Update pointers for previous and next nodes to remove current node.
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToMost(ListNode node) {
        // Time Complexity: O(1) to update pointers.
        // Add a node to the right (most recently used).
        node.prev = most.prev;
        node.next = most;
        most.prev.next = node;
        most.prev = node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter cache capacity:");
        int capacity = sc.nextInt();
        LRUCache cache = new LRUCache(capacity);
    
        System.out.println("Commands: put <key> <value>, get <key>, exit");
    
        while (true) {
            String cmd = sc.next();
    
            if (cmd.equals("exit")) {
                break;
            } else if (cmd.equals("put")) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                cache.put(key, value);
                System.out.println("DONE");
            } else if (cmd.equals("get")) {
                int key = sc.nextInt();
                System.out.println(cache.get(key));
            } else {
                System.out.println("Invalid command");
            }
        }
    
        sc.close();
    }
}