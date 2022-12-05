

// Tc is O(h) and Sc is O(1)
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

public class CeilInBST {
    public static void main(String[] args) {
        
    }
    public static int findceil(TreeNode<Integer> root, int key){
        int ceil =-1;
        while(root != null){
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }
            if(key> root.data){
                root = root.right;
            }else{
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}
