package PreOrderTraversal;

import java.util.ArrayList;
import java.util.Stack;

// Intuition: In preorder traversal, the tree is traversed in this way: root, left, right. When we visit a
//  node, we print its value, and then we want to visit the left child followed by the right child. 
// The fundamental problem we face in this scenario is that there is no way that we can move from a child
//  to a parent. To solve this problem, we use an explicit stack data structure. While traversing we can insert
//  node values to the stack in such a way that we always get the next node value at the top of the stack.

// Approach: 

// The algorithm approach can be stated as:

// We first take an explicit stack data structure and push the root node to it.(if the root node is not NULL).
// Then we use a while loop to iterate over the stack till the stack remains non-empty.
// In every iteration we first pop the stack’s top and print it. 
// Then we first push the right child of this popped node and then push the left child, if they are not NULL. We do so because stack is a last-in-first-out(LIFO) data structure. We need to access the left child first, so we need to push it at the last.
// The execution continues and will stop when the stack becomes empty. In this process, we will get the preorder traversal of the tree.


class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Iterativeway {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrder = preOrderTrav(root);
        System.out.println("The PreOrder Traversal is : ");
        for(int i=0;i<preOrder.size();i++){
            System.out.println(preOrder.get(i)+" ");
        }
    }

// Tc is O(n) and Sc is O(n)

    private static ArrayList<Integer> preOrderTrav(Node curr) {
// using a stack . In preorder we go from root, left and then right
       ArrayList<Integer> preOrder = new ArrayList<>();
       if(curr == null) return preOrder;
       Stack<Node> s = new Stack<>();
       s.push(curr);
       while(!s.isEmpty()){
        // so get the root element
        Node topNode = s.peek();
        // add this to my final answer list
        preOrder.add(topNode.data);
        // then pop out from stack
        s.pop();
        // then push right node data to stack until it is not null
        if(topNode.right != null){
            s.push(topNode.right);
        }
        // then after right node push left node to stack
        if(topNode.left != null){
            s.push(topNode.left);
        }
       }
       return preOrder;
    }
}
