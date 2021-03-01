package oop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(">>Program Eliminasi Gauss<<\n");

        oneclass.Main gauss = new oneclass.Main();

        System.out.print("Masukkan jumlah persamaan: ");
        int N = scan.nextInt();

        double[] B = new double[N];
        double[][] A = new double[N][N];

        System.out.println("\nMasukkan " + N + " angka koefisien persamaan: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("Matriks " + "[" + (i + 1) + "]" + "[" + (j + 1) + "]" + ": ");
                A[i][j] = scan.nextDouble();
            }
        }

        System.out.println("\nMasukkan " + N + " Solusi persamaan: ");
        for (int i = 0; i < N; i++) {
            System.out.print("Nilai Persamaan " + "[" + (i + 1) + "]" + ": ");
            B[i] = scan.nextDouble();
        }

        gauss.solve(A, B);
    }
}
