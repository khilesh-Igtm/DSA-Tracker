// we are given a preorder traversal of some tree which means our 1st node
// will be root

// so we follow steps:
// 1>we create the node
// 2>we traverse the array for values which are less than the current node!-- these values will become our left subtree.we stop whenever we get a value larger than the current root of the subtree!
// 3>we take the rest of the array(values whuch are greater than the value of the current root)-these are the values which will make out right subtree!

// so we make a root!
// make the left subtree(recursively)
// then make right subtree(recursively)

// It;s Tc is O(n2)
package BstFromPreorder;

class TreeNode{
    int val;
    TreeNode left , right;
    TreeNode(int val){
        this.val = val;
    }
}
public class BSTFromPreOrder {
    public static void main(String[] args) {
        
    }
    public TreeNode bstFromPreorder(int[] preorder){
        return helper(preorder,0,preorder.length-1);
    }
    private TreeNode helper(int[] preorder, int start, int end) {
        if(start>end) return null;
        // as we know start of preorder traversal is the root . so we created a node and assigned our 1st element of
        // array to it as a root
        TreeNode node = new TreeNode(preorder[start]);
        int i;
        // then start traversing through the array to find the left and right node of the root.
        for(i=start;i<=end;i++){
            if(preorder[i]>node.val){
                break;
            }
        }
        // then our left and right will be called recursively , as then can also form a subtree
        // finally return node
        node.left = helper(preorder,start+1,i-1);
        node.right = helper(preorder,i,end);
        return node;
    }
}
