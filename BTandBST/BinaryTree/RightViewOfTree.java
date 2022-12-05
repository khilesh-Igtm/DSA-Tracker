import java.util.ArrayList;
import java.util.List;

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Tc is O(n) and Sc is O(H) "H is height of tree"

public class RightViewOfTree {
    public static void main(String[] args) {
        
    }
    public List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(Node curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.data);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}
