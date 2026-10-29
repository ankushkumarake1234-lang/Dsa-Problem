class Node {
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    HashMap<Integer, Node> hm;
    Node head;
    Node tail;
    int c;
    public LRUCache(int capacity) {
        c = capacity;
        hm = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1;
        }
        Node node = hm.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = hm.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            insert(node);
            return;
        }
        if (hm.size() == c) {
            remove(tail.prev);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
    }
    public void remove(Node node) {
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void insert(Node node) {
        hm.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */