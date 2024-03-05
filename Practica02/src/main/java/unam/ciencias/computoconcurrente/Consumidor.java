package unam.ciencias.computoconcurrente;

class Consumidor implements Runnable {
    private Buffer buffer;
    private static int idCounter = 0;
    private int id;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
        this.id = idCounter++;
    }

    /**
     * Consume un elemento del buffer
     */
    public void run() {
        while(true){
            this.buffer.consumir(this.id);
        }
    }
}
