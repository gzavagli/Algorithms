import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

    private Node head = null;

    BinaryTree(T val) {
        head = new Node(val);
    }

    public void balancedInsert(T val) {

        if (head == null) {
            head = new Node(val);
            return;
        }

        boolean found = false;
        Queue<Node> queue = new LinkedList<>();

        queue.add(head);
        Node n = null;

        while (!found) {
            n = queue.remove();

            if (n.left == null) {
                found = true;
                break;
            } else {
                queue.add(n.left);
            }

            if (n.right == null) {
                found = true;
                break;
            } else {
                queue.add(n.right);
            }
        }

        if (n.left == null) {
            n.left = new Node(val);
        } else if (n.right == null) {
            n.right = new Node(val);
        } else {
            System.out.println("Something really bad happened!!!");
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("(tree is empty)");
            return;
        }

        Queue<Node> qn = new LinkedList<>();
        Queue<Node> qn1 = new LinkedList<>();

        qn.add(head);
        Node n = null;

        while (!qn.isEmpty()) {
            while (!qn.isEmpty()) {
                n = qn.remove();
                System.out.print(n.value + " ");
                if (n.left != null) {
                    qn1.add(n.left);
                    if (n.right != null) {
                        qn1.add(n.right);
                    }
                }
            }
            qn = new LinkedList<>(qn1);
            qn1.clear();
            System.out.println();
        }
    }

    private class Node {
        T value;
        Node left = null;
        Node right = null;

        Node(T val) {
            this.value = val;
            this.left = null;
            this.right = null;
        }
    }


}
