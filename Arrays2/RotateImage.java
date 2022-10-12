import java.util.Arrays;

class RotateImage{
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(Solution(matrix)));
    }
   
    private static int[][] Solution(int[][] matrix) {

        // Tc is O(n2) and Sc is O(1)

int start =0;
int end = matrix.length-1;
while(start<end){
    // swapping last with first inner array
    int[] temp = matrix[start];
    matrix[start] = matrix[end];
    matrix[end] = temp;
    start++;
    end--;
}

// finding transpose now 
for(int i=0;i<matrix.length-1;i++){  
    for(int j =i+1;j<matrix[0].length;j++){ 
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
return matrix;



// for(int i = 0; i<matrix.length; i++){
//     for(int j = i; j<matrix[0].length; j++){
//         // finding the transpose i.e (arr[i][j] swapped with arr[j][i])
//         int temp = 0;
//         temp = matrix[i][j];
//         matrix[i][j] = matrix[j][i];
//         matrix[j][i] = temp;
//     }
// }
// for(int i =0 ; i<matrix.length; i++){
//     for(int j = 0; j<matrix.length/2; j++){
//         // then reverse through column
//         int temp = 0;
//         temp = matrix[i][j];
//         matrix[i][j] = matrix[i][matrix.length-1-j];
//         matrix[i][matrix.length-1-j] = temp;
//     }
// }
// return matrix;
//     }
 }}