package Question3;

import java.util.*;

public class DoorResponse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan jumlah, nama dan kesempatan (pisahkan dengan spasi): ");


        int n = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split(" ");
        String[] chancesStr = scanner.nextLine().split(" ");

        Queue<String> nameQueue = new LinkedList<>();
        Queue<Integer> chanceQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            nameQueue.add(names[i]);
            chanceQueue.add(Integer.parseInt(chancesStr[i]));
        }

        while (!nameQueue.isEmpty()) {
            String currentName = nameQueue.poll();
            int currentChance = chanceQueue.poll();

            currentChance--;

            if (currentChance > 0) {
                System.out.println(currentName + "|Try Again|" + currentChance);
                nameQueue.add(currentName);
                chanceQueue.add(currentChance);
            } else {
                System.out.println(currentName + "|Get Out|0");
            }
        }

        scanner.close();
    }
}