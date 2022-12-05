// Given a Binary Tree, convert it into its mirror. And return the inorder of it

// Using Recursive way
class Node{
    int data;
    Node left , right;
    public Node(int item){
        data = item;
        left = right = null;
    }
}

public class MirrorTree {
    Node root;
    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder();
        System.out.println("");

        /* convert tree to its mirror */
        tree.mirror();

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder();
    }
    // helper function
    void mirror(){
        root = mirror(root);
    }
    Node mirror(Node node){
        if(node == null) return node;
        // do the subtrees
        Node left = mirror(node.left);
        Node right = mirror(node.right);
        // swap the left and right pointers bcz whatever is left , becomes right in mirror
        node.left = right;
        node.right = left;
        return node;
    }
    // helper function
    void inOrder(){
        inOrder(root);
    }
    void inOrder(Node node){
        if(node == null) return;
        // inorder is left , root , right
        inOrder(node.left);
        System.out.println(node.data+" ");
        inOrder(node.right);
    }
}
