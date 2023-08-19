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
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        Node root = tree.builldTree(nodes);
        tree.preOrder(root);
        System.out.println();
        kthLevel(root, 3);
        System.out.println();
        preOrderKthLevel(root, 1, 2);
    }
}