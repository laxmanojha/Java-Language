public class BinaryTree2 {
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
    public static int heightOfTree(Node root) {
        if(root == null) {
            return 0;
        }
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        return Math.max(lh,rh)+1;
    }
    public static int diameterOfTree(Node root) {
        if(root == null) {
            return 0;
        }
        int ld = diameterOfTree(root.left);
        int rd = diameterOfTree(root.right);
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        int selfd = lh+rh+1;
        return Math.max(selfd,Math.max(ld,rd));
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builldTree(nodes);
        tree.preOrder(root);
        System.out.println();
        System.out.println(heightOfTree(root));
        System.out.println(diameterOfTree(root));
    }
}
