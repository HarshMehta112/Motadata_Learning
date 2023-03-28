import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeHeight {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){

            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Represent the root of binary tree
    public Node root;
    public BinaryTreeHeight(){
        root = null;
    }

    //findHeight() will determine the maximum height of the binary tree
    public int findHeight(Node temp){
        //Check whether tree is empty
        if(root == null) {
            System.out.println("Tree is empty");
            return 0;
        }
        else {
            int leftHeight = 0, rightHeight = 0;

            //Calculate the height of left subtree
            if(temp.left != null)
                leftHeight = findHeight(temp.left);

            //Calculate the height of right subtree
            if(temp.right != null)
                rightHeight = findHeight(temp.right);

            int max = (leftHeight > rightHeight) ? leftHeight : rightHeight;

            return (max + 1);
        }
    }

    public void printLevelOrder(Node root)
    {
        Queue<Node> que = new LinkedList<>();

        que.add(root);

        while(!que.isEmpty())
        {
            Node curr = que.poll();

            System.out.print(curr.data+" ");

            if(curr.left!=null)
            {
                que.add(curr.left);
            }
            if(curr.right!=null)
            {
                que.add(curr.right);
            }
        }

    }


    public static void main(String[] args) {

        BinaryTreeHeight bt = new BinaryTreeHeight();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.right.left = new Node(5);
        bt.root.right.right = new Node(6);
        bt.root.right.right.right= new Node(7);
        bt.root.right.right.right.right = new Node(8);

        System.out.println("Maximum height of given binary tree: " + bt.findHeight(bt.root));

        bt.printLevelOrder(bt.root);
    }
}