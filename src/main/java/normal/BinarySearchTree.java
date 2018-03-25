package normal;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    public static void main(String[] args) {
        TreeNode<Integer> rootNode = new TreeNode<>(1);
        rootNode.setValue("root");

        BinarySearchTree<Integer> tree = new BinarySearchTree<>(rootNode);
        tree.insertTreeNote(new TreeNode<>(7,"val7"));
        tree.insertTreeNote(new TreeNode<>(4,"val4"));
        tree.insertTreeNote(new TreeNode<>(5,"val5"));
        tree.insertTreeNote(new TreeNode<>(9,"val9"));
        tree.insertTreeNote(new TreeNode<>(3,"val3"));
        TreeNode<Integer> treeNodeKey0 = new TreeNode<>(0, "val0");
        tree.insertTreeNote(treeNodeKey0);
        tree.insertTreeNote(new TreeNode<>(6,"val6"));
        TreeNode<Integer> treeNodeKey2 = new TreeNode<>(2, "val2");
        tree.insertTreeNote(treeNodeKey2);

        tree.printAllNodes();
        System.out.println("\n Tree size: " + tree.size());

        // Should be able to find node with key=9
        TreeNode find9 = tree.find(9);
        assert find9 != null;
        System.out.println(find9);

        // find a non existence key, must be null
        assert (tree.find(-1) == null);

        tree.insertTreeNote(new TreeNode<>(-1,"val-1"),treeNodeKey0);

        // Can find it now
        assert (tree.find(-1) != null);
        assert treeNodeKey0.getLeftNode().getKey() == -1;
    }

    public TreeNode<T> find(T key)
    {
        assert key != null;

        return find(key,rootNode);
    }

    public void insertTreeNote(TreeNode<T> treeNode) {
        insertTreeNote(treeNode,rootNode);
    }

    public void printAllNodes()
    {
        printAllNodes(rootNode);
    }

    public List<TreeNode<T>> toList(){
        return toList(rootNode);
    }
    private List<TreeNode<T>> toList(TreeNode node){
        List<TreeNode<T>> res = new ArrayList<>();
        if(node.getLeftNode() != null)
        {
            res.addAll(toList(node.getLeftNode()));
        }
        res.add(node);
        if(node.getRightNode() != null)
        {
            res.addAll(toList(node.getRightNode()));
        }
        return res;
    }

    public void printAllNodes(TreeNode node)
    {
        if(node.getLeftNode() != null)
        {
            printAllNodes(node.getLeftNode());
        }
        System.out.print(node.getKey()+"_");
        if(node.getRightNode() != null)
        {
            printAllNodes(node.getRightNode());
        }
    }

    public int size()
    {
        return size(rootNode);
    }

    /**
     * Find and return a node with the desired key.
     * Need to specify starting node, will traverse left and right until found the node with the key, OR null.
     * @param key key
     * @param fromNode starting node
     * @return found node, or null
     */
    private TreeNode<T> find(T key, TreeNode<T> fromNode)
    {
        if(key.compareTo(fromNode.getKey()) == 0)
            return fromNode;

        TreeNode<T> res = null;
        if(fromNode.getLeftNode() != null)
        {
            res = find(key,fromNode.getLeftNode());
        }
        if(res == null && fromNode.getRightNode() != null)
        {
            res = find(key,fromNode.getRightNode());
        }
        return res;
    }

    /**
     * Insert a node.
     * If newNode.key > startNode.key -> to the right side.
     * If newNode.key < startNode.key -> to the left side.
     * Else: update startNode.value
     * @param newNode newNode
     * @param startNode startNode
     */
    private void insertTreeNote(TreeNode<T> newNode,TreeNode<T> startNode)
    {
        if(newNode != null)
        {
            if(newNode.getRightNode() != null || newNode.getLeftNode() != null)
            {
                throw new UnsupportedOperationException("Sorry, cannot insert node that has children at this point.");
            }

            int compare = newNode.getKey().compareTo(startNode.getKey());
            if(compare > 0)
            {
                if(startNode.getRightNode() == null)
                {
                    startNode.setRightNode(newNode);
                }
                else
                {
                    // traverse right node
                    insertTreeNote(newNode,startNode.getRightNode());
                }
            }
            else if(compare < 0)
            {
                if(startNode.getLeftNode() == null)
                {
                    startNode.setLeftNode(newNode);
                }
                else
                {
                    // traverse left node
                    insertTreeNote(newNode,startNode.getLeftNode());
                }
            }
            else
            {
                // update value
                startNode.setValue(newNode.getValue());
            }
        }
    }

    private int size(TreeNode<T> node)
    {
        if(node == null)
            return 0;
        return node.size();
    }

    public BinarySearchTree(TreeNode<T> rootNode) {
        this.rootNode = rootNode;
    }

    private TreeNode<T> rootNode;


}
