/*
* Author: SM Khama
* Project description: Creating a game called Conway Game of life
* Cohort : 20 Java
* */

public class Main {


    public static void main(String[] args) {
        GoL cell = new GoL();
        int vertical = 10;
        int horizontal = 10;
        int grid[][] = new int[vertical][horizontal];

        cell.Game();
        cell.nextGen(grid,vertical,horizontal);
    }

}
