package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//O(3^(n^2))
//recur stack -> O(n^2)

public class RatInAMaze {

    public static void main(String[] args){
        int[][] maze = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        int [][]path = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
//        List<int[][]> lis = new ArrayList<>();
//            ratInAMaze(lis,maze,0,0);
//        for (int[][]arr:lis){
//            System.out.println(Arrays.deepToString(arr));
//        }
        ratInAMazeII(maze,path,0,0,0);
    }
    public static void ratInAMaze(List<int[][]> list, int[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            maze[r][c] = 1;
            int[][] copy = new int[maze.length][maze[0].length];
            for (int i = 0; i < maze.length; i++) {
                System.arraycopy(maze[i], 0, copy[i], 0, maze[i].length);
            }
            list.add(copy);
//        System.out.println(Arrays.deepToString(maze));
            maze[r][c]=0;
            return;
        }

            maze[r][c] = 1;
        // down
        if (r < maze.length - 1 ) {
            ratInAMaze(list, maze, r + 1, c);
        }

        // right
        if (c < maze[0].length - 1) {
//            maze[r][c] = 1;
            ratInAMaze(list, maze, r, c + 1);
//            maze[r][c] = 0;
        }
            maze[r][c] = 0;
    }

    public static void ratInAMazeII(int[][]maze,int [][]path,int r,int c,int count){
        if(r== maze.length-1 && c==maze.length-1){
            path[r][c] = count;
            for (int[]arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("----------------------------");
            maze[r][c] = 0;
            return;
        }
        maze[r][c] = 1;
        path[r][c] = count;
        //down
        if(r< maze.length-1 && maze[r+1][c]!=1){
            ratInAMazeII(maze,path,r+1,c,count+1);
        }
//        right
        if(c< maze.length-1 && maze[r][c+1]!=1){
            ratInAMazeII(maze,path,r,c+1,count+1);
        }
//        left
        if(c>0 && maze[r][c-1]!=1){
            ratInAMazeII(maze,path,r,c-1,count+1);
        }
//        up
        if(r>0 && maze[r-1][c]!=1){
            ratInAMazeII(maze,path,r-1,c,count+1);
        }
        maze[r][c] = 0;
        path[r][c] = 0 ;
    }

}
