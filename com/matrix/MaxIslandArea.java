package com.matrix;

public class MaxIslandArea {

    public static void main(String[] args) {

        int grid[][] = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        int max = new MaxIslandAreaSolution().maxAreaOfIsland(grid);

        System.out.println();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.print(max);
    }

}

class MaxIslandAreaSolution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int i = 0;
        int j = 0;
        int diagonal = 0;

        while(diagonal < grid.length) {
            i = diagonal;
            j = 0;
            while(i >= 0 && j < grid[0].length) {
                if(grid[i][j] > 0) {
                    if(i>0) {
                        grid[i][j] += grid[i-1][j];
                    }
                    if(j>0) {
                        grid[i][j] += grid[i][j-1];
                    }
                    if(grid[i][j] > max) {
                        max = grid[i][j];
                    }
                }
                i--;
                j++;
            }
            diagonal++;
        }
        diagonal = 1;
        while(diagonal < grid[0].length) {
            i = grid.length - 1;
            j = diagonal;
            while(i >= 0 && j < grid[0].length) {
                if(grid[i][j] > 0) {
                    if(i>0) {
                        grid[i][j] += grid[i-1][j];
                    }
                    if(j>0) {
                        grid[i][j] += grid[i][j-1];
                    }
                    if(grid[i][j] > max) {
                        max = grid[i][j];
                    }
                }
                i--;
                j++;
            }
            diagonal++;
        }

        return max;
    }
}

class Range {
    int x;
    int y;

    public Range() {
        x = -1;
        y = -1;
    }

    public Range(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}