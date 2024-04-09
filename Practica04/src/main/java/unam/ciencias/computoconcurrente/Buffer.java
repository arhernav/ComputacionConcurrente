package unam.ciencias.computoconcurrente;

class Buffer {

    private int item;
    private int capacidad = 2; //Tamaño máximo del buffer
    private int count = 0;

    public synchronized void producir(int item, int id) {
        while (count == capacidad) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Productor " + id + " produjo " + this.count);
        this.count++;
        this.item++;
        notify();
        
    }

    public synchronized void consumir(int id) {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumidor " + id + " consumió: " + this.count);
        this.count--;
        this.item--;
        notify();
    }

}
