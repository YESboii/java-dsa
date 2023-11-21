package Backtrack;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    public static void main(String[] args) {
        List<List<String>>board = new ArrayList<>();
        for(int i=0;i<4;i++){
            List<String> row = new ArrayList<>();
            for(int j = 0; j < 4; j++){
                row.add(".");
            }
            board.add(row);
        }
        solveNQueens(board,0);
    }
    public static void solveNQueens(List<List<String>>board,int row) {
        if(row==board.size()){
            for(List<String> l : board){
                System.out.println(l);
            }
            System.out.println("-------------------------------------------------------");
            return;
        }
        for(int i=0;i<board.get(0).size();i++){
            if(canPlace(row-1,i,board)) {
                board.get(row).set(i, "Q");
                solveNQueens(board,row+1);
                board.get(row).set(i,".");
            }
        }
    }

    private static boolean canPlace(int row,int col,List<List<String>>board) {
        int r = row,c = col;
        while(row>=0){
            if(board.get(row).get(col)=="Q") return false;
            row--;
        }
        row = r;
        col = col-1;
        while(row>=0 && col>=0){
            if(board.get(row).get(col)=="Q") return false;
            row--;
            col--;
        }
        row = r;
        col= c;
        col = col+1;
        while(row>=0 && col<board.get(0).size()){
            if(board.get(row).get(col)=="Q") return false;
            row--;
            col++;
        }
        return true;
    }
}
