import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLogic implements ActionListener {
    JButton[][] board = new JButton[3][3];

    int moveCnt = 0;
    final int winMoves = 5;

    private final int ROW = 3;
    private final int COL = 3;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private boolean isValidMove(int row, int col) {
        for (int r = 0; r < ROW; r++) {
            for (int colu = 0; colu < COL; colu++) {
                if (board[row][col].getText().equals("X") || board[row][col].getText().equals("O")) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid move");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin(String player) {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) {
            JOptionPane.showMessageDialog(null, player + "Wins! Press 'play again' to restart.", "Finished1", JOptionPane.ERROR_MESSAGE);
        } else if (isTie()) {
            JOptionPane.showMessageDialog(null, "It's a tie! Press 'play again' to restart.", "Finished2", JOptionPane.ERROR_MESSAGE);
        }
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }

    private boolean isColWin(String player) {
        for(int col=0; col < COL; col++)
        {
            if(board[0][col].getText().equals(player) &&
                    board[1][col].getText().equals(player) &&
                    board[2][col].getText().equals(player))
            {
                return true;
            }
        }
        return false; // no col win
    }
    private boolean isRowWin(String player) {

        for(int row=0; row < ROW; row++) {
            if(board[row][0].getText().equals(player) && board[row][1].getText().equals(player) && board[row][2].getText().equals(player)) {
                return true;
            }
        }
        return false;
    }
    private boolean isDiagonalWin(String player)
    {
        if(board[0][0].getText().equals(player) && board[1][1].getText().equals(player) && board[2][2].getText().equals(player) ) {
            return true;
        }

        return board[0][2].getText().equals(player) && board[1][1].getText().equals(player) && board[2][0].getText().equals(player);
    }

    private boolean isTie() {
        boolean xFlag = false;
        boolean oFlag = false;

        for(int row=0; row < ROW; row++) {
            if(board[row][0].getText().equals("X") || board[row][1].getText().equals("X") || board[row][2].getText().equals("X")) {
                xFlag = true;
            }
            if(board[row][0].getText().equals("O") || board[row][1].getText().equals("O") || board[row][2].getText().equals("O")) {
                oFlag = true;
            }

            if(!(xFlag && oFlag)) {
                return false;
            }

            xFlag = oFlag = false;

        }

        for(int col=0; col < COL; col++) {
            if(board[0][col].getText().equals("X") || board[1][col].getText().equals("X") || board[2][col].getText().equals("X")) {
                xFlag = true;
            }

            if(board[0][col].getText().equals("O") || board[1][col].getText().equals("O") || board[2][col].getText().equals("O")) {
                oFlag = true;
            }

            if(!(xFlag && oFlag)) {
                return false;
            }
        }

        xFlag = oFlag = false;

        if(board[0][0].getText().equals("X") || board[1][1].getText().equals("X") || board[2][2].getText().equals("X") ) {
            xFlag = true;
        }

        if(board[0][0].getText().equals("O") || board[1][1].getText().equals("O") || board[2][2].getText().equals("O") ) {
            oFlag = true;
        }

        if(! (xFlag && oFlag) )
        {
            return false;
        }
        xFlag = oFlag = false;

        if(board[0][2].getText().equals("X") || board[1][1].getText().equals("X") || board[2][0].getText().equals("X") ) {
            xFlag =  true;
        }

        if(board[0][2].getText().equals("O") || board[1][1].getText().equals("O") || board[2][0].getText().equals("O") ) {
            oFlag =  true;
        }

        return xFlag && oFlag;
    }
}
