package unam.ciencias.computoconcurrente;

/*
Becerril Lara Francisco Javier
Juan Carlos Zenteno Pompa
Hernández Navarro Armando
Emiliano Domínguez Cruz
*/


import java.util.Iterator;
import java.util.stream.IntStream;

public class PrimeNumberCalculator implements Runnable {
    private int threads;
    private int numero;
    private int inicioSegmento;
    private int finalSegmento;
    private boolean resultado;

    public PrimeNumberCalculator() {
        this.threads = 1;
    }

    public PrimeNumberCalculator(int threads) {
        this.threads = threads > 1 ? threads : 1;
    }

    public PrimeNumberCalculator(int numero, int inicioSegmento, int finalSegmento) {
        this.numero = numero;
        this.inicioSegmento = inicioSegmento;
        this.finalSegmento = finalSegmento;
    }

    @Override
    public void run() {
        this.resultado = true;
        Iterator<Integer> range = IntStream.range(inicioSegmento, finalSegmento).iterator();

        while (range.hasNext()) {
            int i = range.next();
            if (numero % i == 0) {
                this.resultado = false;
                break;
            }
        }
    }

    /**
    * Metodo para saber si el número dado es primo.
    * @param n Número que queremos ver si es primo.
    * @throws InterruptedException
    * @return Si es primo o no es primo.
    */
    public boolean isPrime(int n) throws InterruptedException {
        if (n < 2) {
            return false;
        } 

        int range = (n - 2) / this.threads;
        int remainder = (n - 2) % this.threads;
        PrimeNumberCalculator[] calcs = new PrimeNumberCalculator[this.threads];
        Thread[] threads = new Thread[this.threads];

        int ptr = 2;
        for (int i = 0; i < this.threads; i++) {
            int end = ptr + range;
            if (0 < remainder--) end++;

            PrimeNumberCalculator calculator = new PrimeNumberCalculator(n, ptr, end);
            threads[i] = new Thread(calculator);
            threads[i].start();
            calcs[i] = calculator;

            ptr = end;
        }

        for (int i = 0; i < this.threads; i++) {
            threads[i].join();
            if (!calcs[i].resultado) {
                return false;
            }
        }

        return true;
    }

}
