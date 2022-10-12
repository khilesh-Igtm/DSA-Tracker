class SearchIn2D {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        search(matrix,target);
    }

    private static boolean search(int[][] matrix, int target) {
        // Brute force with Tc as O(m*n) and Sc as O(1)
        
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[i].length;j++){
        //         if(matrix[i][j]==target){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        // //////////////////////////////////////////////////////////////////////
        ///// Staircase search / Better approach with Tc as O(m+n) and Sc as O(1)

        // int i = 0, j = matrix[0].length - 1;
        // while(i < matrix.length && j >= 0) {
        //   if(matrix[i][j] == target)
        //     return true;
        //   else if(matrix[i][j] > target)
        //     j --;
        //   else if(matrix[i][j] < target)
        //     i ++;
        // }
        // return false;

        ////////////////////////////////////////////////////////////////////////////////////////
        //////// Optimised approach / Binary search as matrix is sorted
        // Tc is O(log(m*n)) and Sc is O(1)

        int low =0;
        if(matrix.length==0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        // considering the 2d matrix as 1d array and then finding the mid
        int high = (m*n) -1;
        while(low<=high){
            int mid = (low+(high-low)/2);
            // finding quotient and remainder for row and column and on this basis only
            //  we are decrementing the size of an array
            if(matrix[mid/m][mid%m] == target) return true;
            if(matrix[mid/m][mid%m] < target) low = mid+1;
            else high = mid-1;
        }
        return false;

    }
}