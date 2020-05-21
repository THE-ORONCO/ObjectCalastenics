package GameOfLife;

public class GOLprinter {
    public static void print1Darray(Object[] array){
        for(Object o: array){
            System.out.print("|"+o);
        }
        System.out.println("|");
    }
    public static void print2Darray(Object[][] array){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%3d: ", i);
            print1Darray(verticalSlice(array, i));
        }
        System.out.println();
    }

    private static Object[] verticalSlice(Object[][] array, int x) {
        Object[] temp = new Object[array[x].length];
        for (int i = 0; i < array[x].length; i++) {
            temp[i]= array[i][x];
        }
        return temp;
    }
}
