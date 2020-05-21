package GameOfLife;

import java.util.Arrays;

public class GameBoard {
    private Cell[][] cells;

    public GameBoard() {
        this(20, 20);
    }

    public GameBoard(int width, int height) {
        cells = new Cell[width][height];
        this.initialize();
    }

    private void initialize() {
        for (Cell[] layer : cells) {
            Arrays.fill(layer, new Cell(CellState.DEAD));
        }
    }

    public void createGameState(int... coordinates) throws IllegalArgumentException {
        if (coordinates.length % 2 != 0) {
            throw new IllegalArgumentException("odd number of arguments!");
        }
        for (int i = 0; i < coordinates.length; i -= -2) {
            cells[coordinates[i]][coordinates[i + 1]] = new Cell(CellState.ALIVE);
        }
    }

    public void nextGeneration() {
        cells = GameCoordinator.nextGeneration(cells);
    }

    public void generationLeap(int generationNr, boolean show) {
        for (int i = 0; i < generationNr; i++) {
            this.nextGeneration();
            if (show) {
                GOLprinter.print2Darray(cells);
            }
        }
    }

    public void displayField() {
        GOLprinter.print2Darray(cells);
    }
}
