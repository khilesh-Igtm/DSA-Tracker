import java.util.ArrayList;
import java.util.List;



// Input
// ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
// [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
// Output
// [null, 3, 7, true, 9, true, 15, true, 20, false]

// Explanation

// BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
// bSTIterator.next();    // return 3
// bSTIterator.next();    // return 7
// bSTIterator.hasNext(); // return True
// bSTIterator.next();    // return 9
// bSTIterator.hasNext(); // return True
// bSTIterator.next();    // return 15
// bSTIterator.hasNext(); // return True
// bSTIterator.next();    // return 20
// bSTIterator.hasNext(); // return False


// Tc is O(1) and Sc is O(n) for using list to store the inorder traversal
// Tc is O(1) bcz we need constant time to check the next
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val = val;
    }
}

public class BSTIterator {
    public static void main(String[] args) {
        
    }
    // for storing the inorder traversal we created  a list , as inorder is sorted in bst
    List<TreeNode> list = new ArrayList<>();
    int index;
    public  void Bstiterator(TreeNode root){
        inOrder(root);
        index =0;
    }
    // doing a normal inorder traversal and stored all node in ascending order
    private void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        list.add(node);
        inOrder(node.right);
    }
// as we have a list of all nodes in sorted ,we can find the next node 
    public int next(){
        return (list.get(index++)).val;
    }
    // this is for check whether there be a next. If our index value becomes greater than list size then it's impossible
    public boolean hasNext(){
        return index < list.size();
    }

}
