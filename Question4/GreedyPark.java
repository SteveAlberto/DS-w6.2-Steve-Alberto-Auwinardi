package Question4;
import java.util.*;

public class GreedyPark{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan jumlah, nama dan uang (pisahkan dengan koma & spasi): ");

        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] names = scanner.nextLine().split(", ");
        String[] moneyStr = scanner.nextLine().split(", ");

        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(moneyStr[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (money[j] < money[j + 1]) {
                    int tempMoney = money[j];
                    money[j] = money[j + 1];
                    money[j + 1] = tempMoney;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                }
            }
        }

        Queue<String> nameQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!names[i].equals("Jeff")) {
                nameQueue.add(names[i]);
            }
        }
        System.out.println(nameQueue);
        scanner.close();
    }
}