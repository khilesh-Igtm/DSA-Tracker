package MaxXORWithElement;

// Tc is O(N*M)
// Sc is O(1)

import java.util.ArrayList;

// nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
// in queries 3 is 0th part and 1 is 1st part and similarly for all
public class Bruteforce {
    public static void main(String[] args) {
        
    }
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer>arr,ArrayList<ArrayList<Integer>> queries){
        // size of array and number of queries
        int n = arr.size();
        int m = queries.size();

        ArrayList<Integer> result = new ArrayList<>();
        // intialising our final answer as -1
        for(int i=0;i<m;i++){
            result.add(-1);
        }
        // finding answer of each query
        // traversing through array and queries both
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                // 1 is for 2nd part and 0 is for 1st part
                if(arr.get(j)<=queries.get(i).get(1)){
                    int p = Math.max(result.get(i), (arr.get(j)^queries.get(i).get(0)));
                    result.set(i, p);
                }
            }
        }
        return result;
    }
}
