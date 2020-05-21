package GameOfLife;
public class GameCoordinator {

    private static Cell[][] copy;
    public static Cell[][] nextGeneration(Cell[][] cells) {
        copy = CellCopyMachine.copy2DcellArray(cells);
        iterateColumns(cells);
        return copy;
    }

    private static void iterateColumns(Cell[][] cells) {
        for (int currentColumn = 0; currentColumn < cells.length; currentColumn++) {
            iterateRows(currentColumn, cells);
        }
    }

    private static void iterateRows( int currentColumn, Cell[][] gameBoard) {
        for (int currentRow = 0; currentRow < gameBoard[currentColumn].length; currentRow++) {
            copy[currentColumn][currentRow] = new Cell(checkSurroundingCells(currentColumn, currentRow, gameBoard));
        }
    }

    private static CellState checkSurroundingCells(int x, int y, Cell[][] cells) {
        int livingNeighbours = 0;
        livingNeighbours += cells[x(x + 1, cells)][y(y + 1, cells)].isAlive() ? 1 : 0;
        livingNeighbours += cells[x(x + 1, cells)][y(y, cells)].isAlive() ? 1 : 0;
        livingNeighbours += cells[x(x + 1, cells)][y(y - 1, cells)].isAlive() ? 1 : 0;
        livingNeighbours += cells[x(x, cells)][y(y + 1, cells)].isAlive() ? 1 : 0;
        livingNeighbours += cells[x(x, cells)][y(y - 1, cells)].isAlive() ? 1 : 0;
        livingNeighbours += cells[x(x - 1, cells)][y(y + 1, cells)].isAlive() ? 1 : 0;
        livingNeighbours += cells[x(x - 1, cells)][y(y, cells)].isAlive() ? 1 : 0;
        livingNeighbours += cells[x(x - 1, cells)][y(y - 1, cells)].isAlive() ? 1 : 0;
        if (cells[x][y].isAlive()) return aliveChecks(livingNeighbours);
        return deadChecks(livingNeighbours);
    }

    private static CellState aliveChecks(int livingNeighbours) {
        return livingNeighbours >= 2 && livingNeighbours <= 3 ? CellState.ALIVE : CellState.DEAD;
    }

    private static CellState deadChecks(int livingNeighbours) {
        return livingNeighbours == 3 ? CellState.ALIVE : CellState.DEAD;
    }

    private static int y(int y, Cell[][] cells) {
        return (y + cells[0].length) % cells[0].length;
    }

    private static int x(int x, Cell[][] cells) {
        return (x + cells.length) % cells.length;
    }
}