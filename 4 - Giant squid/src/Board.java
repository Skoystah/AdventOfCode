public class Board {

    int[][] board;
    boolean hasWon;


    public Board(int[][] board) {
        this.board = board;
        hasWon = false;
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean isHasWon() {
        return hasWon;
    }

    public boolean checkHasWon(int draw) {
        if (isOnBoard(draw) && (hasFullRow() || hasFullColumn())) {
            hasWon = true;
            return true;
        }
        return false;
    }

    public int boardValue() {
        int value = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.board[i][j] != 99999) {
                    value += this.board[i][j];
                }
            }
        }

        return value;
    }

    private boolean isOnBoard(int draw) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.board[i][j] == draw) {
                    this.board[i][j] = 99999;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasFullRow() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.board[i][j] != 99999) {
                    break;
                }
                if (j == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasFullColumn() {
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                if (this.board[i][j] != 99999) {
                    break;
                }
                if (i == 4) {
                    return true;
                }
            }
        }
        return false;
    }


}
