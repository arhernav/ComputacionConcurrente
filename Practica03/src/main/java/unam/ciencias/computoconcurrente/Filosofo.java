package unam.ciencias.computoconcurrente;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Cada filósofo se ejecuta en un hilo.
 */
public class Filosofo implements Runnable {

    private int id;
    private Semaphore palilloIzquierdo, palilloDerecho;
    private boolean haComido;

    public Filosofo(int id, Semaphore palilloIzquierdo, Semaphore palilloDerecho) {
        this.id = id;
        this.palilloIzquierdo = palilloIzquierdo;
        this.palilloDerecho = palilloDerecho;
        this.haComido = false;
    }

    public void run() {
        while(!haComido){
            //Cada filosofo piensa por un tiempo aleatorio
            try{
                pensar();
            }catch(InterruptedException e){
                e.printStackTrace(System.out);
            }
            //Todos los filosofos menos uno son diestros
            if(id != 0){
                //Intenta tomar palillo izquierdo
                try{
                    palilloIzquierdo.acquire();
                }catch(Exception e) {
                    e.printStackTrace(System.out);
                }
                System.out.println("Filosofo  " + (id+1) + " levanta el palillo izquierdo.");
                //Intenta tomar palillo derecho
                try{
                    palilloDerecho.acquire();
                }catch(Exception e) {
                    e.printStackTrace(System.out);
                }
                System.out.println("Filosofo  " + (id+1) + " levanta el palillo derecho.");
            }else{
                //Intenta tomar palillo derecho
                try{
                    palilloDerecho.acquire();
                }catch(Exception e) {
                    e.printStackTrace(System.out);
                }
                System.out.println("Filosofo  " + (id+1) + " levanta el palillo derecho.");
                //Intenta tomar palillo izquierdo
                try{
                    palilloIzquierdo.acquire();
                }catch(Exception e) {
                    e.printStackTrace(System.out);
                }
                System.out.println("Filosofo  " + (id+1) + " levanta el palillo izquierdo.");
            }
            //Intentan comer
            try{
                comer();
            }catch(InterruptedException e){
                e.printStackTrace(System.out);
            }
            //Dejan ambos palillos
            palilloIzquierdo.release();
            System.out.println("Filosofo  " + (id+1) + " deja el palillo izquierdo.");
            palilloDerecho.release();
            System.out.println("Filosofo  " + (id+1) + " deja el palillo derecho.");
        }
    }

    private void pensar() throws InterruptedException {
        try{
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);  
            System.out.println("Filosofo " + (id + 1) + " piensa por " + sleepTime +"ms");
            Thread.sleep(sleepTime);  
        }catch (Exception e){  
            e.printStackTrace(System.out);  
        }
    }

    private void comer() throws InterruptedException {
        try{
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);  
            System.out.println("Filosofo " + (id + 1) + " ha entrado su zona critica");
            System.out.println("Filosofo " + (id + 1) + " come por " + sleepTime +"ms");
            Thread.sleep(sleepTime);  
            haComido = true;
        }catch (Exception e){  
            e.printStackTrace(System.out);  
        }
    }

    public boolean haComido() {
        return haComido;
    }

}
