package Backtrack;

import java.util.ArrayList;

public class Maze {
    //only 'Down' and 'Right'
    static int countPath(int row,int column){
        if(row==1 || column==1){
            return 1;
        }
        int left = countPath(row -1,column);
        int right = countPath(row,column-1);
        return left+right;
    }
    public static void main(String[] args) {
//        System.out.println(countPath(3,3));
//        System.out.println(pathList(3,3,""));

//        System.out.println(pathList(3,3,""));
        boolean [][]matrix = {
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        System.out.println(path(matrix,0,0,""));
    }
    static ArrayList<String> pathList(int r,int c,String path){
        if(r==1 && c ==1){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(path);
            return temp;
        }
        if(r>1 && c>1) {
            ArrayList<String> left = pathList(r - 1, c, path + "D");
            ArrayList<String> right = pathList(r, c - 1, path + "R");
            left.addAll(right);
            return left;
        }
        else if(c>1){
            return pathList(r, c - 1, path + "R");
        }
        else{
            return pathList(r - 1, c, path + "D");
        }
    }
    /*true,true,true
      true,false,true
      true,true,true*/

    static ArrayList<String> pathList(boolean[][]maze,int r,int c,String path){
        if(r==2 && c ==2){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(path);
            return temp;
        }
        ArrayList<String> pathAns = new ArrayList<>();
        if(r<2){
            if(maze[r+1][c]) pathAns.addAll(pathList(maze,r+1,c,path+"D"));
        }
        if(c<2){
            if(maze[r][c+1])pathAns.addAll(pathList(maze,r,c+1,path+"R"));
        }
        return pathAns;
    }

    //All Directions
    static ArrayList<String> path(boolean [][]maze,int r,int c,String path){
        if(r==2 && c ==2){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(path);
            return temp;
        }
        ArrayList<String> pathAns = new ArrayList<>();

        maze[r][c] = false;
        if(r<2){
            if(maze[r+1][c]) {

                pathAns.addAll(path(maze,r+1,c,path+"D"));
            }

        }
        if(c<2){
            if(maze[r][c+1])
            {

                pathAns.addAll(path(maze,r,c+1,path+"R"));
            }

        }

        if(r>0){
            if(maze[r-1][c])
            {

                pathAns.addAll(path(maze,r-1,c,path+"U"));
            }
        }
        if(c>0){
            if(maze[r][c-1])
            {

                pathAns.addAll(path(maze,r,c-1,path+"L"));
            }
        }
        maze[r][c] = true;
        return pathAns;
    }
}
