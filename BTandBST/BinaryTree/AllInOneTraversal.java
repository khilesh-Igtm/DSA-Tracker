import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }
}

class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode _node, int _num) {
        num = _num;
        node = _node;
    }
}
// Tc is O(3n) and Sc is O(4n)

public class AllInOneTraversal {
    public static void allTraversal(TreeNode root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        // we need to store in stack in pair of node and it's number . Number at
        // starting will be 1.
        // means while poping out we fix it in preorder , if num is 2 then in inorder
        // for num = 3 , fix in postorder
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root, 1));

        if (root == null)
            return;

        while (!st.isEmpty()) {
            Pair it = st.pop();

            // this is part of pre
            // increment 1 to 2
            // push the left side of the tree
            if (it.num == 1) {
                // num is 1 , so add it to preorder and increment num and push node in stack
                // with incremented num value.
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                // check for left node of our current node if present then add to stack with num
                // value as 1
                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }

            // this is a part of in
            // increment 2 to 3
            // push right
            else if (it.num == 2) {
                // is num is 2 add to inorder and increment num . and push again that num with incremented num value
                // as 3
                in.add(it.node.val);
                it.num++;
                st.push(it);

                // if it has right node then add to stack with num value as 1
                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            // don't push it back again
            // for num as 3 add to postorder 
            else {
                post.add(it.node.val);
            }
        }

    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        allTraversal(root, pre, in, post);

        System.out.println("The preorder Traversal is : ");
        for (int nodeVal : pre) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The inorder Traversal is : ");
        for (int nodeVal : in) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The postorder Traversal is : ");
        for (int nodeVal : post) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
    }
}