/**Sudoku Assignment
 * author: @BennyFung
 */
import java.util.Random;

public class Sudoku 
{
	private final int[][] board = new int[9][9];
	
	public static void main(String[] args) 
	{
		Sudoku sudoku = new Sudoku();
		sudoku.fill();
		sudoku.printBoard();
	}
	
	public void printBoard() //format of the board
	{
		System.out.println("-------------------------");
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board.length; col++)
			{
				if (col % 3 == 0)
				{
					System.out.print("| ");
				}
				
				System.out.print(board[row][col] + " ");
				
				if (col == 8)
				{
					System.out.print("|\n");
				}
			}	
			
			if (row == 2 || row == 5)
			{
				System.out.println("-------------------------");
			}
		}
		
		System.out.println("-------------------------");
	}
	
	public boolean safeToPlace(int r, int c, int num) //takes input of row, column, and number
	{
		//checks every leading row prior to the position: if the value at the position of the board equals to the inputed number, returns false.
		for (int i = 0; i <= r; i++)
		{
			if (board[i][c] == num)
			{
				return false;
			}
		}
		
		//checks every leading column prior to the position: if the value at the position of the board equals to the inputed number, returns false.
		for (int j = 0; j <= c; j++)
		{
			if (board[r][j] == num)
			{
				return false;
			}
		}
		
		//checks each subgrid; if number appears in subgrid, return false. 
		int row = (r/3) *3;
		int col = (c/3) *3;
		for (int a = row; a < row + 3; a++)
		{
			for (int b = col; b < col + 3; b++)
			{
				if (board[a][b] == num)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void fill() //helper method that calls fillBoard and starts the method at position (0,0)
	{		
		fillBoard(0,0);	
	}
	
	private boolean fillBoard(int row, int col)
	{
		Random random = new Random();
		int number = random.nextInt(9) + 1;
		
		if (row >= board.length) //increments columns and makes row zero if it reaches the boundaries
		{
			col++; 
			row = 0;
		}
		
		if (col >= board.length) //base case for when column exceeds the board length (9)
		{
			return true;
		}
		
		for (int i = 0; i < board.length; i++)
		{
			number = random.nextInt(9)+1; //generates random number each time
			if (safeToPlace(row, col, number))
			{
				board[row][col] = number; //if it passes all the rules of Sudoku, fill the number in that position
				if (fillBoard(row+1, col)) //recursive call that checks the row ahead
				{
					return true;
				}
			}
		}
		board[row][col] = 0; //if all options (1-9) are exhausted and nothing works, makes cell zero, returns false and backtracks
		return false;
	}
}
