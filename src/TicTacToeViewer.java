import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;
    private static final String TITLE = "Tic Tac Toe";
    private static final int SIDE_LENGTH = 100;
    private static final int X_BUFFER = 130;
    private static final int Y_BUFFER = 135;
    private static final int AXIS_X = 20;

    private Square[][] board;

    public TicTacToe game;

    public TicTacToeViewer(TicTacToe a) {
        game = a;
        board = a.getBoard();
        this.setTitle(TITLE);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public void paint(Graphics g){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int x = X_BUFFER + col * Square.SIZE;
                int y = Y_BUFFER + row * Square.SIZE;
                board[row][col].draw(g, x, y, this);
            }
        }
        for (int i = 0; i < 3; i++){
            g.drawString("" + i,X_BUFFER + i * Square.SIZE + Square.SIZE / 2, Y_BUFFER - 40);
        }
        for (int i = 0; i < 3; i++){
            g.drawString("" + i, X_BUFFER - 40, Y_BUFFER + i * Square.SIZE + Square.SIZE / 2);
        }
        if (game.checkTie()) {
            g.setFont(new Font("Serif", Font.BOLD, 30));
            g.drawString("It's a Tie!", 350, 650);
            return;
        }
        if (game.getGameOver()) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    int x = X_BUFFER + col * Square.SIZE;
                    int y = Y_BUFFER + row * Square.SIZE;
                    board[row][col].win(g, x, y, this);
                }
            }
        }


    }

}