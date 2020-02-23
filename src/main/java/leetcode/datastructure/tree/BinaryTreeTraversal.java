package leetcode.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * A tree is a frequently-used data structure to simulate a hierarchical tree structure.
 *
 * Each node of the tree will have a root value and a list of references to other nodes which are called child nodes.
 * From graph view, a tree can also be defined as a directed acyclic graph which has N nodes and N-1 edges.
 *
 * A Binary Tree is one of the most typical tree structure.
 * As the name suggests, a binary tree is a tree data structure in which each node has at most two children, which are referred to as the left child and the right child.
 </pre>
 */
public class BinaryTreeTraversal {

    public static void main(String[] args) {
         TreeNode root = new TreeNode(1);
         root.right = new TreeNode(2);
         root.right.right = new TreeNode(3);

         List<Integer> preorderTraversalTree = preorderTraversal_Recursive(root);
         System.out.println(preorderTraversalTree);
    }


    /**
     * Pre-order traversal is to visit the root first. Then traverse the left subtree. Finally, traverse the right subtree.
     * @param root root
     * @return list of int in pre-order traversal
     */
    public static List<Integer> preorderTraversal_Recursive(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        if(root.left != null)
        {
            List<Integer> leftList = preorderTraversal_Recursive(root.left);
            res.addAll(leftList);
        }
        if(root.right != null)
        {
            List<Integer> rightList = preorderTraversal_Recursive(root.right);
            res.addAll(rightList);
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
