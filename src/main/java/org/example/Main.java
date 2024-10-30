package org.example;

//package Modul_3_Demo;

import java.util.Scanner;

public class Main {

     final static double DISKON_MEMBER = 0.20;
    static boolean pesanMakanan = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Menu(scan);
    }

    public static void Menu(Scanner scan) {
        boolean repeat = true;
        while (repeat) {
            System.out.println("\nMenu restoran");
            System.out.println("1. Menu Makanan dan Minuman");
            System.out.println("2. Nanya Password Wifi");
            System.out.println("3. Keluar");
            System.out.print("Pilihan (1-3): ");
            int pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1:
                    Makanan_minuman(scan);
                    break;

                case 2:
                    if (pesanMakanan) {
                        voucher(scan);
                    } else {
                        System.out.println("Silakan pesan makanan terlebih dahulu sebelum bisa nanya password wifi.");
                    }
                    break;

                case 3:
                    repeat = false;
                    System.out.println("Terima kasih telah berkunjung!");
                    break;

                default:
                    System.out.println("Input tidak sesuai");
                    break;
            }
        }
    }

    public static void Makanan_minuman(Scanner scan) {
        int totalBelanjaan = 0;
        boolean ulangi = true;
        pesanMakanan = true;


        while (ulangi) {
            System.out.println("");
            System.out.println("Menu Makanan dan Minuman:");
            System.out.println("1. Nasi goreng - 10.000");
            System.out.println("2. Mie goreng  - 12.000");
            System.out.println("3. Nasi lemak  - 12.500");
            System.out.println("4. Ayam        - 12.500");
            System.out.println("5. Bebek       - 13.000");
            System.out.println("6. Sapi        - 13.500");
            System.out.println("7. Aqua        - 5.000");
            System.out.println("8. Es Teh      - 4.000");
            System.out.println("9. Es jeruk    - 4.500");
            System.out.println("10. Es Kopi     - 5.500");
            System.out.println("11. Cleo        - 5.000");
            System.out.println("12. Jus mangga  - 13.500");
            System.out.println("13. Exit");
            System.out.println("");
            System.out.println("Total belanjaan: " + totalBelanjaan);
            System.out.print("Pilihan (1-12): ");


            int pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1:
                    totalBelanjaan += 10000;
                    break;
                case 2:
                    totalBelanjaan += 12000;
                    break;
                case 3:
                    totalBelanjaan += 12500;
                    break;
                case 4:
                    totalBelanjaan += 12500;
                    break;
                case 5:
                    totalBelanjaan += 13000;
                    break;
                case 6:
                    totalBelanjaan += 13500;
                    break;
                case 7:
                    totalBelanjaan += 5000;
                    break;
                case 8:
                    totalBelanjaan += 4000;
                    break;
                case 9:
                    totalBelanjaan += 4500;
                    break;
                case 10:
                    totalBelanjaan += 5500;
                    break;
                case 11:
                    totalBelanjaan += 5000;
                    break;
                case 12:
                    totalBelanjaan += 13500;
                    break;
                case 13:
                    ulangi = false;
                    pembayaran(scan, totalBelanjaan);
                    break;
                default:
                    System.out.println("Input tidak sesuai");
                    break;
            }
        }
    }

    public static void pembayaran(Scanner scan, int totalBelanjaan) {
        System.out.print("Apakah Anda member? (y/n): ");
        String member = scan.nextLine();

        if (member.equalsIgnoreCase("y")) {
            double diskon = totalBelanjaan * DISKON_MEMBER;
            totalBelanjaan -= diskon;
            System.out.println("Anda mendapatkan diskon 20% sebesar: " + (int) diskon);
        }

        boolean loop = true;
        int pay;
        while (loop) {
            System.out.println("Total yang harus dibayar: " + totalBelanjaan);
            System.out.print("Masukkan jumlah pembayaran: ");
            pay = scan.nextInt();
            scan.nextLine();

            if (pay >= totalBelanjaan) {
                int kembalian = pay - totalBelanjaan;
                System.out.println("Pembayaran berhasil. Kembalian Anda: " + kembalian);
                loop = false;
            } else {
                System.out.println("Uang Anda kurang. Silakan bayar sesuai total belanja.");
            }
        }

        Menu(scan);
    }

     public static void voucher(Scanner scan) {
             System.out.println("\nVoucher wifi");
             System.out.println("Username: slebew_99");
             System.out.println("Password: satusampai9\n");

             Menu(scan);
         }
}
