import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        Solution(numRows);
        
    }

    private static List<List<Integer>> Solution(int numRows) {
        // List<List<Integer>> triangle = new ArrayList<>();
        // List<Integer> prev =  null;
        // if(numRows<=0) return triangle;
        // for(int i=0;i<numRows;i++){
        //     List<Integer> row = new ArrayList<>();
        //     for(int j=0;j<i+1;j++){
        //         if(j==0 || j==i) row.add(1);
        //         else row.add(prev.get(j-1)+prev.get(j));
        //     }
        //     prev = row;
        //     triangle.add(row);
    
        // }
        // return triangle;



    //     List<List<Integer>> result = new ArrayList<>();
    //     if(numRows ==0) return result;
    //     // seed 1st row
    //     result.add(new ArrayList<>(Arrays.asList(1)));
    //    for(int i=1;i<numRows;i++){
    //     // starting from 2nd row bcz we seeded 1st row
    //     List<Integer> row = new ArrayList<>();
    //     // add first 1 in each row
    //     row.add(1);

    //     for(int j=1;j<i;j++){
    //         int left = result.get(i-1).get(j-1);
    //         int right = result.get(i-1).get(j);
    //         row.add(left+right);
    //     }
    //     // add last 1 in each row
    //     row.add(1);
    //     result.add(row);
    //    }
    //    return result;


    int [][]dp = new int [numRows][numRows];
			for(int i=0;i<numRows;i++){
				 dp[0][i]=1;
				 dp[i][0]=1; 
			 }
			for(int i=1;i<numRows;i++){
				for(int j=1;j<numRows;j++){
					dp[i][j]=dp[i-1][j]+dp[i][j-1];
				}
			}
			List<List<Integer>> aList =  new ArrayList<List<Integer>>(numRows);
			int temp=0;
			  for(int i=0;i<numRows;i++){
				  temp=i;
				List<Integer> a1 = new ArrayList<Integer>();
				for(int j=0;j<=i;j++){
					a1.add(dp[temp][j]);
					temp--;
				}
				  aList.add(a1);
			}
			return aList;

    }
}
