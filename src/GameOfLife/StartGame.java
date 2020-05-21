package GameOfLife;

public class StartGame {
    public static void main (String[] args){
        int[] startState = new int[]{6,1, 4,2, 6,2, 4,3, 6,3, 4,4, 2,5, 0,6, 2,6, 7,2};
        int[] glider = new int[]{2,1, 3,2, 1,3, 2,3, 3,3};
        GameBoard gol = new GameBoard(6, 6);
        gol.createGameState(glider);
        gol.generationLeap(20, true);

    }
}
