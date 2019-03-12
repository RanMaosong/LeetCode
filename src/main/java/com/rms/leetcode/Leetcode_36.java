package com.rms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode_36 {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> diags = new HashMap<>();
        for (int i=0; i < board.length; ++i) {
            Set<Character> row= new HashSet<>();
            for (int j=0; j < board[0].length; ++j) {
                if (board[i][j] != '.') {
                    System.out.println(board[i][j]);
                    if (row.contains(board[i][j])) {
                        System.out.println(i + " " + j + "  " + row + "row");
                        return false;
                    }
                    else {
                        row.add(board[i][j]);
                    }

                    Set<Character> col = cols.getOrDefault(j, new HashSet<Character>());
                    if (col.contains(board[i][j])){
                        System.out.println(i + " " + j + " " + col + "col");
                        return false;
                    }
                    else {
                        col.add(board[i][j]);
                        cols.put(j, col);
                    }

                    if (i == j) {
                        Set<Character> diag = diags.getOrDefault(0, new HashSet<Character>());
                        if (diag.contains(board[i][j])){
                            System.out.println(i + " " + j +" " + diag + board[i][j] + " 0");
                            return false;
                        }
                        else {
                            diag.add(board[i][j]);
                            diags.put(0, diag);
                        }
                    }
                    int m = board[0].length - 1;
                    if (i == (m - j)) {
                        Set<Character> diag = diags.getOrDefault(1, new HashSet<Character>());
                        if (diag.contains(board[m-i][j])){
                            System.out.println(i + " " + j + " " + diag  + "1");
                            return false;
                        }
                        else {
                            diag.add(board[i][j]);
                            diags.put(1, diag);
                        }

                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
