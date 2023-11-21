package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeBAsics {
    public static void main(String[] args) {
//        System.out.println(countPaths(0,0);
//        System.out.println(printPaths("",0,0));
        boolean [][]matrix = {
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        int [][]mat = {
                {0,0,0},
                {0,0,0},
                {0,0,0},
        };
//        printPathWithObstacles("",matrix,0,0);
        path(matrix,mat,"",0,0,0);
    }

    static int countPaths(int r,int c){
        //only D R
        //As soon as we reach the last row/column we have only one way
        if(r==2 || c==2){
            return 1;
        }
        int downCount = countPaths(r+1,c);
        int rightCount = countPaths(r,c+1);

        return downCount+ rightCount;
    }
    static List<String> printPaths(String path,int r,int c){
        //only D R
        //As soon as we reach the last row/column we have only one way
        if(r==2 && c==2){
            List<String> temp = new ArrayList<>();
            temp.add(path);
            return temp;
        }
        List<String> paths = new ArrayList<>();
        if(r<2)  paths.addAll(printPaths(path+'D',r+1,c));

        if(c<2)  paths.addAll(printPaths(path+'R',r,c+1));

        return paths;
    }
    static void printPathWithObstacles(String path,boolean [][]matrix,int r,int c){
        if(r==2 && c==2){
            System.out.println(path);
            return;
        }
        if(!matrix[r][c]) return;

        if(r<2) printPathWithObstacles(path+'D',matrix,r+1,c);

        if(c<2) printPathWithObstacles(path+'R',matrix,r,c+1);

    }
    static void path(boolean [][]maze,int [][]pathMat,String path,int r,int c,int count){
        if(r==2 && c==2){
            pathMat[r][c] = count+1;
            System.out.println(path);
            for(int []arr:pathMat){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("-------------------------------------------------------");
            return;
        }

        pathMat[r][c] = count+1;
        maze[r][c] = false;
        //D
        if(r<2 && maze[r+1][c]){
            path(maze,pathMat,path+'D',r+1,c,count+1);
        }
        //R
        if(c<2 && maze[r][c+1]){
            path(maze,pathMat,path+'R',r,c+1,count+1);
        }
        if(r>0 && maze[r-1][c]){
            path(maze,pathMat,path+'U',r-1,c,count+1);
        }
        if(c>0 && maze[r][c-1]){
            path(maze,pathMat,path+'L',r,c-1,count+1);
        }
        maze[r][c] = true;
        pathMat[r][c] = 0;
    }
}
