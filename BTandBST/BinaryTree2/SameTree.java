import java.util.LinkedList;
import java.util.Queue;

// Write a program to check if two trees are identical or not.

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = null;
        right =null;
    }
}

  // Approach: In order to check whether two trees are identical or not, we need to
    //  traverse the trees. While traversing we first check the value of the nodes, if
    //  they are unequal we can simply return false, as trees are non-identical. If they
    //  are the same, then we need to recursively check their left child as well as the 
    // right child. When we get all the three values as true(node values, left child, 
    // right child) we can conclude that these are identical trees and can return true.
    //  Any other combination will return false.

public class SameTree {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.right.left = new Node(4);
        root1.right.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.right.left = new Node(4);

        if(isIdentical(root1,root2)){
            System.out.println("Both are same");
        }else{
            System.out.println("Not same");
        }

    }

    // Using recursive method
    // Tc is O(n) and Sc is also O(n)
    private static boolean isIdentical(Node node1, Node node2) {
        if(node1==null && node2==null) return true;
        else if(node1 ==null || node2 ==null) return false;
        return ((node1.data==node2.data) && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right));
    }


    // Iterative Solution using Queue
    // Tc is O(n) and Sc is Also O(n)
    public boolean isSameTree(TreeNode p, TreeNode q) {        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if(f == null && s == null){
                continue;
            }else if(f == null || s == null || f.val != s.val){
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }
        return true;
    }
  
}

