import java.util.*;
// Represents a node used to store key counts and keys with specified count.
class FrequencyNode {
    int count;
    Set<String> keys;
    FrequencyNode prev;
    FrequencyNode next;

    public FrequencyNode(int count) {
        this.count = count;
        keys = new HashSet<>();
        this.prev = null;
        this.next = null;
    }
}

class AllOne {
    // Space Complexity: O(N) to store each key -> node in the HashMap.
    //                   In the list, each key is stored only once.
    //                   We trade space in order to get O(1).

    // Dummy nodes used for easy access to max and min key.
    private FrequencyNode minDummy;
    private FrequencyNode maxDummy;
    // Maps Strings to their FrequencyNode for O(1) access.
    private HashMap<String, FrequencyNode> map;

    public AllOne() {
        this.minDummy = new FrequencyNode(0);
        this.maxDummy = new FrequencyNode(0);
        minDummy.next = maxDummy;
        maxDummy.prev = minDummy;
        this.map = new HashMap<>();
    }

    // Inserts a FrequencyNode toInsert after node.
    private void insert(FrequencyNode node, FrequencyNode toInsert) {
        toInsert.prev = node;
        toInsert.next = node.next;
        node.next.prev = toInsert;
        node.next = toInsert;
    }

    // Deletes a FrequencyNode from the list.
    // Assumes you don't call this method on minDummy, maxDummy, or a null node.
    private void delete(FrequencyNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void inc(String key) {
        // Time Complexity: O(1) since HashMap allows for instant access to the desired node
        //                  and linked list operations don't require scanning.
        
        // Two scenarios:
        // Scenario 1: Key does not exist yet so insert it with count 1.
        //             If count 1 frequency node does not exist, create it at the start.
        //             minDummy points to it.
        //             In either case, add key to the set for this node.
        // Scenario 2: Key does exist so insert it at node with count + 1.
        //             Get where the node is using the map.  Check if the node at count + 1 exists.
        //             The list always maintains sorted ordering, so count + 1 is always next node.
        //             If it exits, add key to the set and remove from old node's set.
        //             If it doesn't exist, create the node and add key to the set.
        //             If the frequency node at count has no more keys, then remove it from the
        //             list, and adjust pointers.

        if (!map.containsKey(key)) {
            FrequencyNode node1 = minDummy.next;
            if (node1 == maxDummy || node1.count != 1) {
                node1 = new FrequencyNode(1);
                insert(minDummy, node1);
            }

            map.put(key, node1);
            node1.keys.add(key);
        } else {
            FrequencyNode nodeKeyCount = map.get(key);
            FrequencyNode nextNode = nodeKeyCount.next;
            if (nextNode == maxDummy || nextNode.count != nodeKeyCount.count + 1) {
                nextNode = new FrequencyNode(nodeKeyCount.count + 1);
                insert(nodeKeyCount, nextNode);
            }

            map.put(key, nextNode);
            nextNode.keys.add(key);
            nodeKeyCount.keys.remove(key);
            if (nodeKeyCount.keys.size() == 0) {
                delete(nodeKeyCount);
            }
        }
    }
    
    public void dec(String key) {
        // Time Complexity: O(1) since HashMap allows for instant access to the desired node
        //                  and linked list operations don't require scanning.

        // Two Scenarios:
        // Key is guaranteed to exist in the data structure before decrement.
        // Scenario 1: Key has count of 1. We need to remove it from the data structure.
        // Scenario 2: Key has count > 1. We move the key to count - 1 node.
        //             If it exists, we add it to the set.
        //             If it doesn't exist, we create the node and add it to the set.
        // Need to ensure map, set, and list are updated properly after every operation.

        FrequencyNode nodeKeyCount = map.get(key);
        if (nodeKeyCount.count == 1) {
            nodeKeyCount.keys.remove(key);
            if (nodeKeyCount.keys.isEmpty()) {
                delete(nodeKeyCount);
            }

            map.remove(key);
        } else {
            FrequencyNode prevNode = nodeKeyCount.prev;
            if (prevNode == minDummy || prevNode.count != nodeKeyCount.count - 1) {
                prevNode = new FrequencyNode(nodeKeyCount.count - 1);
                insert(nodeKeyCount.prev, prevNode);
            }

            map.put(key, prevNode);
            prevNode.keys.add(key);
            nodeKeyCount.keys.remove(key);
            if (nodeKeyCount.keys.isEmpty()) {
                delete(nodeKeyCount);
            }
        }
    }
    
    public String getMaxKey() {
        // Time Complexity: O(1) because of the dummy min node.

        return maxDummy.prev == minDummy ? "" : maxDummy.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        // Time Complexity: O(1) because of the dummy max node.

        return minDummy.next == maxDummy ? "" : minDummy.next.keys.iterator().next();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        AllOne obj = new AllOne();
    
        while (true) {
            System.out.println("Enter operation, type stop to end: ");
            String op = sc.nextLine();
    
            if (op.equals("stop")) {
                break;
            }
    
            if (op.equals("inc")) {
                System.out.println("Enter key: ");
                String key = sc.nextLine();
                obj.inc(key);
                System.out.println("null");
            } else if (op.equals("dec")) {
                System.out.println("Enter key: ");
                String key = sc.nextLine();
                obj.dec(key);
                System.out.println("null");
            } else if (op.equals("getMaxKey")) {
                System.out.println(obj.getMaxKey());
            } else if (op.equals("getMinKey")) {
                System.out.println(obj.getMinKey());
            }
        }
    
        sc.close();
    }
}