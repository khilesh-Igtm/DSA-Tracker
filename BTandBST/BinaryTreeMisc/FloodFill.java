// Problem Statement:

// An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

// You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

// To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

// Return the modified image after performing the flood fill.

class FloodFill{
    public static void main(String[] args) {
       // Time Complexity : O(n*m)
// Space Complexity : O(n*m) 
    }
    public int[][]floodfill(int[][]image,int sr,int sc,int color){
        // avoid infinite loop if the new and old colors are the same..
        if(image[sr][sc]==color) return image;
        // run the fill function starting at the position given..
        fill(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    private void fill(int[][] image, int sr, int sc, int color, int cur) {
        // if sr is less than 0 or greater equals to the length of image..
        // or if sc is less than 0 or greater equals to length of image[0]
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length) return;
        // if image[sr][sc] is not equal to previous color
        if(cur != image[sr][sc]) return;
        // update the image[sr][sc] as a color;
        image[sr][sc] = color;
        // make four recursive calls to the function with (sr-1, sc), (sr+1, sc), (sr, sc-1) and (sr, sc+1)
        fill(image, sr-1, sc, color, cur);
        fill(image, sr+1, sc, color, cur);
        fill(image, sr, sc-1, color, cur);
        fill(image, sr, sc+1, color, cur);
    }
}