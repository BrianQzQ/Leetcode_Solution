import java.util.HashMap;
import java.util.Map;

public class LRUCache1 {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;
    int CAP;
    Map<Integer, Node> m;
    int size;

    public LRUCache1(int capacity) {
        CAP = capacity;
        size = 0;
        m = new HashMap<>(CAP);
    }

    public int get(int key) {
        Node node = m.get(key);
        if (node != null) {
            remove(node);
            insert(node);
        }
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        Node node = m.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            insert(node);
        } else {
            Node nod = new Node(key, value);
            if (size == 0) {
                // head=tail=nod;
                insert(nod);
                size++;
                m.put(key, nod);
                //insert(nod);
            } else if (size < CAP) {
                insert(nod);
                size++;
                // m.put(key,nod);
            } else {
                // m.remove(tail.key);
                remove(tail);
                insert(nod);
                //m.put(key,node);
            }
        }
    }

    void remove(Node node) {
        m.remove(node.key);
        if (head == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head=head.next;
            head.prev=null;
        } else if (node == tail) {
            tail = node.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    void insert(Node node) {
        m.put(node.key, node);
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.prev = null;
            node.next = head;
            head = node;
        }
    }
}
