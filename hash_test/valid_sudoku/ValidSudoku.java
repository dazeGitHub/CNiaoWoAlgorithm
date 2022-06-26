package hash_test.valid_sudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board){
        if(board == null || board.length == 0){
            return false;
        }
        Set[] horizontal = new HashSet[9]; //9 行
        Set[] vertical = new HashSet[9];   //9 列
        Set[][] area = new HashSet[3][3];  //3 x 3 的区域

        for(int i = 0; i < 9; ++i){
            horizontal[i] = new HashSet<>();
            vertical[i] = new HashSet<>();
        }
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                area[i][j] = new HashSet<>();
            }
        }

        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                char val = board[i][j];
                if(val == '.'){
                    continue;
                }
                if(horizontal[i].contains(val)){
                    return false;
                }else{
                    horizontal[i].add(val);
                }
                if(vertical[j].contains(val)){
                    return false;
                }else{
                    vertical[j].add(val);
                }
                if(area[i / 3][j / 3].contains(val)){
                    return false;
                }else{
                    area[i / 3][j / 3].add(val);
                }
            }
        }
        return true;
    }
    
    public void test() {
        char[][] board = new char[9][9];
        board[0] = new char[]{'5','3','.','.','7','.','.','.','.'};
        board[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        board[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        board[3] = new char[]{'8', '.','.','.','6','.','.','.','3'};
        board[4] = new char[]{'4', '.','.','8','.','3', '.','.','1'};
        board[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        board[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        board[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        board[8] = new char[]{'.','.','.','.','8','.','.','7','9'};
        System.out.println(isValidSudoku(board)); //true
    }

    public static void main(String[] args){
        ValidSudoku obj = new ValidSudoku();
        obj.test();
    }
}
