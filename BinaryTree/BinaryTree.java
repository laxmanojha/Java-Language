
public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int idx = -1;
    public Node builldTree(int[] nodes) {
        idx++;
        if(nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = builldTree(nodes);
        newNode.right = builldTree(nodes);
        return newNode;
    }
    public void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
}