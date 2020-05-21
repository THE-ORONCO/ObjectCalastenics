package GameOfLife;

public class Cell {
    private CellState cellState;

    public Cell(){
        this(CellState.DEAD);
    }

    public Cell(CellState cellState){
        this.cellState = cellState;
    }

    public boolean isAlive(){
        return cellState.equals(CellState.ALIVE);
    }

    @Override
    public String toString(){
        if(cellState.equals(CellState.ALIVE)){
            return "x";
        }
        return " ";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
