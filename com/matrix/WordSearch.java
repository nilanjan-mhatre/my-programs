package com.matrix;

import java.util.Arrays;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        System.out.println(new WordSearchSolution().exist(board, word));
    }

}

class WordSearchSolution {
    public boolean exist(char[][] board, String word) {
        int i, j;
        int rowNumber = board.length;
        int colNumber = board[0].length;
        boolean found = false;
        char[][] boardTemp = null;

        for(i=0; i<rowNumber; i++) {
            for(j=0; j<colNumber; j++) {
                boardTemp = getArrayCopy(board);
                found = traverseWord(boardTemp, word, i, j, 0);
                if(found) {
                    break;
                }
            }
            if(found) {
                break;
            }
        }
        return found;
    }

    public char[][] getArrayCopy(char[][] board) {
        char[][] boardTemp = new char[board.length][];
        int i;
        for(i=0; i<board.length; i++) {
            boardTemp[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return boardTemp;
    }

    public boolean traverseWord(char[][] board, String word, int i, int j, int pos) {
        boolean found = false;
        if(pos < word.length() && word.charAt(pos) == board[i][j]) {
            board[i][j] = 0;
            int rowNumber = board.length;
            int colNumber = board[0].length;

            for(int x=0; x<board.length; x++) {
                for(int y=0; y<board[x].length; y++) {
                    System.out.print(board[x][y] + " ");
                }
                System.out.println();
            }
            System.out.println();

            if(i < rowNumber - 1) {
                found = traverseWord(board, word, i+1, j, pos + 1);
            }
            if(!found && i > 0) {
                found = traverseWord(board, word, i-1, j, pos + 1);
            }
            if(!found && j < colNumber - 1) {
                found = traverseWord(board, word, i, j+1, pos + 1);
            }
            if(!found && j > 0) {
                found = traverseWord(board, word, i, j-1, pos + 1);
            }
            if(pos == word.length() - 1) {
                found = true;
            }
        }
        return found;
    }
}