package normal;

public class TreeNode<T extends Comparable<T>> {

    public int size()
    {
        int res = 1;
        if(leftNode != null )
        {
            res += leftNode.size();
        }
        if(rightNode != null )
        {
            res += rightNode.size();
        }
        return res;
    }

    public TreeNode(T key) {
        this.key = key;
    }
    public TreeNode(T key,Object value) {
        this.key = key;
        this.value = value;
    }

    public TreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;
    private T key;
    private Object value;

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
