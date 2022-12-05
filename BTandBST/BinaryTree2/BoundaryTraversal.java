import java.util.ArrayList;

// Write a program for the Anti-Clockwise Boundary traversal of a binary tree.
// Approach: Boundary traversal in an anti-clockwise direction can be described as a traversal consisting of three parts:
// Part 1: Left Boundary of the tree (excluding the leaf nodes).
// Part 2: All the leaf nodes travelled in the left to right direction.
// Part 3: Right Boundary of the tree (excluding the leaf nodes), traversed in the reverse direction.

// Tc is O(n) and Sc is O(n)

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BoundaryTraversal{
    public static void main(String[]args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        ArrayList<Integer> boundaryTraversal;
        boundaryTraversal = printBoundary(root);

        System.out.println("The Boundary Traversal is : ");
        for(int i=0;i<boundaryTraversal.size();i++){
            System.out.print(boundaryTraversal.get(i)+" " );
            
        }
    }

    private static ArrayList<Integer> printBoundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        // if node is our leaf node then add it to our answer
        if(isLeaf(node)==false) ans.add(node.data);
        addLeftBoundary(node,ans);
        addLeaves(node,ans);
        addRightBoundary(node,ans);
        return ans;
    }

    static Boolean isLeaf(Node root) {
        // means it doesn't have any left and right node child
        return (root.left == null) && (root.right == null);
    }


    // finding all left boundary node
    private static void addLeftBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.left;
        while(cur != null){
            // if it is leaf then add to answer
            if(isLeaf(cur)==false) res.add(cur.data);
            // if there is some left node then do this
            if(cur.left != null) cur = cur.left;
            // else move to right node and update cur
            else cur = cur.right;
        }
    }

    // add leaf node to answer after my left node as we need this in anti-clock wise
    // direction.
    private static void addLeaves(Node root, ArrayList<Integer> res) {

        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        // move till we find the leaf node and if we find that return it to answeer
        if(root.left != null) addLeaves(root.left, res);
        if(root.right != null) addLeaves(root.right, res);
    }

    // find the right boundary node , in the reverse order
    // so for that we need an auxiliary space or can use stack for intially storing 
    // then after storing all right node we can pop in reverse order and add to our boundary list.
    private static void addRightBoundary(Node root, ArrayList<Integer> res) {
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(isLeaf(curr)==false) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        int i;
        // adding to boundary node in revrse order
        for(i = temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }

   

    
}
