package Belajar.Sesi6.Tugas;

import java.util.ArrayList;
import java.util.Scanner;

public class arrayList {
    public static void main(String[] args) throws Exception {
        Scanner inputx = new Scanner(System.in);
        int balance = 2000000;
        ArrayList<Integer> transactions = new ArrayList<>();
        int nav;

        System.out.println("\n\nPilih Menu \n1.Penarikan \n2.Menyimpan \n3.Lihat Saldo \n4.Total Uang Masuk \n5.Total Uang Keluar \n0.Exit");

        do {
            System.out.print("Pilih Menu: ");
            nav = inputx.nextInt();

            if (nav == 0) break;

            if (nav == 1) {
                if (balance == 0) {
                    System.out.println("Saldo anda 0");
                    continue;
                }
                System.out.print("Jumlah yang ditarik: ");
                int amount = inputx.nextInt();
                if (amount > balance) {
                    System.out.println("Saldo anda kurang, hanya " + balance);
                    continue;
                }
                transactions.add(-amount);
                balance -= amount;
            } else if (nav == 2) {
                System.out.print("Jumlah yang disimpan: ");
                int amounts = inputx.nextInt();
                transactions.add(amounts);
                balance += amounts;
            } else if (nav == 3) {
                System.out.println("Saldo Anda : " + balance);
            } else if (nav == 4) {
                int total = 0;
                for (int t : transactions) {
                    if (t > 0) {
                        total += t;
                    }
                }
                System.out.println("Total Uang Masuk : " + total);
            } else if (nav == 5) {
                int total = 0;
                for (int t : transactions) {
                    if (t < 0) {
                        total += t;
                    }
                }
                System.out.println("Total Uang Keluar : " + (total * -1));
            }
        } while (true);
        inputx.close();
    }
}