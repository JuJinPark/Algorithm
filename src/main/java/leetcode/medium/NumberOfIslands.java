package main.java.leetcode.medium;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }

        Land land = new Land(grid);
        return land.findIslands();


    }


}

class Land{
    char[][] grid;
    boolean[][] visited;
    public Land(char[][] grid) {
        this.grid = grid;
        this.visited=new boolean[grid.length][grid[0].length];
    }

    public int findIslands(){
        int numOfIslands=0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               if(isExplorable(i,j)){
                   exploreAdjacentLandFrom(i,j);
                   numOfIslands++;
               }

            }
        }
        return numOfIslands;

    }

    private void exploreAdjacentLandFrom(int i, int j){
        visited[i][j]=true;

        //right
        exploreRightFrom(i,j);
        //left
        exploreLeftFrom(i,j);
        //up
        exploreUpFrom(i,j);
        //down
        exploreDownFrom(i,j);
    }

    private void exploreDownFrom(int i, int j) {
        int nextI=i+1;
        int nextJ=j;

        if(isExplorable(nextI,nextJ)){
            exploreAdjacentLandFrom(nextI,nextJ);
        }
    }

    private void exploreUpFrom(int i, int j) {
        int nextI=i-1;
        int nextJ=j;

        if(isExplorable(nextI,nextJ)){
            exploreAdjacentLandFrom(nextI,nextJ);
        }
    }

    private void exploreLeftFrom(int i, int j) {
        int nextI=i;
        int nextJ=j-1;

        if(isExplorable(nextI,nextJ)){
            exploreAdjacentLandFrom(nextI,nextJ);
        }

    }

    private void exploreRightFrom(int i, int j) {
        int nextI=i;
        int nextJ=j+1;

        if(isExplorable(nextI,nextJ)){
            exploreAdjacentLandFrom(nextI,nextJ);
        }

    }

    private boolean isExplorable(int i,int j){

        if(i<0||j<0){
            return false;
        }
        if(i>=grid.length){
            return false;
        }

        if(j>=grid[0].length){
            return false;
        }

        if(!isPartOfIsland(i,j)){
            return false;
        }

        if(isVisited(i,j)){
            return false;
        }



        return true;

    }


    private boolean isVisited(int i, int j) {
        return visited[i][j];
    }
    public boolean isPartOfIsland(int i,int j){
        return grid[i][j]=='1';
    }
}
