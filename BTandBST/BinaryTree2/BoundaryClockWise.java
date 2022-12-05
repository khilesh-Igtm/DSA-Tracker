import java.util.ArrayList;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class BoundaryClockWise {
    public static void main(String[] args) {
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
        addrightBoundary(node,ans);
        addLeaves(node,ans);
        addleftBoundary(node,ans);
        return ans;
    }
    private static boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }

    private static void addleftBoundary(Node root, ArrayList<Integer> res) {
        Node curr = root.left;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(isLeaf(curr)==false) temp.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
        int i;
        // adding to boundary node in revrse order
        for(i = temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }
    private static void addLeaves(Node root, ArrayList<Integer> res) {
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        // move till we find the leaf node and if we find that return it to answeer
        if(root.right != null) addLeaves(root.right, res);
        if(root.left != null) addLeaves(root.left, res);
        
    }
    private static void addrightBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.right;
        while(cur != null){
            // if it is leaf then add to answer
            if(isLeaf(cur)==false) res.add(cur.data);
            // if there is some left node then do this
            if(cur.right != null) cur = cur.right;
            // else move to right node and update cur
            else cur = cur.left;
        }
    }
    
}
