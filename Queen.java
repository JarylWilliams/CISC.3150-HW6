/*
 * CISC.3150 HW6 
 * N Queens problem
 */

/**
 *
 * @author Jaryl
 */


import java.util.*;

//https://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
//https://discuss.leetcode.com/category/883/n-queens
//https://www.youtube.com/watch?v=jJPtLzq1E-Y


final class Board{
    private final int[][] coords;
    private int solutions = 0;
    private final int max;

         //Constructor
        Board(int num)
        {
            coords = new int[num][num];
            max = num;
            setBoard();
        }

        //Clears Board
          void  setBoard(){
            for (int x = 0; x < max; x++) {
             for (int y = 0; y < max; y++) {
                coords[x][y] = 0;
                    }
                }
             }

           //Setter for Queen
         void setQueen(int row, int col)
         {
         coords[row][col] = 1;
         }
    
        void setCell(int row, int col)
        {
            coords[row][col] = 0;
        }
        //Getter for coordinates
        int getCoord(int row, int col)
        {
            return coords[row][col];
        }
        //Getter for solutions
       int getSolutions()
        {
            return solutions;
        }

        //Prints board
        void printBoard()
         {
            for (int x = 0; x < max; x++) {
            for (int y = 0; y < max; y++) {
                System.out.printf("%2d",coords[x][y]);
            }
            System.out.println();
        }
        }

        // Checks to see if it's safe
         boolean checkDanger(int row, int col)
        {
            return  checkRow(row) && checkColumn(col) && checkLeft(row, col);
                
        }

         // Checks row for danger 
        boolean checkRow(int row)
        {
        for (int x = 0; x<max; x++){
            if (coords[row][x] == 1){
                return false;
            }
        }
        return true;
        }

    // Checks column for danger
    boolean checkColumn(int col)
    {
        for (int y = 0; y<max; y++){
            if (coords[y][col] == 1){
                return false;
            }
        }
        return true;
    }
    
    // Checking to see if there is danger on the left.
    boolean checkLeft(int row, int col)
    {
        int x, y;
        for (x = row, y = col; x >= 0 && y >= 0; x-- , y--) {
            if (getCoord(x, y) == 1){
                return false;
            }
        }
        for (x = row, y = col ; x < max && y >= 0; x++ , y--) {
            if (getCoord(x, y) == 1){
                return false;
            }
        }
        return true;
    }

    // Solving recursively with backtrack.
    boolean solve(int col)
    {
        if (col >= max)
        {
            return true;
        }
        for (int i=0;i<max;i++){
            if (checkDanger(i, col)){
                setQueen(i,col);
                if (solve(col+1)){
                    solutions++;
                    System.out.println("Solution: "+getSolutions());
                    printBoard();
                 }
                    setCell(i, col);
               }
            }
            return false;
        }
    }




public class Queen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1;

        System.out.println("Please enter the number of Queens: "); //User input for number of Queens
            num1 = Integer.parseInt(input.next());

            Board gameBoard = new Board(num1);
            gameBoard.solve(0); //Gives possible solutions

        System.out.println("The number of possible solutions are:"+gameBoard.getSolutions()); 
     
    }
}