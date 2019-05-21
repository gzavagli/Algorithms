public class Stack<T extends Comparable<T>> {

    private Node head = null;
    private Node min = null;

    Stack(T val) {
        head = new Node(val);
        min = head;
        head.next = null;
    }

    public void push (T val) {
        Node n = head;
        if (n == null) {
            head = new Node(val);
            head.next = null;
            return;
        }

        while (n.next != null) {
            n = n.next;
        }

        n.next = new Node(val);
        n = n.next;

        //System.out.println("compare " + val + " and " + min.value);
        if (val.compareTo(min.value) < 0) {
            //System.out.println("<0");
            min = n;
        } else if (val.compareTo(min.value) > 0) {
            //System.out.println(">0");
        } else {
            //System.out.println("=0");
        }
    }

    public T pop() {
        Node n = head;
        if (n == null)
            return null;

        T ret = n.value;

        if (n.next == null) {
            head = null;
            return ret;
        }

        Node prev = head;
        n = head.next;

        while (n.next != null) {
            prev = n;
            n = n.next;
        }

        boolean findNewMin = false;
        if (n == min) {
            findNewMin = true;
        }

        ret = n.value;
        prev.next = null;

        //System.out.println("findNewMin: " + findNewMin);
        if (findNewMin) {
            n = head;
            min = head;
            while (n != null) {
                //System.out.println("compare " + n.value + " and " + min.value);
                if (n.value.compareTo(min.value) < 0) {
                    min = n;
                }
                n = n.next;
            }
        }

        return ret;
    }

    public T peek() {
        Node n = head;
        if (n == null)
            return null;

        while (n.next != null) {
            n = n.next;
        }

        return n.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T min() {
        return min.value;
    }

    public void print() {
        Node n = head;

        while (n != null) {
            System.out.print(n.value + " ");
            n = n.next;
        }

        System.out.println();
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
