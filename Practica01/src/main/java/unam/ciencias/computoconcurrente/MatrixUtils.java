package unam.ciencias.computoconcurrente;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatrixUtils implements Runnable {
    private int threads;
    private double promedioSegmento;
    private int[] matrizDividida;

    public MatrixUtils() {
        this.threads = 1;
    }

    public MatrixUtils(int threads) {
        this.threads = threads > 1 ? threads : 1;
    }

    public MatrixUtils(int[] matrizDividida) {
        this.matrizDividida = matrizDividida;
        this.promedioSegmento = 0;
    }

    @Override
    public void run() {
        // Aqui va tu codigo
    }

    public double findAverage(int[][] matrix) throws InterruptedException {
        

        return 1.0;
    }

}
