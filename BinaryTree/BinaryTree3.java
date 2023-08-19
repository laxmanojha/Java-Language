import java.util.*;
public class BinaryTree3 extends BinaryTree {

    public static void kthLevel(Node root, int level) {
        Queue<Node> q = new LinkedList<>();
        int levelCount = 1;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            Node curr = q.remove();
            if(curr == null) {
                levelCount++;
                if(q.isEmpty() || levelCount > level)
                    break;
                else    
                    q.add(null);
            }
            else {
                if(level == levelCount) 
                    System.out.print(curr.data+" ");
                if(curr.left != null) 
                    q.add(curr.left);
                if(curr.right != null) 
                    q.add(curr.right);
            }
        }
    }
    public static void preOrderKthLevel(Node root, int level, int k) {
        // if(root == null || level > k) {
        //     return;
        // }
        if(root == null) 
            return;
        if(level == k) {
            System.out.print(root.data+" ");
            return;
        }
        preOrderKthLevel(root.left, level+1, k);
        preOrderKthLevel(root.right, level+1, k);
    }
    public static boolean getPath(Node root, int n, ArrayList<Node>path) {
        if(root == null) {
            return false;
        }
        path.add(root);
        if(root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size()-1);
        return false;

    }
    public static Node lca(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        int i=0;
        for(;i<path1.size() && i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i))
                break;
        }

        return path1.get(i-1);
    }
    public static Node lca2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = lca2(root.left,n1,n2);
        Node right = lca2(root.right, n1, n2);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        if(left != null && right != null) {
            return root;
        }
        return root;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        Node root = tree.builldTree(nodes);
        tree.preOrder(root);
        System.out.println();
        // kthLevel(root, 3);
        // System.out.println();
        // preOrderKthLevel(root, 1, 2);
        System.out.println(lca2(root, 4, 6).data);
    }
}