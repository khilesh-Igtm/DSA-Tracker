import java.util.HashMap;
import java.util.Map;

// Tc is O(n) and Sc is O(n)
// postorder is left , right and root . so root will be the end of postorder array
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}


public class InOrderAndPostOrder {
    public static void main(String[] args) {
    int inorder[] = {10,20,40,50,30,60};
    int postorder[] = {40,20,50,10,60,30};
    buildTree(inorder, postorder);
   
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if(inorder==null||postorder==null)return null;
        if(n!=postorder.length)return null;
      
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
          map.put(inorder[i], i);
        }
        return build(inorder, 0, n-1, postorder, 0, n-1, map);
    }

    public static TreeNode build(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend, Map<Integer, Integer> map){
        if(poststart>postend || instart>inend)return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int ri = map.get(postorder[postend]);
        root.left = build(inorder, instart, ri-1, postorder, poststart, poststart+ri-instart-1, map);
        root.right = build(inorder, ri+1, inend, postorder, poststart+ri-instart, postend-1, map);
        return root;
     }
}
