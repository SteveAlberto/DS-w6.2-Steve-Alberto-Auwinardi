import java.util.*;

public class DataStructureDetective {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            boolean isStack = true;
            boolean isQueue = true;
            boolean isPQ = true;

            for (int i = 0; i < n; i++) {
                int type = sc.nextInt();
                int value = sc.nextInt();

                if (type == 1) {
                    if (isStack) stack.push(value);
                    if (isQueue) queue.add(value);
                    if (isPQ) pq.add(value);
                } else {
                    if (isStack) {
                        if (stack.isEmpty() || !stack.pop().equals(value)) isStack = false;
                    }
                    if (isQueue) {
                        if (queue.isEmpty() || !queue.poll().equals(value)) isQueue = false;
                    }
                    if (isPQ) {
                        if (pq.isEmpty() || !pq.poll().equals(value)) isPQ = false;
                    }
                }
            }

            int count = 0;
            if (isStack) count++;
            if (isQueue) count++;
            if (isPQ) count++;

            if (count == 0) {
                System.out.println("tidak ada");
            } else if (count > 1) {
                System.out.println("tidak yakin");
            } else {
                if (isStack) System.out.println("stack");
                else if (isQueue) System.out.println("queue");
                else System.out.println("priority queue");
            }
        }
        sc.close();
    }
}