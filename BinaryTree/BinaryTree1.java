import java.util.*;

public class BinaryTree1 {
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
    static class BinaryTree {
        static int idx = -1;
        public Node BuildTree(int[] nodes) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;
        }
        public void preOrder(Node root) {
            if(root == null) {
                // System.out.print(-1+" ");
                return;
            }

            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public void inOrder(Node root) {
            if(root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
        public void postOrder(Node root) {
            if(root == null) {
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
        public void levelOrder(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while(!queue.isEmpty()) {
                Node currNode = queue.remove();
                if(currNode == null) {
                    System.out.println();
                    if(queue.isEmpty()) {
                        break;
                    } 
                    else {
                        queue.add(null);
                    }
                } 
                else {
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if(currNode.right != null) {
                        queue.add(currNode.right);
                    }
                }

            }
        }
        public int heightOfTree(Node root) {
            if(root == null) {
                return 0;
            }
            int lh = heightOfTree(root.left);
            int rh = heightOfTree(root.right);
            return Math.max(lh,rh)+1;
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree(nodes);
        tree.preOrder(root);
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        tree.levelOrder(root);
        System.out.println(tree.heightOfTree(root));
    }
}