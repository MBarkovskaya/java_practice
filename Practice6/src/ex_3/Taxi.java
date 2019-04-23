package ex_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Taxi {
    public static void main(String[] args) {
        int[] groups = new int[setNumber()];
        System.out.println("Введите количество пасажиров в группе от одного до четырех");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<groups.length; i++) {
            try {
                groups[i] = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            countTaxi(groups);
    }


    private static void countTaxi(int[] groups) {
        int[] counts = new int[4];
        for (int group : groups) {
            counts[group - 1] += 1;
        }

        int[] taxiKinds = new int[4];
        int taxiTotal = 0;
        // группы по 4
        taxiTotal += counts[3];
        taxiKinds[3] = counts[3];

        // 3 & 1
        int threeAndOne = Math.min(counts[0], counts[2]);
        taxiTotal += threeAndOne;
        taxiKinds[3] += threeAndOne;
        counts[0] -= threeAndOne;
        counts[2] -= threeAndOne;

        // 2
        int two = counts[1] / 2;
        taxiTotal += two;
        taxiKinds[3] += two;
        counts[1] = counts[1] % 2;

        if (counts[2] > 0) { // есть тройки
            taxiKinds[2] = counts[2];
            taxiTotal += counts[2];

            taxiKinds[1] = counts[1];
            taxiTotal += counts[1];
        } else { // есть единички
            if (counts[1] > 0) {
                taxiTotal++;
                counts[0] -= 2;
                taxiKinds[3]++;
            }

            int ones = counts[0] / 4;
            taxiTotal += ones;
            taxiKinds[3] += ones;

            if (counts[0] % 4 > 0) {
                taxiTotal++;
                taxiKinds[(counts[0] % 4) - 1]++;
            }
        }

        System.out.println("Taxi total: " + taxiTotal);
        System.out.println("Taxi counts: " + taxiKinds[0] + ", " + taxiKinds[1] + ", " + taxiKinds[2] + ", " + taxiKinds[3]);
    }

    private static int setNumber() {
        int number = 0;
        System.out.println("Введите общее количество групп");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }
}
