import java.util.LinkedList;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        
    }

// Tc is O(n) and Sc is O(n)

    // Solution 1 : Intuition + Approach: Using LEVEL ORDER TRAVERSAL
//If we observe carefully, the depth of the Binary Tree is the number of levels in the
//  binary tree. So, if we simply do a level order traversal on the binary tree and keep
//  a count of the number of levels, it will be our answer.
public static int levelOrder(TreeNode root){
    // base case
    if(root == null) return 0;
    // queue is required for level order traversal
    LinkedList<TreeNode> queue = new LinkedList<>();
    // add root at the end of queue
    queue.addLast(root);
    // my final answer will store here
    int level =0;
    while(queue.size()>0){
        // get the size of queue
        int size = queue.size();
        while(size !=0){
            // if size is not size means there is some element in queue, so remove the 1st one
            // and check for it's left and right and add to queue
            TreeNode remNode = queue.removeFirst();
            if(remNode.left != null){
                queue.addLast(remNode.left);
            }
            if(remNode.right != null){
                queue.addLast(remNode.right);
            }
        }
        // increment level in each level
        level++;
    }
    // return my final answer
    return level;
}

// Solution 2: Intuition: Recursively ( Post Order Traversal )
// 1 + max(depth of left subtree, depth of right subtree)
// Why take Maximum?? Because we need maximum depth so if we know left & right children’s maximum depth then we’ll definitely get to the maximum depth of the entire tree.

// Approach : 

// We start to travel recursively and do our work in Post Order.
// Reason behind using Post Order comes from our intuition , that if we know the result of  left and right child then we can calculate the result using that. 
// This is exactly an indication of PostOrder, because in PostOrder we already calculated results for left and right children than we do it for current node.
// So for every node post order, we do Max( left result , right result ) + 1 and return it to the previous call.
// Base Case is when root == null so we need to return 0;

// Tc is O(n) and Sc is O(1)+O(H) H is height of tree
public int maxDepth(TreeNode root){
    if(root == null) return 0;
    // recursively iterate over the tree , 1st left part then right part and get the max height
    int leftHeight = maxDepth(root.left);
    int rightHeight = maxDepth(root.right);
    // by backtracking the data
    return 1+ Math.max(leftHeight,rightHeight);
}
}
