// Brute force : 
// A simple solution is to traverse the tree using (Inorder or Preorder or Postorder) and
//  keep track of the closest smaller or same element

// This is the optimal sol with  Tc is O(h) and Sc is O(1)

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};


class FloorInBST {
    public static void main(String[] args) {

    }

    public static int floorInBST(TreeNode<Integer> root, int key) {
        int floor = -1;
        while (root != null) {
            // if our root is equal to key then don;t need to do anything , return root.
            if (root.data == key) {
                floor = root.data;
                return floor;
            }
            // if key is greater than root.data , then move to right
            if (key > root.data) {
                floor = root.data;
                root = root.right;
            }
            // else move to left
            else {
                root = root.left;
            }
        }
        // finally return floor
        return floor;

    }
}