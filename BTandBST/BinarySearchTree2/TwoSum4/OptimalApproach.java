package TwoSum4;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val = val;
    }
}

// for this Tc will be O(n) and Sc is O(h)


class BSTIterator{
    // using stack to maintain the inorder traversal of nodes.
    Stack<TreeNode> s = new Stack<>();
    // creating a global variable to check whether traversing in ascending or descending order
    // if reverse -> true -> before -> reverse order(right , root, left)
    // if reverse -> false -> next -> ascending (left , root ,right)
    Boolean reverse = true;
    // Initializing using constructor
    public BSTIterator(TreeNode root , Boolean reverse){
        this.reverse = reverse;
        pushAll(root);
    }
    // This function returns the next element of the tree depending on reverse boolean used.
    public int next(){
        TreeNode temp = s.pop();
        // if reverse is false then we are traversing in ascending order
        if(reverse==false){
            pushAll(temp.right);
        }
        // else in descending order
        else{
            pushAll(temp.left);
        }
        // lastly returning the value
        return temp.val;
    }
    // this function just tells whether there are any elements left or not
    public boolean hasNext(){
        return !s.isEmpty();
    }
    // used to push all the nodes into the stack
    public void pushAll(TreeNode node){
        if(reverse == false){
            while(node != null){
                s.push(node);
                node = node.left;
            }
        }
        else{
            while(node != null){
                s.push(node);
                node = node.right;
            }
        }
    }


}


public class OptimalApproach {
    public static void main(String[] args) {
        
    }
    public boolean findTarget(TreeNode root , int k){
        // creating an instance of the BSTIterator class to get the desired traversal.
       BSTIterator left = new BSTIterator(root, false);
       BSTIterator right = new BSTIterator(root, true);

    //    Taking the first element of the ascending and descending traversals.
    int i = left.next();
    int j = right.next();

    // Using simple binary search logic to find the answer
    while(i<j){
        if(i+j == k) return true;
        else if(i+j <k) i = left.next();
        else j = right.next();
    }  
    return false; 
 }
}
