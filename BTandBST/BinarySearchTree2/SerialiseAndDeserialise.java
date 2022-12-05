import java.util.LinkedList;
import java.util.Queue;

// Problem Statement: Design an algorithm to serialize and deserialize a binary tree.
//  There is no restriction on how your serialization/deserialization algorithm should
//  work. You just need to ensure that a binary tree can be serialized to a string and 
// this string can be deserialized to the original tree structure.

// Input: root = [1,2,3,null,null,4,5]
// Output: [1,2,3,null,null,4,5]
// Explanation: The input and the output would be the same for this problem as we are 
// serializing the tree and again deserializing the string format to the binary tree 
// format.

// Tc is O(n) and Sc is O(n)

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val = val;
    }
}

public class SerialiseAndDeserialise {
    public static void main(String[] args) {
        
    }

    // converting a tree to string format and whenevr there is a null , then we put # for
    // that place
    public String serialize(TreeNode root){
        // if our tree is empty then return empty string 
        if(root==null) return "";
        Queue<TreeNode>q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        // we added our 1st element i.e root to queue
        q.add(root);
        while(!q.isEmpty()){
            // if q is not empty , then get the top element from queue and store it in node variable.
            TreeNode node = q.poll();
            // if any node is null then place # for specify that it position consit of null
            // in Binary tree
            if(node == null){
                res.append("#");
                continue;
            }
            // if it is not null then add to our string builder answer with space
            res.append(node.val+" ");
            // after adding check for the left and right continue this process until q is empty
            q.add(node.left);
            q.add(node.right);
        }
        // finally we will egt our encoded string
        return res.toString();
    }

    // now change back this encoded string to the original binary tree
    public TreeNode deserialize(String data){
        // if our string is empty then return null
        if(data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        // separate the string based on the spaces between them
        String[] values = data.split(" ");
        // we created a root by taking the 1st element from the string and converted to int
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        // then we added that root to queue
        q.add(root);
        // start traversing from 1 index of string
        for(int i=1;i<values.length;i++){
            // take the top element from the string 
            TreeNode parent = q.poll();
            // check if our index value is not # then it means that it is not null and can be
            // left node of the root 
            if(!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                // so add it and add it to queue also for further more child nodes
                parent.left = left;
                q.add(left);
            }
            // similarly do the above technique for the right part
            if(!values[++i].equals("#")){
                //parseint will convert string to int format
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        // finally return root 
        return root;
    }
}
