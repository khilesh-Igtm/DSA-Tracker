import java.util.LinkedList;
import java.util.Queue;

// The maximum width of a binary tree is the maximum of all the level widths. Width for a level is defined as the maximum number of nodes between the leftmost and rightmost node of the level(including the end nodes and the null nodes between the end nodes). 
// Therefore we can use a level order traversal to traverse the tree and in every level, we try to find the leftmost and rightmost node of that level. To achieve this we would need a proper indexing strategy to uniquely index nodes of a level. Once we know the leftMost and rightMost nodes, width can be defined as (rightMost- leftMost +1).
// To store the index, we can use a pair of values in our queue( that we use for level order traversal). If we are at index i, then its left and right child are(in 0-based indexing): 2*i+1 and 2*i+2 respectively.
// This approach has a problem, as we are multiplying 2 to the current index, it can happen in a tree that we overshoot the bound of an integer. Therefore, we need to find a strategy to prevent it.
// Prevention of integer overflow
// Before starting a level, we can store the left-most index in a variable( say curMin). Now whenever we assign the index for its children, we take the parent node index as (i-curMin) rather than i. The below illustration will clear the concept.
// As our final answer is a range of nodes in a level, i,e rightMost- leftMost+1; this strategy will not affect the answer and at the same time prevent the integer overflow case.


// Tc and Sc are O(n) and O(n)
class TreeNode{
    int data;
    TreeNode left , right;
    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair{
    TreeNode node;
    // num here is the index , where we will find the node
    int num;
    // we make a [air of node and it's index value ]
    Pair(TreeNode _node , int _num){
        num = _num;
        node = _node;
    }
}


class MaxWidthOfTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        System.out.println(widthOfBinaryTree(root));
    }

    private static int widthOfBinaryTree(TreeNode root) {
       if(root == null) return 0;
       int ans =0;
    //    this pair will be of node and the index of the node. so we store a pair of node and index in queue
       Queue<Pair> q = new LinkedList<>();
    //    at starting we added our root node with index 0 to queue
       q.offer(new Pair(root, 0));
    //    then we iterate through the queue until it is empty
       while(!q.isEmpty()){
        // this is will store the size of queue at every moment 
        int size = q.size();
        // it will store the num/index of the top element of queue. At starting val is 1 and num/index is 0
        int mmin = q.peek().num;
        int first =0,last =0;
        // will go from 0 to 1 for 1st iteration
        for(int i=0;i<size;i++){
            // cur_id will store the differnce of top peek index and the mmin element. This is done to avoid interger overflow 
            // as it is given is question that range should be in 32 bit.
            // and also we are finding the left and right node (2*i+1) and (2*i+2) which will go beyond int range.
            int cur_id = q.peek().num-mmin;
            // then node will store the top element value
            TreeNode node = q.peek().node;
            // and remove it from the queue
            q.poll();
            // find the first and the last node to calculate the max width .
            // for every iteration we calculate this and update if we get max value
            if(i==0) first = cur_id;
            if(i==size-1) last = cur_id;
            // this is for finding the left node
            if(node.left != null){
                q.offer(new Pair(node.left, cur_id*2+1));
            }
            // for finding the right node
            if(node.right != null){
                q.offer(new Pair(node.right, cur_id*2+2));
            }
        }
        // calculate the max width
        ans = Math.max(ans,last-first+1);
       }
    //    return final answer
       return ans;
    }

}