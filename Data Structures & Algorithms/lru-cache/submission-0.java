class LRUCache {
    Map<Integer, DllNode> dict;
    Map<DllNode, Integer> cache;
    DllNode head, tail;
    int capacity;

    public LRUCache(int capacity) {
        dict = new HashMap<>();
        cache = new HashMap<>();
        head = new DllNode(-1);
        tail = new DllNode(-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        DllNode k = dict.get(key);
        if (k == null) return -1;

        DllNode prev = k.prev;
        DllNode next = k.next;
        prev.next = next;
        next.prev = prev;
        k.prev = tail.prev;
        tail.prev.next = k;
        k.next = tail;
        tail.prev = k;

        return cache.get(k);
    }
    
    public void put(int key, int value) {
        DllNode k = dict.get(key);
        if (k == null) {
            k = new DllNode(key);
            dict.put(key, k);
        } else {
            DllNode prev = k.prev;
            DllNode next = k.next;
            prev.next = next;
            next.prev = prev;
        }
        cache.put(k, value);
        k.prev = tail.prev;
        tail.prev.next = k;
        k.next = tail;
        tail.prev = k;

        if (capacity < cache.size()) {
            DllNode rem = head.next;
            head.next = rem.next;
            rem.next.prev = head;
            dict.remove(rem.key);
            cache.remove(rem);
        }
    }
}

class DllNode {
    int key;
    DllNode prev;
    DllNode next;

    DllNode(int key) {
        this.key = key;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof DllNode)) return false;

        DllNode c = (DllNode) o;

        return c.key == this.key;
    }

    public int hashCode() {
        return Objects.hash(this.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */