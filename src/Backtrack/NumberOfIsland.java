package Backtrack;

public class NumberOfIsland {
    public static int numIslands(char [][]map){
        int count = 0;
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]=='1'){
                    count++;
                    extentOfLand(map,i,j);
                }
            }
        }
        return count;
    }
    public static void extentOfLand(char [][]map,int r,int c){
        if(r>=map.length || c>=map[0].length || r<0 || c<0 || map[r][c]=='0') return;
        map[r][c] = '0';
        //call in all four directions
        int []dir = {1,-1};
        for (int i=0;i<2;i++){
            extentOfLand(map,r+dir[i],c);
            extentOfLand(map,r,c+dir[i]);
        }
    }

    public static void main(String[] args) {
        char[][] charMap = {
                {'1', '1', '0', '0'},
                {'1', '1', '0', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '1'}
        };
        //best case O(n^2)
        System.out.println(numIslands(charMap));
    }
}
