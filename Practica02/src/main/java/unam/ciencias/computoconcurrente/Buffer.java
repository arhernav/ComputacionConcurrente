package unam.ciencias.computoconcurrente;

import java.util.concurrent.Semaphore;
/**
 * La clase buffer 
 */
class Buffer {
    private int item; // items en el buffer para prod y cons
    private Semaphore mutex = new Semaphore(1);
    private Semaphore empty = new Semaphore(2); // Tamaño máximo del buffer
    private Semaphore full = new Semaphore(0);

    /**
     * 
     */
    public void producir(int item, int id) {
        try{
            this.empty.acquire();
            this.mutex.acquire();
            System.out.print("Productor: " + id + " produjo. Items: " + this.item + "\n");
            this.item++;
            this.mutex.release();
            this.full.release();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void consumir(int id) {
        try{
            this.full.acquire();
            this.mutex.acquire();
            System.out.print("Consumidor: " + id + " consumió. Items:  " + this.item + "\n");
            this.item--;
            this.mutex.release();
            this.empty.release();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        
        
    }
}
