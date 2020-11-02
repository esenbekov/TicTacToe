/**
 * created by eseisl on 28.10.2020
 */

public class Board {

    /**
     * An integer Array to keep track of slots.
     */
    private char[] slots = new char[9];


    /**
     * An integer to keep track of the wins of each player.
     */
    private int[] playerWins = new int[2];


    private int emptySlots;


    private int game;

    /**
     * Constructor.
     */
    Board() {
        clearBoard();
        this.game = 0;
        this.emptySlots = 9;
    }

    /**
     * Clear the board by placing hyphens.
     *
     * @return void.
     */
    public void clearBoard() {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = '-';
        }


    }

    public char[] getBoard() {
        return this.slots;

    }

    public void displayBoard() {
        System.out.println(" " + slots[0] + " | " + slots[1] + " | " + slots[2]);
        System.out.println("-----------");
        System.out.println(" " + slots[3] + " | " + slots[4] + " | " + slots[5]);
        System.out.println("-----------");
        System.out.println(" " + slots[6] + " | " + slots[7] + " | " + slots[8]);
        System.out.println();
    }

    public void displayHelp() {

        System.out.println(" " + 0 + " | " + 1 + " | " + 2);
        System.out.println("-----------");
        System.out.println(" " + 3 + " | " + 4 + " | " + 5);
        System.out.println("-----------");
        System.out.println(" " + 6 + " | " + 7 + " | " + 8);
        System.out.println();

    }

    public void displayStatus() {
        System.out.println("Game:" + this.game + "\t" + "Player1 wins: " + playerWins[0] + "  " + "Player2 wins: " + playerWins[1]);
    }

    public void updateBoard(int player, int position) {
        if (position < 0 || position > 8) {
            throw new IllegalArgumentException("Invalid position");
        }

        char letter = 'X';

        if (player == 2) {
            letter = 'O';
        }
        slots[position] = letter;
    }

    public int[] getScores() {
        return this.playerWins;
    }

    public void updateWins(int player) {
        if (player > 1 || player < 0) {
            throw new IllegalArgumentException("Invalid player");
        }
        playerWins[player] += 1;
    }

    public char getSlot(int position) {
        return slots[position];
    }

    public void updateGame() {
        this.game++;
    }


    public int getEmptySlots() {
        return emptySlots;
    }


    public void subStractNumberOfSlots() {
        this.emptySlots -= 1;
    }


    // all 3 checks below

    public boolean rowWinCheck(String row) {
        char target;
        int start;
        int end;

        if ("one".equals(row)) {
            target = slots[3];
            start = 4;
            end = 5;

        } else if ("two".equals(row)) {
            target = slots[6];
            start = 7;
            end = 8;

        } else {
            target = slots[0];
            start = 1;
            end = 2;
        }

        for (int i = start; i <= end; i++) {
            if (slots[i] != target) {
                return false;
            }
        }

        return true;
    }

    public boolean columnWinCheck(String column) {
        char target;
        int start;
        int end;

        if ("one".equals(column)) {
            target = slots[1];
            start = 4;
            end = 7;

        } else if ("two".equals(column)) {
            target = slots[2];
            start = 5;
            end = 8;

        } else {
            target = slots[0]; // assume column zero
            start = 3;
            end = 6;
        }

        for (int i = start; i <= end; i = i + 3) {
            if (slots[i] != target) {
                return false;
            }
        }

        return true;
    }

    public boolean diagonalWinCheck(String direction) {

        char target;
        int start;
        int end;
        int increament = 1;

        if ("left".equals(direction)) {
            target = slots[0];
            start = 4;
            end = 8;
            increament = 4;

        } else {
            target = slots[2]; // assume column zero
            start = 4;
            end = 6;
            increament = 2;

        }

        for (int i = start; i <= end; i = i + increament) {
            if (slots[i] != target) {
                return false;
            }
        }

        return true;

    }

}
