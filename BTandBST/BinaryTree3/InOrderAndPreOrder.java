import java.util.HashMap;
import java.util.Map;

// Construct A Binary Tree from Inorder and Preorder Traversal

// Intitution
// Inorder traversal is a special traversal that helps us to identify a node and its left
//  and right subtree. Preorder traversal always gives us the root node as the first
//  element. Using these properties we can construct the unique binary tree.


// Approach

// The algorithm approach can be stated as:

// Create a map to store the inorder indexes.
// Call the function constructTree with all 7 parameters as shown above.
// In the recursive function, first check the base case, if (preStart,>preEnd || inStart> inEnd) then return NULL.
// Construct a node (say root) with the root value( first element of preorder). 
// Find the index of the root, say elem from the hashmap.
// Find the number of elements ( say nElem) in the left subtree  = elem – inStart
//  Call recursively for the left subtree with correct values (shown in the above table) and store the answer received in root->left.
// Call recursively for the right subtree with correct values (shown in the above table) and store the answer received in root->right.
// Return root

// Tc is O(n) and Sc is O(n)

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}

public class InOrderAndPreOrder {
    public static void main(String[] args) {
    int preorder[] = {10,20,40,50,30,60};
    int inorder[] = {40,20,50,10,60,30};
 buildTree(preorder, inorder);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        // created  the map to store index , we are storing bcz we will find the root from preorder
        // and then check in inorder where it lies and all the left node from that root in inorder will be left and right other half.
        Map<Integer,Integer> inMap = new HashMap<>();
        //  add all the inorder node  val and it's index in the map
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> inMap) {
        // the base case , if i have empty array or i can't create a preorder or inorder then i will return null
        if(preStart > preEnd || inStart > inEnd) return null;
        // intially create a root and store the starting of preorder bcz preorder is root, left and right.
        // so starting of preorder will be root
        TreeNode root = new TreeNode(preorder[preStart]);
        // then i search in my hashmap , at what index does my root is present
        int inRoot = inMap.get(root.val);
        // then i get total number of element to the left of root
        int numsLeft = inRoot - inStart;

        // then i again starting doing the same thing recursively until the left and right child node are not null
        // our preorder +1 strts bcz starting is already taken till nums+left bcz ,we need same number of element from preorder
        // as there are in my left part of inorder and inorder will start from starting till inroot-1
        root.left = buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
        // for right half my preorder will start from , prestart+numsleft+1 till end means the next element after root.
        // and inorder will start from inroot+1 till end 
        root.right = buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);
        // and at the end return the root . As it will be a tree 
        return root;
    }
}
