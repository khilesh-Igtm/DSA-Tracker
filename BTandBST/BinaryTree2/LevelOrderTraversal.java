import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



// Approach:

// Take a queue data structure and push the root node to the queue.
// Set a while loop which will run till our queue is non-empty.
// In every iteration, pop out from the front of the queue and assign it to a variable (say temp).
// If temp has a left child, push it to the queue.
// If temp has a right child, push it to the queue.
// At last push the value of the temp node to our “ans” data structure.

class TreeNode{
    int val;
    TreeNode left , right;
    TreeNode(int val){
        this.val = val;
        left = null;
        right =null;
    }
}
// Tc is O(n) and Sc is also O(n)

class LevelOrderTraversal{
    public static void main(String[] args) {
        
    }
    public List<Integer> levelOrder(TreeNode root){
        // queue DS is required for solving this problem
        Queue<TreeNode> queue = new LinkedList<>();
        // this will have my final answer
        ArrayList<Integer> wrapList = new ArrayList<Integer>();
        // base case
        if(root == null) return wrapList;
        // intially add our root to queue
        queue.offer(root);
        // iterate until queue is empty
        while(!queue.isEmpty()){
            // check if our top node has left , if yes then add it to our queue
            if(queue.peek().left != null){
                queue.offer(queue.peek().left);
            }
            // similarly for right node
            if(queue.peek().right != null){
                queue.offer(queue.peek().right);
            }
            // finally add element value from front end to our answer list
            wrapList.add(queue.poll().val);
        }
        // then finally store them list . but we can’t differentiate from our ans that
        //  whether two nodes are from the same level or not.
        // so for that new solution is down here
        return wrapList;

    }
}

// class Solution {
    // we just declare List<List<Integer>> to store my answer
//     public List<List<Integer>> levelOrder(TreeNode root) {
//          Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
//         if(root == null) return wrapList;
        
//         queue.offer(root);
//         while(!queue.isEmpty()){
//             int levelNum = queue.size();

// here it will store our sublist individually

//             List<Integer> subList = new LinkedList<Integer>();
//             for(int i=0; i<levelNum; i++) {
//                 if(queue.peek().left != null) queue.offer(queue.peek().left);
//                 if(queue.peek().right != null) queue.offer(queue.peek().right);
//                 subList.add(queue.poll().val);
//             }
//             wrapList.add(subList);
//         }
//         return wrapList;
//     }
// }