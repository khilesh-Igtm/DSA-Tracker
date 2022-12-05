import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Populate each next pointer to point to its next right node. If there is no next right
//  node, the next pointer should be set to NULL.
// Initially, all next pointers are set to NULL.
class Node{
    int data;
    Node left,right , next;
    Node(int data){
        this.data = data;
        left = null;
        right =null;
    }
}

class PopulatingRightPointer{
    public static void main(String[] args) {
        
    }
    // using dfs recursively
    public Node connect(Node root) {
        if(root == null) return root;
        
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.right != null){
            root.right.next = root.next != null ? root.next.left : null;
        }
        
        connect(root.left);
        connect(root.right);
        return root;
    }

    // using dfs iteratively
    public void connect1(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node n = stack.pop();
            if(n != null){
                if(n.right != null){
                    n.left.next = n.right;
                    if(n.next != null){
                        n.right.next = n.next.left;
                    }
                }
                stack.push(n.right);
                stack.push(n.left);
            }
        }
    }

    // bfs iteratively
    public void connect2(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n!= null){
                if(n.right != null){
                    n.left.next = n.right;
                    if(n.next != null){
                        n.right.next = n.next.left;
                    }
                }
                queue.add(n.left);
                queue.add(n.right);
            }
        }
    }

}