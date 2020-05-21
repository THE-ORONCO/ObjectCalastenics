package GameOfLife;

public class CellCopyMachine {
    public static Cell[][] copy2DcellArray(Cell[][] cells) {
        Cell[][] copy = new Cell[cells.length][];
        for (int i = 0; i < cells.length; i++) {
            copy[i] = copy1DcellArray(cells[i]);
        }
        return copy;
    }

    public static Cell[] copy1DcellArray(Cell[] cells) {
        Cell[] copy = new Cell[cells.length];
        for (int i = 0; i < cells.length; i++) {
            copy[i] = new Cell(cells[i].isAlive()?CellState.ALIVE:CellState.DEAD);
        }
        return copy;
    }

}
