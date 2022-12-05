import java.util.ArrayDeque;
// The ArrayDeque in Java provides a way to apply resizable-array in addition to the 
// implementation of the Deque interface. It is also known as Array Double Ended Queue
//  or Array Deck. This is a special kind of array that grows and allows users to add or 
// remove an element from both sides of the queue.

// Tc is O(1) and Sc is O(h). 'h' is height of tree. As we are only storing the left part
// of tree at a time till it's depth then pop out it to get smallest element 
// and check it's right for next.

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

// what we are doing here is , we have to avoid that extra O(n) space for storing
// the inorder. so for that we are creating an inorder which means , we created a stack
// and we want the elements in increasingly sorted way. so we move to the left till depth and store
// all the left elements  until next is asked. and simultaneulsy check for right in the depth too
// if we find that , then push until next is asked.
// hence in this way we will get the inorder traversal of the tree but here we are not traversaing
// the whole tree at a time,we are traversing the height of a tree at a time. Means go left ,left , left if prsent till
// depth now if left is null check for root then check for right .


// but in case we want to find the before element (here we are finding the next), so will do reverse inorder type technique
// means right , root , left to the stack and the procedure will be same. But the elements stored in
// in the stack will be in descending order
public class BSTIteratorOptimal {
    public static void main(String[] args) {
// Approach will be , i will create a stack and push all the left part elements in the stack until
// left is not null , if we encounter null then pop the top element from the stack and check for it's right
// if present then push to stack else pop remaining elements and in this way we will get the sorted inorder traversal.
    }

    // iterative inorder traversal (inorder of bst is sorted)
    // faster than stack
    ArrayDeque<TreeNode> stack;

    private void pushAll(TreeNode temp) {
        // pushing the left nodes on the stack until we reach the null node
        while (temp != null) {
            // pushing to the stack
            stack.addLast(temp);
            // moving the left subtree
            temp = temp.left;
        }

    }

    public void BSTIterator(TreeNode root) {
        // intilizing stack
        stack = new ArrayDeque<>();
        pushAll(root);
    }

    public int next() {
        // smallest till now
        TreeNode pop = stack.removeLast();
        pushAll(pop.right);
        return pop.val;
    }

    public boolean hasNext() {
        if (!stack.isEmpty()) {
            return true;

        }
        return false;
    }

}
