import java.awt.*;
import javax.swing.ImageIcon;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker = TicTacToe.BLANK;
    private int row;
    private int col;
    private boolean isWinningSquare;
    public static final int SIZE = 150;
    private Image xImage;
    private Image oImage;
    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        xImage = new ImageIcon("Resources/X.png").getImage();
        oImage = new ImageIcon("Resources/O.png").getImage();
        this.isWinningSquare = false;
    }

    public void draw(Graphics g, int x, int y, TicTacToeViewer viewer) {
        g.setColor(Color.BLACK);
        g.drawRect(x, y, SIZE, SIZE);
        if (marker.equals(TicTacToe.X_MARKER)) {
            g.drawImage(xImage, x, y, SIZE, SIZE, viewer);
        } else if (marker.equals(TicTacToe.O_MARKER)) {
            g.drawImage(oImage, x, y, SIZE, SIZE, viewer);
        }
    }
    public void win(Graphics g, int x, int y, TicTacToeViewer viewer){
        g.setFont(new Font("Serif", Font.BOLD, 40));
        g.drawString(viewer.game.getWinner() + " Won!", 300, 650);
        if (this.isWinningSquare)
        {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, SIZE, SIZE);
        }
        this.draw(g, x, y, viewer);
    }
    /******************** Getters and Setters ********************/
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}
