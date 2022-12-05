import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Problem Statement: Given the root of a binary tree, return the zigzag level order
//  traversal of Binary Tree. (i.e., from left to right, then right to left for the 
// next level and alternate between).

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

// Intuition: Considering the fact that we need to print the nodes, level by level,
    //  our first guess would definitely be that it must be related to level order
    //  traversal. If we closely examine, for even levels we need to go from left to 
    // right while for odd levels we need to go from right to left. 

    // Approach: The above idea, could be implemented with a queue. We initially keep an
    //  empty queue and push the root node. We also need to keep the left to right bool
    //  variable that keeps check of the current level we are in. As we traverse nodes
    //  in the queue, we need to push them in a temporary array. If left to right is false
    //  we need to reverse the array and push it in our data structure or else, simply
    //  push it in our data structure. In the end, when we have finished traversing the
    //  current level, we need to toggle our left to the right variable.



public class ZigZagTraversal {
    public static void main(String[] args) {
        int i, j;
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        ArrayList < ArrayList < Integer >> ans;
        ans = zigzagLevelOrder(root);
        System.out.println("Zig Zag Traversal of Binary Tree ");
        for (i = 0; i < ans.size(); i++) {
            for (j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node root) {
        // for level order traversal , we always need a queue
        Queue<Node> queue = new LinkedList<>();
        // this is for storing my final answer
        ArrayList<ArrayList<Integer>> wrapList = new ArrayList<>();
        // base case
        if(root ==null) return wrapList;
        // intially we added root to our queue
        queue.offer(root);
        // this is for maintaining the traversal , like from front or back.
        // assuming true means front and if it becomes false traverse from back. That would make it zigzag traversal.
        boolean flag = true;
        while(!queue.isEmpty()){
            // this is done bcz we have to take all the nodes of that level
            // so for each level it will have occupy that size and run for loop that num of times.
            int levelNum = queue.size();
            // created a inner list of size equal to levelnum
            ArrayList<Integer>subList = new ArrayList<>(levelNum);
            for(int i=0;i<levelNum;i++){
                // if it is not null then add to queue
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                // if flag is true remove the front value of  node from queue and add to sublist
                if(flag == true) subList.add(queue.poll().data);
                else subList.add(0,queue.poll().data);
            }
            // if flag is not equal to flag means , true is not equal to false then 1st level traversal is completed
            // ready for next
            flag = !flag;
            wrapList.add(subList);
        }
        return wrapList;
    }

    
     // dfs recursively
 public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    // starting with 0 level
    dfs(root, 0, ret);
    return ret;
}

private void dfs(TreeNode node, int l, List<List<Integer>> ret) {
    if (node != null) {
        // here l is level
        if (l == ret.size()) {
            List<Integer> level = new ArrayList<>();
            ret.add(level);
        }
        // if we are odd level then the traversal will be like
        if (l % 2 == 1) {
           ret.get(l).add(0, node.val);  // insert at the beginning
        } 
        // if we are at even level then
        else {
           ret.get(l).add(node.val);
        }
        // then recursively call the left and right by increasing their level
        dfs(node.left, l+1, ret);
        dfs(node.right, l+1, ret);
    }
}
}