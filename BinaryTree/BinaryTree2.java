import java.util.*;

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
        int lh = heightOfTree(root.left);
        int rd = diameterOfTree(root.right);
        int rh = heightOfTree(root.right);
        int selfd = lh+rh+1;
        return Math.max(Math.max(ld,rd),selfd);
    }
    static class Info {
        int diam;
        int ht;
        public Info(int diam,int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameterOfTree2(Node root) {
        if(root == null) {
            return new Info(0,0);
        }
        Info leftInfo = diameterOfTree2(root.left);
        Info rightInfo = diameterOfTree2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;

        return new Info(diam,ht);
    }
    public static boolean isIdentical(Node root, Node subroot) {
        if(root == null && subroot == null) {
            return true;
        }
        else if(root == null || subroot == null || root.data != subroot.data) {
            return false;
        }
        else if(!isIdentical(root.left, subroot.left) || !isIdentical(root.right, subroot.right)) {
            return false;
        }

        return true;
    }
    public static boolean isSubTree(Node root, Node subroot) {
        if(root == null) {
            return false;
        }
        if(root.data == subroot.data) {
            if(isIdentical(root,subroot)) {
                return true;
            }
        }

        return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
    }
    static class info2 {
        Node node;
        int hd;
        public info2(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root) {
        Queue<info2> queue = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min=0,max=0;
        queue.add(new info2(root, 0));
        queue.add(null);
        while(!queue.isEmpty()) {
            info2 curr = queue.remove();
            if(curr == null) {
                if(queue.isEmpty()) {
                    break;
                }
                else {
                    queue.add(null);
                }
            }
            else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null) {
                    queue.add(new info2(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null) {
                    queue.add(new info2(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        for(int i=min;i<=max;i++) {
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builldTree(nodes);
        tree.preOrder(root);
        System.out.println();
        topView(root);
        // System.out.println(heightOfTree(root));
        // System.out.println(diameterOfTree(root));
        // System.out.println(diameterOfTree2(root).ht+" "+diameterOfTree2(root).diam);
        // tree.idx = -1;
        // int subnodes[] = {2,4,-1,-1,2,-1,-1};
        // Node subroot = tree.builldTree(subnodes);
        // tree.preOrder(subroot);
        // System.out.println("\n"+isSubTree(root, subroot));
    }
}
