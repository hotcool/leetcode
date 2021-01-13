package io.hotcool;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (null == board || 0 == board.length)
            return false;

        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if(isGoodMove(board, word, 0, i, j, used))
                    return true;
            }
        }

        return false;
    }

    private boolean isGoodMove(char[][] board, String word, int index, int i, int j, boolean[][] used) {
        //find the whole word, success
        if (index == word.length())
            return true;
        //board conditions
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j])
            return false;

        if (board[i][j] == word.charAt(index)) {
            used[i][j] = true;
            //search around
            if (isGoodMove(board, word, index + 1, i, j + 1, used) ||
                    isGoodMove(board, word, index + 1, i, j - 1, used) ||
                    isGoodMove(board, word, index + 1, i + 1, j, used) ||
                    isGoodMove(board, word, index + 1, i - 1, j, used)) {
                return true;
            }
            //reset boolean map
            used[i][j] = false;
        }
        return false;
    }
}
