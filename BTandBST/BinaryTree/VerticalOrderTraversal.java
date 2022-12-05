import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;


// Time Complexity: O(N*logN*logN*logN)

// Space Complexity: O(N)

class TreeNode{
    int data;
    TreeNode left , right;
    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Tuple{
    TreeNode node;
    int row, col;
    public Tuple(TreeNode _node , int _row, int _col){
        // here row and col are vertical and level
        node = _node;
        row = _row;
        col = _col;
    }
}


class VerticalOrderTraversal{
    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List < List < Integer >> list = new ArrayList < > ();
        list = findVertical(root);
        System.out.println("The Vertical Traversal is : ");
        for (List < Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }
        
    }

    private static List<List<Integer>> findVertical(TreeNode root) {
        // this is data structure that stores the num and the node.
        // treemap of integer(num here which is vertical or coordinates) and treemap of integer
        // i.e level of the tree and priorityqueue for maintaining in sorted order of overlapping and repeating node.
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // created a queue DS which will have node , vertical and level.
        Queue<Tuple> q = new LinkedList<Tuple>();
        // intially we added our root node with 0 vertical(coordinate) and 0 level.
        q.offer(new Tuple(root, 0, 0));
        // check until q is empty
        while(!q.isEmpty()){
            // then we pop the top of queue and store it in tuple
            // then for that node , do the level order traversal by checking for left node then right node
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            // these x and y are find for maintaining the balance , if there might be some
            // overlapping node then store in ascending order and if there are duplicates 
        //    x is vertical
            int x = tuple.row;
            // y is level
            int y = tuple.col;

            // if our vertical doesn't exits we are creating a TreeMap
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            // if our PQ doesn't exist we are creating a PQ
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
        //   then we are getting data from the level of a vertical.
        // means from a given vertical , we are taking a level and from that level we are taking node data
            map.get(x).get(y).offer(node.data);
              // for the left node
            if(node.left != null){
                q.offer(new Tuple(node.left, x-1, y+1));
            }
            // for the right node
            if(node.right != null){
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }
        // this stores my final answer
        List<List<Integer>> list = new ArrayList<>();
        // for every vertical , we are itertaing . map.values() means for every vertical i.e -2, -1, 0, 1,2.
        for(TreeMap<Integer,PriorityQueue<Integer>> ys :map.values()){
            // then i am adding an empty list for every vertical
            list.add(new ArrayList<>());
            // and on this list, i am iterating over PQ then taking the values and adding to my answer list.
            for(PriorityQueue<Integer> nodes : ys.values()){
                while(!nodes.isEmpty()){
                    // adding values
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        // return final answer
        return list;
    }
}