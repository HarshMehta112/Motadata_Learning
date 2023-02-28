public class MinMaxInBinaryTree
{
    public Node root;
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

int maximumInTree(Node root)
{
    if(root==null)
    {
        return -1;
    }
    else
    {
        return Math.max(root.data,Math.max(maximumInTree(root.left),maximumInTree(root.right)));
    }
}

    public static void main(String[] args) {

        MinMaxInBinaryTree bt = new MinMaxInBinaryTree();

        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.right.left = new Node(5);
        bt.root.right.right = new Node(6);
        bt.root.right.right.right= new Node(7);
        bt.root.right.right.right.right = new Node(8);

        System.out.println(bt.maximumInTree(bt.root));


    }





}
