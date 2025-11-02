package problem4;

import java.util.*;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;        // total elements in each list
    private static final int OPERATIONS = 10_000;   // number of operations for testing

    public static void main(String[] args) {

        // Create lists
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("---- Performance Comparison ----\n");

        // 1️⃣ Populate both lists
        System.out.println("Populating both lists with " + SIZE + " elements...");
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("Done.\n");

        // 2️⃣ Random insertions and deletions
        testRandomInsertDelete(arrayList, "ArrayList");
        testRandomInsertDelete(linkedList, "LinkedList");

        // 3️⃣ Sequential insertions/deletions at beginning and end
        testSequentialInsertDelete(arrayList, "ArrayList");
        testSequentialInsertDelete(linkedList, "LinkedList");

        // 4️⃣ Random access test
        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");

        System.out.println("\n---- Test Completed ----");
    }

    // ------------------------------------------------------------
    // Random insertions/deletions in the middle of the list
    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        for (int i = 0; i < OPERATIONS; i++) {
            int index = random.nextInt(list.size());
            list.add(index, random.nextInt(SIZE)); // insert
            list.remove(index);                    // delete
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------
    // Sequential insertions/deletions at beginning and end
    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();

        for (int i = 0; i < OPERATIONS; i++) {
            if (list instanceof LinkedList) {
                LinkedList<Integer> ll = (LinkedList<Integer>) list;
                ll.addFirst(i);
                ll.removeFirst();
                ll.addLast(i);
                ll.removeLast();
            } else {
                list.add(0, i);
                list.remove(0);
                list.add(list.size() - 1, i);
                list.remove(list.size() - 1);
            }
        }

        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------
    // Random access test using get(index)
    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        long sum = 0;
        for (int i = 0; i < OPERATIONS; i++) {
            int index = random.nextInt(list.size());
            sum += list.get(index); // unboxing happens here
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }
}

