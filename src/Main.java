

public class Main {

    static int count = 0;

    public static void main(String[] args) {

        //linkedListTest();
        //stackTest();
        //binaryTreeTest();
        //fibonacciTest();
        //stepsTest();
        sortTest();

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

    private static void fibonacciTest() {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        System.out.println(Fibonacci.fibonacci(40));
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        System.out.println(Fibonacci.fibonacciMemoization(1000));
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");



    }

    private static void stepsTest() {
        int n = steps(0, 15);
        System.out.println("Solutions: " + n);
        System.out.println("Count: " + count);
    }

    private static int steps(int start, int target) {

        count++;

        int solutions = 0;
        int steps;

        for (int i = 1; i <= 3; i++) {
            steps = start + i;
            if (steps == target) {
                solutions++;
            } else if (steps < target) {
                solutions += steps(steps, target);
            } else {
                // steps already above target, do nothing
            }
        }

        return solutions;
    }

    private static void sortTest() {
        int listLength = 50000;
        int[] masterList = new int[listLength];
        int[] list = new int[listLength];
        Sorting.initRandom(masterList, 100);

        long startTime;
        long endTime;

        Sorting.copyList(masterList, list);
        startTime = System.currentTimeMillis();
        Sorting.bubbleSort(list);
        endTime = System.currentTimeMillis();
        System.out.println("Bubble sort: " + (endTime - startTime) + " milliseconds");

        Sorting.copyList(masterList, list);
        startTime = System.currentTimeMillis();
        Sorting.selectionSort(list);
        endTime = System.currentTimeMillis();
        System.out.println("Selection sort: " + (endTime - startTime) + " milliseconds");

        Sorting.copyList(masterList, list);
        startTime = System.currentTimeMillis();
        Sorting.mergeSort(list);
        endTime = System.currentTimeMillis();
        System.out.println("Merge sort: " + (endTime - startTime) + " milliseconds");

    }
}
