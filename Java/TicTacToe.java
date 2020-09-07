import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    static Scanner in;
    static String[][] board; //game baord
    static String player;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        board = new String[3][3];
        Arrays.stream(board).forEach(a -> Arrays.fill(a, " "));

        // initialise player and player scores
        player = "X";
        int x_count = 0, o_count = 0; 

        String winner = null;        
        while(winner == null){
            // Main game loop
            
            int row, column;
            System.out.printf("Player %s, please enter a row (0, 1 or 2): ", player);
            try {
				row = in.nextInt();
				if (!(row >= 0 && row <= 2)) {
					System.out.println("Invalid input; re-enter slot number:");
					continue;
				}
			} catch (InputMismatchException error) {
				System.out.println("Invalid input; re-enter slot number:");
				continue;
            }
            System.out.printf("Player %s, please enter column (0, 1 or 2): ", player);
            try {
				column = in.nextInt();
				if (!(column >= 0 && column <= 2)) {
					System.out.println("Invalid input; re-enter slot number:");
					continue;
				}
			} catch (InputMismatchException error) {
				System.out.println("Invalid input; re-enter slot number:");
				continue;
            }
            // first check if position is filled 
            if(board[row][column] == " "){
                board[row][column] = player;
                if (player.equals("X")) {
					player = "O";
				} else {
					player = "X";
				}
                printBoard(); 
                winner = winner(x_count,o_count);
            } 
            else {
                System.out.println("Slot already taken; re-enter slot number:");
                continue;
            }
            if (winner == "draw") {
                System.out.println("It's a draw!");
            } else {
                System.out.println("Congratulations! " + winner + "'s have won! \nRe-run the program to play again");
            }

        }
    }

    static String winner(int x_count, int o_count) {
        // check for the winner 
		for (int k = 0; k < 8; k++) {
			String line = null;
			switch (k) {
			case 0:
				line = board[0][0] + board[0][1] + board[0][2];
				break;
			case 1:
                line = board[1][0] + board[1][1] + board[1][2];
				break;
			case 2:
                line = board[2][0] + board[2][1] + board[2][2];
				break;
            case 3:
                line = board[0][0] + board[1][0] + board[2][0];
				break;
			case 4:
                line = board[0][1] + board[1][1] + board[2][1];
				break;
			case 5:
                line = board[0][2] + board[1][2] + board[2][2];
				break;
			case 6:
                line = board[0][0] + board[1][1] + board[2][2];
				break;
			case 7:
            line = board[2][0] + board[1][1] + board[0][2];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
            }
        }
        for(int i=0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == "X"){
                    x_count++;
                }
                else if(board[i][j] == "O") {
                    o_count++;
                }
            }
        }
        if(o_count + x_count > 8){
            return "draw";
        }
        return null;
	}

    static void printBoard() {
        // Display progress 
        // Trickered after every player entry 
		System.out.println("-------------");
        System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
		System.out.println("-------------");
	}
}