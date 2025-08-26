import java.util.Scanner;
class Board{
    char[][] board = new char[3][3];

    public Board(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public void printboard(){
        System.out.println("   0     1     2");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" "+board[i][j]);
                if (j < 2) System.out.print("  | ");
            }
            System.out.println();
            if (i < 2) System.out.println("  ---------------");
        }
    }
}


public class Tic_Tac_Toe {
    public static void main(String[] args) {
        Board game = new Board();
        boolean gameover = false;
        char player = 'X';
        Scanner sc = new Scanner(System.in);

        System.out.println("This is a 2 player game. How many games do you what to play.");
        int times = sc.nextInt();
        int n = 1;
        while (times >= n) {
            System.out.println("Game "+n);
            while (!gameover) {
                game.printboard();
                System.out.print("Player " + player + ", enter your move(row and col) \t");
                int row = sc.nextInt();
                int col = sc.nextInt();

                if (game.board[row][col] == ' ') {
                    game.board[row][col] = player;
                    gameover = haswon(game.board, player);
                    if (gameover) {
                        System.out.println("Player " + player + " has Won Game "+n);
                    } else if(isfull(game.board)){
                        System.out.println("This Game is a Draw!");
                        break;
                    }else{
                        player = (player == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move! Please enter a empty space.");
                }
            }
            game.printboard();
            n++;
        }
    }

    private static boolean isfull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean haswon(char[][] board, char player) {
        // CHECKS ROWS
        for (int i=0; i<board.length; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // CHECKS COLUMNS
        for (int j = 0; j < board[0].length; j++) {
            if(board[0][j] == player && board[1][j] == player && board[2][j] == player){
                return true;
            }
        }
        // CHECKS DIAGONAL
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;

        if(board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }
}