

public class Main {

    public static void main(String[] args) {

        //linkedListTest();
        //stackTest();
        binaryTreeTest();

    }

    private static void linkedListTest() {
        LinkedList<Integer> list = new LinkedList<>(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(2);
        list.append(3);
        list.append(6);
        list.append(3);
        list.append(1);
        list.print();
        System.out.println();

        list.removeDuplicates();
        list.print();
        System.out.println();

        LinkedList<String> list2 = new LinkedList<>("a");
        list2.append("b");
        list2.append("c");
        list2.append("a");
        list2.print();
        System.out.println();

        list2.removeDuplicates();
        list2.print();
        System.out.println();
    }

    private static void stackTest() {
        Stack<Integer> stack = new Stack<>(3);
        stack.print();
        System.out.println(stack.isEmpty());
        stack.push(2);
        stack.print();
        System.out.println("min: " + stack.min());
        System.out.println(stack.peek());
        System.out.println("min: " + stack.min());

        stack.print();

        stack.push(1);
        stack.print();
        System.out.println("min: " + stack.min());
        stack.pop();
        stack.print();
        System.out.println("min: " + stack.min());
    }

    private static void binaryTreeTest() {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.balancedInsert(2);
        tree.balancedInsert(3);
        tree.balancedInsert(4);
        tree.balancedInsert(5);
        tree.balancedInsert(6);
        tree.balancedInsert(7);
        tree.balancedInsert(8);
        tree.balancedInsert(9);
        tree.balancedInsert(10);

        tree.print();
    }

}
