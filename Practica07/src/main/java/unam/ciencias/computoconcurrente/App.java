package unam.ciencias.computoconcurrente;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        int n = 9;
        List<Nqueens> nqueensTasks = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            Nqueens nqueens = new Nqueens(n, row);
            nqueensTasks.add(nqueens);
            new Thread(nqueens).start();
        }

        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().startsWith("Thread-")) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        int totalSolutions = 0;
        for (Nqueens nqueens : nqueensTasks) {
            totalSolutions += nqueens.getSolutions().size();
            for (Integer[] solution : nqueens.getSolutions()) {
                System.out.println(nqueens.printSolution(solution));
            }
        }
        System.out.println("Numero de soluciones: " + totalSolutions);
    }
}

/*

Ejemplo de ejecución

$ java -jar target/practica07-1.0.jar

Q - - - - - - - - 
- - - - Q - - - - 
- Q - - - - - - - 
- - - - - Q - - - 
- - - - - - - - Q 
- - Q - - - - - - 
- - - - - - - Q - 
- - - Q - - - - - 
- - - - - - Q - - 

Q - - - - - - - - 
- - - Q - - - - - 
- Q - - - - - - - 
- - - - - - - Q - 
- - - - - Q - - - 
- - - - - - - - Q 
- - Q - - - - - - 
- - - - Q - - - - 
- - - - - - Q - - 

Q - - - - - - - - 
- - - - - Q - - - 
- Q - - - - - - - 
- - - - - - - - Q 
- - - - - - Q - - 
- - - Q - - - - - 
- - - - - - - Q - 
- - Q - - - - - - 
- - - - Q - - - - 

Q - - - - - - - - 
- - Q - - - - - - 
- - - - - - Q - - 
- Q - - - - - - - 
- - - - - - - Q - 
- - - - Q - - - - 
- - - - - - - - Q 
- - - Q - - - - - 
- - - - - Q - - - 

.
.
.
.

Numero de soluciones: ___

*/