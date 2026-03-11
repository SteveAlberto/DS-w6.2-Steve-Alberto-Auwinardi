package Question1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PostService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        String[] names = new String[n];
        int[] durations = new int[n];
        int[] priorities = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = scanner.next();
            durations[i] = scanner.nextInt();
            priorities[i] = scanner.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (priorities[j] < priorities[minIdx]) {
                    minIdx = j;
                }
            }
            
            int tempPrio = priorities[i];
            priorities[i] = priorities[minIdx];
            priorities[minIdx] = tempPrio;

            int tempDur = durations[i];
            durations[i] = durations[minIdx];
            durations[minIdx] = tempDur;

            String tempName = names[i];
            names[i] = names[minIdx];
            names[minIdx] = tempName;
        }

        Queue<String> queuedNames = new LinkedList<>();
        Queue<Integer> queuedDurations = new LinkedList<>();
        Queue<String> sentNames = new LinkedList<>(); 
        
        int time = 0;
        int pendingIdx = 0; 

        while (sentNames.size() < n) {
            boolean adaPerubahan = false;

            if (queuedNames.isEmpty() && pendingIdx < n) {
                int currentPrio = priorities[pendingIdx];
                
                while (pendingIdx < n && priorities[pendingIdx] == currentPrio) {
                    queuedNames.add(names[pendingIdx]);
                    queuedDurations.add(durations[pendingIdx]);
                    pendingIdx++;
                }
                adaPerubahan = true;
            }

            if (adaPerubahan) {
                printStatus(time, names, pendingIdx, n, queuedNames, sentNames);
                adaPerubahan = false; 
            }

            time++;

            int size = queuedNames.size();
            for (int i = 0; i < size; i++) {
                String currentName = queuedNames.poll();
                int currentDur = queuedDurations.poll();

                currentDur--; 

                if (currentDur == 0) {
                    sentNames.add(currentName);
                    adaPerubahan = true;
                } else {
                    queuedNames.add(currentName);
                    queuedDurations.add(currentDur);
                }
            }

            if (adaPerubahan) {
                printStatus(time, names, pendingIdx, n, queuedNames, sentNames);
            }
        }

        scanner.close();
    }

    static void printStatus(int time, String[] names, int pendingIdx, int n, Queue<String> queuedNames, Queue<String> sentNames) {
        String p = "";
        for (int i = pendingIdx; i < n; i++) p += names[i] + " ";

        String q = "";
        for (String s : queuedNames) q += s + " ";

        String sStr = "";
        for (String s : sentNames) sStr += s + " ";

        System.out.println(time + " " + p.trim() + " | " + q.trim() + " | " + sStr.trim());
    }
}