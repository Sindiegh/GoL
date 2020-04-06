public class GoL {

     void Game(){


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
        System.out.println();
}
    // this nextGen function prints out the next generation
    static void nextGen(int grid[][], int vertical, int horizontal) {
        int neighboursAlive = 0;
        int[][] futureGen = new int[vertical][horizontal];

        //iterating  throughout the cells
        for (int x = 1; x < vertical - 1; x++) {
            for (int y = 1; y < horizontal - 1; y++) {

                // find the number of neighbours that are alive.
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        neighboursAlive += grid[x + i][y + j];
                        neighboursAlive -= grid[x][y];
                    }
                }

                // Implementing the rules

                // Cell with fewer than two live neighbours dies
                if ((neighboursAlive < 2)) {
                    futureGen[x][y] = 0;
                }

                    // Cell with 2 or 3 live neighbors lives on to the next generation
                else if ((grid[x][y] == 1) && (neighboursAlive ==2 || neighboursAlive ==3)){

                    futureGen[x][y] = grid[x][y];
                }

                // live cell with more than three live neighbors dies
                else if ((grid[x][y] == 1) && (neighboursAlive > 3)){
                    futureGen[x][y] = 0;
                }

                    // any dead cell with exactly three live neighbors becomes a live cell
                else if ((grid[x][y] == 0) && (neighboursAlive == 3)) {
                    futureGen[x][y] = 1;
                }

                    // cells remains the same.
                else {
                    futureGen[x][y] = grid[x][y];
                }
            }
        }
        // the next line displays the next generation
        System.out.println("Next Generation");
        for (int i = 0; i < vertical; i++) {
            for (int j = 0; j < horizontal; j++) {
                if (futureGen[i][j] == 0) {
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


