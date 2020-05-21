package GameOfLife;

public enum CellState {
    ALIVE("X"),
    DEAD(" ");

    private String representationSymbol;
    CellState(String x) {
        representationSymbol = x;
    }

    @Override
    public String toString() {
        return "Cellstate = \"" + representationSymbol + "\"";
    }
}
