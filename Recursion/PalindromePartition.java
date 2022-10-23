import java.util.ArrayList;
import java.util.List;

class PalindromePartition {
    public static void main(String[] args) {
        String s = "aabb";
        List < List < String >> ans = partition(s);
        int n = ans.size();
        System.out.println("The Palindromic Partitions are :");
        System.out.println(" [ ");
        for(int i=0;i<n;i++){
            System.out.println(" [ ");
            for(int j=0;j<ans.get(i).size();j++){
                System.out.println(ans.get(i).get(j)+" ");
            }
            System.out.println(" ] ");
        }
        System.out.println(" ] ");
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String>path = new ArrayList<>();
        partitionHelper(0,s,path,res);
        return res;
    }

    private static void partitionHelper(int index, String s, List<String> path, List<List<String>> res) {
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index, i+1));
                partitionHelper(i+1, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
// Time complexity is O((2^n)*k*(n/2))
// Space complexity is O(k*x) or O(n)
    
}
