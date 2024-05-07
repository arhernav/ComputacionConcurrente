package unam.ciencias.computoconcurrente;

import java.util.ArrayList;
import java.util.List;

public class Nqueens implements Runnable {
    private int n;
    private int startRow;
    private List<Integer[]> solutions;

    public Nqueens(int n, int startRow) {
        this.n = n;
        this.startRow = startRow;
        this.solutions = new ArrayList<>();
    }

    @Override
    public void run() {
        solveNQueensRecursive(new Integer[n], 0);
    }

    private List<Integer[]> solveNQueensRecursive(Integer[] board, int col) {
        //Aqui va tu codigo
    }

    private boolean isSafe(Integer[] board, int row, int col) {
        //Aqui va tu codigo
    }

    public String printSolution(Integer[] solution) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (solution[j] == i) {
                    sb.append("Q ");
                } else {
                    sb.append("- ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<Integer[]> getSolutions() {
        return solutions;
    }
}
