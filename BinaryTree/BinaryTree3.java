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

        return root;
    }
    public static int getDist(Node root, int n) {
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return 0;
        }
        int dist1 = getDist(root.left, n);
        int dist2 = getDist(root.right,n);
        if(dist1 == -1 && dist2 == -1) {
            return -1;
        }
        else if(dist2 == -1) {
            return dist1+1;
        }
        else
            return dist2+1;
        
    }
    public static int minDistance(Node root,int n1, int n2) {
        if(root == null) {
            return -1;
        }
        Node lca = lca2(root, n1, n2);
        int dist1 = getDist(lca, n1);
        int dist2 = getDist(lca,n2);
        return dist1+dist2;
    }
    public static int kthAncestor(Node root, int n, int k) {
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return 0;
        }
        int dist1 = kthAncestor(root.left, n, k);
        int dist2 = kthAncestor(root.right, n, k);
        if(dist1 == -1 && dist2 == -1) {
            return -1;
        }
        int max = Math.max(dist1,dist2);
        if(max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;
    }
    public static int sumTree(Node root) {
        if(root == null) {
            return 0;
        }
        int lns = sumTree(root.left);
        int rns = sumTree(root.right);
        int rootData = root.data;
        root.data = lns+rns;
        return rootData+lns+rns;
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
        // System.out.println(lca2(root, 4, 6).data);
        // System.out.println(minDistance(root, 4, 4));
        // kthAncestor(root, 4,2);
        System.out.println(sumTree(root));
        tree.preOrder(root);
    }
}