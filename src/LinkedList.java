

public class LinkedList<T> {

    private Node head;

    LinkedList(T val) {
        head = new Node(val);
    }

    LinkedList(Node n) {
        head = n;
    }

    public void append(T val) {
        Node n = head;

        while (n.next != null)
            n = n.next;

        n.next = new Node(val);
    }

    public void print() {
        Node n = head;
        while (n != null) {
            System.out.print(n.value + " ");
            n = n.next;
        }
    }

    private boolean find(T val, Node node) {
        Node n = node;
        while (n != null) {
            if (n.value == val)
                return true;
            n = n.next;
        }

        return false;
    }

    private boolean exists(T val, Node start, Node end) {
        //System.out.println("exists(" + val + ", " + start + ", " + end);
        Node n = start;
        while (n != null && n != end) {
            if (n.value == val)
                return true;
            n = n.next;
        }

        return false;
    }

    public void removeDuplicates() {

        //System.out.println("removeDuplicates()");

        if ((head == null) || (head.next == null))
            return;

        Node prev = head;
        Node n = head.next;

        while (n != null) {
            if (exists(n.value, head, n)) {
                prev.next = n.next;
                n = n.next;
            } else {
                prev = n;
                n = n.next;
            }
        }
    }


    private class Node {
        T value;
        Node next = null;

        Node(T val) {
            this.value = val;
            this.next = null;
        }
    }

}
