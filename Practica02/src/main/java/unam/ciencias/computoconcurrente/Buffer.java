package unam.ciencias.computoconcurrente;

import java.util.concurrent.Semaphore;

class Buffer {
    private int item;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore empty = new Semaphore(2); // Tamaño máximo del buffer
    private Semaphore full = new Semaphore(0);

    public void producir(int item, int id) {
        //Aqui va tu codigo
    }

    public void consumir(int id) {
        //Aqui va tu codigo
    }
}
