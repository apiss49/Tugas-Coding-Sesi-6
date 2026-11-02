package Belajar.Sesi6.Tugas;

import java.util.Scanner;
import java.util.Stack;

public class saldoStack {
    public static void main(String[] args) throws Exception {
        Scanner inputx = new Scanner(System.in);
        int balance = 2000000;
        Stack<Integer>transactions = new Stack<>();
        int nav;

        System.out.println("\nPilih Menu\n1. Penarikan\n2. Menyimpan\n3. Lihat Saldo\n4. Total Uang Masuk\n5. Total Uang Keluar\n6. Batalkan Transaksi Terakhir\n0. Exit");

        do {
            System.out.print("Pilih Menu: ");
            nav = inputx.nextInt();

            if (nav == 1) {
                if (balance == 0) {
                    System.out.println("Saldo anda 0");
                    continue;
                }
                System.out.print("Jumlah yang ditarik: ");
                int amount = inputx.nextInt();
                if (amount > balance) {
                    System.out.println("Saldo anda kurang, hanya: " + balance);
                    continue;
                }
                transactions.push(-amount);
                balance -= amount;
            } else if (nav == 2) {
                System.out.print("Jumlah yang disimpan: ");
                int amounts = inputx.nextInt();
                transactions.push(amounts);
                balance += amounts;
            } else if (nav == 3) {
                System.out.println("Saldo anda: "  + balance);
            } else if(nav == 4) {
                int total = 0;
                for (int t:transactions) {
                    if (t>0) {
                        total += t;
                    }
                }
                System.out.println("Total uang masuk: " + total);
            } else if (nav == 5) {
                int total = 0;
                for (int t:transactions) {
                    if (t<0) {
                        total += t;
                    }
                }
                System.out.println("Total uang keluar: "+(total*-1));
            } else if (nav == 6) {
                if (transactions.isEmpty()) {
                    System.out.println("Belum ada transaksi untuk di batalkan");
                    continue;
                }
                int last = transactions.pop();
                balance -= last;
                System.out.println("Transaksi terakhir dibatalkan ("+last+"). Saldo sekarang: " + balance);
            }
        } while (true);
        inputx.close();
    }
}