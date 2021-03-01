package oop;

public class Gauss {

    public void solve(double[][] A, double[] B) {
        int N = B.length;
        for (int k = 0; k < N; k++) {
            // mencari baris yang akan di putar
            int max = k;
            for (int i = k + 1; i < N; i++)
                if (Math.abs(A[i][k]) > Math.abs(A[max][k]))
                    max = i;

            // menukar baris di matriks A
            double[] temp = A[k];
            A[k] = A[max];
            A[max] = temp;

            // tukar hasil yang sesuai di matriks konstanta
            double t = B[k];
            B[k] = B[max];
            B[max] = t;

            // pivot dalam A dan B
            for (int i = k + 1; i < N; i++) {
                double factor = A[i][k] / A[k][k];
                B[i] -= factor * B[k];
                for (int j = k; j < N; j++)
                    A[i][j] -= factor * A[k][j];
            }
        }

        // tampilkan baris eselon
        printBarisEselon(A, B);

        // back substitution
        double[] solution = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++)
                sum += A[i][j] * solution[j];
            solution[i] = (B[i] - sum) / A[i][i];
        }
        // Print solution
        printSolusi(solution);
    }

    // fungsi untuk menampilkan bentuk eselon dalam baris
    public void printBarisEselon(double[][] A, double[] B) {
        int N = B.length;
        System.out.println("\nHasil matriks nya adalah : ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf("%.2f ", A[i][j]);
            System.out.printf("| %.2f\n", B[i]);
        }
        System.out.println();
    }

    // Fungsi untuk print hasilnya
    public void printSolusi(double[] sol) {
        int N = sol.length;
        System.out.println("Hasil X nya adalah : ");
        for (int i = 0; i < N; i++) {
            System.out.print("X" + (i + 1) + " = ");
            System.out.printf("%.2f ", sol[i]);
            System.out.println();
        }
        System.out.println();
    }
}
