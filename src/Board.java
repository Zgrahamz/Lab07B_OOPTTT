import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Board {

    JButton[][] board = new JButton[ROW][COL];

    private static final int ROW = 3;
    private static final int COL = 3;

    public Board() {}

    //A single event listener corresponds to all buttons in the array
    public JButton[][] boardSetup() {
        JButton[][] instBoard = new JButton[ROW][COL];
        board = instBoard;
        return instBoard;
    }

    public JButton[][] clearBoard() {
        JButton[][] instClearedBoard = new JButton[ROW][COL];
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                board[r][c].setText(" ");
                board[r][c].setFont(new Font("Times New Roman", Font.PLAIN, 36));
                board[r][c].addActionListener((ActionListener) this);
                board[r][c].setEnabled(true);
            }
        }
        board = instClearedBoard;
        return instClearedBoard;
    }

    public JButton[][] getBoard() {
        return board;
    }

    public void setBoard(JButton[][] board) {
        this.board = board;
    }

}