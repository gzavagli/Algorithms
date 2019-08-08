import java.util.Random;

public class Sorting {

    public static void bubbleSort(int[] list) {

        boolean sorted = false;
        int i = 0;
        int temp;

        while (!sorted) {
            sorted = true;
            for (i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i + 1]) {
                    temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void initRandom(int[] list, int max) {

        Random rnd = new Random();

        for (int i = 0; i < list.length; i++) {
            list[i] = rnd.nextInt(max);
        }
    }

    public static void printList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] list) {
        int i, j, min, temp;
        for (i = 0; i < list.length - 1; i++) {
            min = i;
            for (j = i + 1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = list[min];
                list[min] = list[i];
                list[i] = temp;
            }
        }
    }

    public static void mergeSort(int[] list) {

        if (list.length < 2)
            return;

        // the first time we call mergeSort with m = -1 to indicate that this is the first run
        mergeSort(list, 0, -1, list.length - 1);

    }

    private static void mergeSort(int[] list, int l, int m, int r) {

        if (m == -1) {
            m = (l + r) / 2;
        }

        //System.out.println("mergeSort " + l + " " + m + " " + r);

        int temp;

        //  first, sort the left side
        if ((m - l) > 0) {
            if (m == (l + 1)) {
                // only a field of two, simple comparison
                if (list[l] > list[m]) {
                    temp = list[m];
                    list[m] = list[l];
                    list[l] = temp;
                }
            } else {
                mergeSort(list, l, (l + m)/2, m);
            }
        }

        // then, sort the right side
        if ((r - m) > 1) {
            if (r == (m + 2)) {
                // only a field of two, simple comparison
                if (list[m + 1] > list[r]) {
                    temp = list[m + 1];
                    list[m + 1] = list[r];
                    list[r] = temp;
                }
            } else {
                mergeSort(list, m + 1, (m + 1 + r)/2, r);
            }
        }

        // now, merge the two together
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];

        for (int i = 0; i < (m - l + 1); i++)
            left[i] = list[l + i];

        for (int i = 0; i < (r - m); i++)
            right[i] = list[m + i + 1];

        int i = 0;
        int j = 0;
        int k = l;

        while (k <= r) {
            //System.out.println("i: " + i + ", j: " + j + ", k: " + k);
            if (i >= left.length) {
                list[k] = right[j];
                j++;
            } else if (j >= right.length) {
                list[k] = left[i];
                i++;
            } else {
                if (left[i] < right[j]) {
                    list[k] = left[i];
                    i++;
                } else {
                    list[k] = right[j];
                    j++;
                }
            }
            k++;
        }

    }

    public static void copyList(int[] from, int[] to) {
        int l;

        if (from.length < to.length)
            l = from.length;
        else
            l = to.length;

        for (int i = 0; i < l; i++) {
            to[i] = from[i];
        }

    }

}
