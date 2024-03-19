package unam.ciencias.computoconcurrente;

import java.util.concurrent.Semaphore;

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
        while(true){
        if(haComido()){
            pensar();
        }
            comer();
        }   
    }

      private void comer() throws InterruptedException {
        if(palilloIzquierdo.tryAcquire()){
            if(palilloDerecho.tryAcquire()){
            System.out.println("El fílosofo"+ id + "está comiendo");
            try{
                int tiempo = 0;
                while(tiempo<= 0){
                    tiempo = new Random.nextInt()%2000;
                    sleep(tiempo);
                }
            }
                catch (InterruptedException er){
                    System.out.println("Error en comer " + er.toString());
                }

                System.out.println("El filoso"+ id + " termino de comer y libero los palillos.");
                palilloDerecho.release();
             }
             palilloIzquierdo.release();
            
            }else{
                System.out.println("El filoso"+id+ "está hambriento." );
            }
        }


    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        try{
            int time=0;
            while(time<=0)
                time=new Random().nextInt()%2000;
            sleep(time);
        }catch(InterruptedException er){
            System.out.println("Error en pensar " + er.toString());
        }
    }


    public boolean haComido() {
        return haComido;
    }
}
