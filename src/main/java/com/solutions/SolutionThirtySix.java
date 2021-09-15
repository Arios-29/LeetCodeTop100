package com.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ChenYu
 * @date 2021/9/15 17:03
 */
public class SolutionThirtySix {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> existed = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    if (existed.contains(board[row][col])) {
                        return false;
                    } else {
                        existed.add(board[row][col]);
                    }
                }
            }
            existed.clear();
        }
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                if (board[row][col] != '.') {
                    if (existed.contains(board[row][col])) {
                        return false;
                    } else {
                        existed.add(board[row][col]);
                    }
                }
            }
            existed.clear();
        }
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int startRow = x * 3;
                int endRow = startRow + 3;
                int startCol = y * 3;
                int endCol = startCol + 3;
                for (int row = startRow; row < endRow; row++) {
                    for (int col = startCol; col < endCol; col++) {
                        if (board[row][col] != '.') {
                            if (existed.contains(board[row][col])) {
                                return false;
                            } else {
                                existed.add(board[row][col]);
                            }
                        }
                    }
                }
                existed.clear();
            }
        }
        return true;
    }
}
