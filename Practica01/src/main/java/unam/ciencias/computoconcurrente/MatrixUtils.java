package unam.ciencias.computoconcurrente;
/*
Becerril Lara Francisco Javier
Juan Carlos Zenteno Pompa
Hernández Navarro Armando
Emiliano Domínguez Cruz
*/
import java.util.ArrayDeque;
import java.util.Arrays;

public class MatrixUtils implements Runnable {
    private int threads;
    // Cambiamos el tipo de dato de este resultado porque si no el programa sería erroneo para una matriz triangular.
    private int sumaSegmento;
    private int[] matrizDividida;

    public MatrixUtils() {
        this.threads = 1;
    }

    public MatrixUtils(int threads) {
        this.threads = threads > 1 ? threads : 1;
    }

    public MatrixUtils(int[] matrizDividida) {
        this.matrizDividida = matrizDividida;
        this.sumaSegmento = 0;
    }

    @Override
    public void run() {
        sumaSegmento = Arrays.stream(matrizDividida).reduce(0, (a, b) -> a+b);
    }

    public double findAverage(int[][] matrix) throws InterruptedException {
        MatrixUtils[] mats = new MatrixUtils[matrix.length];
        ArrayDeque<Thread> queue = new ArrayDeque<Thread>();
        int itemCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            itemCount += matrix[i].length;
            mats[i] = new MatrixUtils(matrix[i]);

            if (queue.size() > threads) 
                queue.pop().join();

            Thread t = new Thread(mats[i]);
            t.run();
            queue.push(t);
        }

        for (Thread t : queue) 
            t.join();
        
        double sum = Arrays.stream(mats)
            .mapToInt(m -> m.sumaSegmento)
            .reduce(0, (a, b) -> a + b);
        
        return sum / itemCount;
    }
    
}                          
