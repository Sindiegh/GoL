public class GoL {

    public static void main(String[] args){


    int horizontal = 10, vertical = 10;

    // Initializing the grid.
    int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };


    // this next line displays the grid
        System.out.println("Input");
        for(int x = 0;x<horizontal;x++) {
        for (int y = 0; y < vertical; y++) {
            if (grid[x][y] == 0) {
                System.out.print("+");
            }
            else {
                System.out.print("#");
            }
        }
        System.out.println();
    }
        nextGen(grid,vertical,horizontal);
        System.out.println();
}
    // this nextGen function prints out the next generation
    static void nextGen(int grid[][], int vertical, int horizontal) {
        // The next board
        int[][] next = new int[vertical][horizontal];
        //[full] Looping but skipping the edge cells
        for (int x = 1; x < vertical-1; x++) {
            for (int y = 1; y < horizontal-1; y++) {
                // Add up all the neighbor states to
                // calculate the number of live neighbors.
                int neighbors = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        neighbors += grid[x+i][y+j];
                // Correct by subtracting the cell state itself.
                neighbors -= grid[x][y];
                //[full] <b>The rules of life!</b>
                if ((grid[x][y] == 1) && (neighbors <  2)) next[x][y] = 0;
                else if ((grid[x][y] == 1) && (neighbors == 2 || neighbors == 3 )) next[x][y] = 1;
                else if ((grid[x][y] == 1) && (neighbors >  3)) next[x][y] = 0;
                else if ((grid[x][y] == 0) && (neighbors == 3)) next[x][y] = 1;
                else next[x][y] = grid[x][y];
            }
        }
        //[end]
        // The 2D array “next” is now the current board.
        System.out.println("\n"+" nextGeneration ");
        for(int i = 0; i <vertical;i++) {
            for (int j = 0; j < horizontal; j++) {
                if (next[i][j] == 0){
                    System.out.print("+");
                }
                else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}


